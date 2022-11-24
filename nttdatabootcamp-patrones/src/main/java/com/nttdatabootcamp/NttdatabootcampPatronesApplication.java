package com.nttdatabootcamp;

import java.util.Observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NttdatabootcampPatronesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NttdatabootcampPatronesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("----------Prueba Builder----------");
		Producto_hogar p = new Producto_hogar.ProductoBuilder().setId(1).setNombre("silla").setPrecio(26).build();
		
		System.out.println("producto: "+p.getid());
		System.out.println("nombre: "+p.getNombre());
		System.out.println("precio: "+p.getPrecio());
		
		System.out.println("----------Prueba Observer----------");
		Observer o1 = new ProductoObserver();
		Producto_hogar.getObservable().addObserver(o1);
		
		p.setPrecio(30);
		System.out.println("producto: "+p.getid());
		System.out.println("nombre: "+p.getNombre());
		System.out.println("precio: "+p.getPrecio());
	}

}
