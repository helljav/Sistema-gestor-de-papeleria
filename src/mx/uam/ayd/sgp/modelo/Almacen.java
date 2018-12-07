package mx.uam.ayd.sgp.modelo;

import java.util.Calendar;

public class Almacen {
	
	private int cantidad;
	private Producto producto;
	private Calendar fechaIngreso;
	private String tipoAlmacen;
	
	public Almacen(Producto producto,int cantidad,Calendar fechaIngreso,String tipoAlmacen) {
		this.setProducto(producto);
		this.cantidad = cantidad;
		this.setFechaIngreso(fechaIngreso);
		this.setTipoAlmacen(tipoAlmacen);
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int x) {
		cantidad=x;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void setTipoAlmacen(String tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}
	
	public String getNombreProducto() {
		String nombreProducto=producto.getNombreProd();
		return nombreProducto;
	}
	
	public double getPrecioProducto() {
		double precioProducto=producto.getPrecio();
		return precioProducto;
	}
	
	public String getDescripcionProducto() {
		String DescripcionProducto=producto.getDescripcion();
		return DescripcionProducto;
	}
	
	
	
	
	
}
