package mx.uam.ayd.sgp.modelo;

public class Producto {
	
	private String nombreProd;
	private double precio;
	private String descripcion;
	private int idProducto;
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getNombreProd() {
		return nombreProd;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
}
