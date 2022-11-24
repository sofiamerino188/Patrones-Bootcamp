package com.nttdatabootcamp;

import java.util.Observable;

public class Producto_hogar extends Producto {

	public int id;
	public String nombre;
	public int precio;

	public static final ProductoObservable OBSERVABLE = new ProductoObservable();

	public static Observable getObservable() {
		return OBSERVABLE;
	}

	public Producto_hogar(int id, String nombre, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto_hogar(ProductoBuilder productoBuilder) {
		this.id = productoBuilder.id;
		this.nombre = productoBuilder.nombre;
		this.precio = productoBuilder.precio;
	}
	
	@Override
	public int getid() {
		return id;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

	public void setPrecio(int precio) {
		PrecioEvent event = new PrecioEvent(this, this.precio, precio);

		this.precio = precio;

		synchronized (OBSERVABLE) {
			OBSERVABLE.setChanged();
			OBSERVABLE.notifyObservers(event);
		}
	}

	public static class ProductoBuilder {

		public int id;
		public String nombre;
		public int precio;

		public ProductoBuilder() {

		}

		public ProductoBuilder setNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public ProductoBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public ProductoBuilder setPrecio(int precio) {
			this.precio = precio;
			return this;
		}

		public Producto_hogar build() {
			return new Producto_hogar(this);
		}

	}

	public class PrecioEvent {

		public Producto_hogar producto;
		public int precioAntiguo;
		public int precioNuevo;

		public PrecioEvent(Producto_hogar producto, int precioAntiguo, int precioNuevo) {
			this.producto = producto;
			this.precioAntiguo = precioAntiguo;
			this.precioNuevo = precioNuevo;
		}

	}

	private static class ProductoObservable extends Observable {
		@Override
		public synchronized void setChanged() {
			super.setChanged();
		}
	}
}
