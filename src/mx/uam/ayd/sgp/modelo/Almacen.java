package mx.uam.ayd.sgp.modelo;



public class Almacen {
	
	private int cantidad;
	private Producto producto;
	private String fechaIngreso;
	private String tipoAlmacen;
	
	public Almacen(Producto producto,int cantidad,String fechaIngreso,String tipoAlmacen) {
		this.producto= producto;
		this.cantidad = cantidad;
		this.fechaIngreso= fechaIngreso;
		this.tipoAlmacen= tipoAlmacen;
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

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
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
	public double getDesceuntoProducto() {
		double DescuentoProducto = producto.getdescuento();
		return DescuentoProducto;
	}
	
	
	
	
	
}
