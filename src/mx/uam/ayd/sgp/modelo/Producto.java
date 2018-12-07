package mx.uam.ayd.sgp.modelo;

public class Producto {
	
	private String nombreProd;
	private double precio;
	private String descripcion;
	private double descuento;
	
	public Producto(String nombreProd,double precio, String descripcion,double descuento) {
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.descripcion = descripcion;
		this.descuento = descuento;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getNombreProd() {
		return nombreProd;
	}
	public double descuento() {
		return descuento;
	}
	public double getPrecio() {
		return precio;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
}
