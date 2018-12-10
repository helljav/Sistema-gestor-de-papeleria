package mx.uam.ayd.sgp.modelo;



public class Almacen {
	

	
	
	private int cantidadProducto;
	private String fechaIngresoProducto;
	private String tipoAlmacenProducto;
	private Producto producto;
	
	public Almacen(Producto producto,int cantidad,String fechaIngreso,String tipoAlmacen) {
		this.producto= producto;
		this.cantidadProducto = cantidad;
		this.fechaIngresoProducto= fechaIngreso;
		this.tipoAlmacenProducto= tipoAlmacen;
	}
	public String toString() {
  		return "Nombre: " +this.producto.getNombreProd()+"\n\n "
  				+"Precio: "+this.producto.getPrecio()+"\n\n "
  				+"Descripcion: "+this.producto.getDescripcion()+"\n\n"
  				+"Cantidad: "+this.cantidadProducto+"\n\n"
  				+"Descripcion del descuento: "+this.producto.getdescuento()+"\n\n"
  				+"Fecha de ingreso al almacen: "+this.fechaIngresoProducto+"\n\n";
  	}
	
	public void setNombre(String nombreProducto) {
		producto.setNombreProd(nombreProducto); 
	}
	
	public String getNombreProducto() {
		return producto.getNombreProd();
	}
	
	public void setPrecioProducto(double precioProducto) {
		this.producto.setPrecio(precioProducto);
		
	}
	public void setDescuento(double descuento) {
		this.producto.setDescuento(descuento);
	}
	public double getdescuento() {
		return producto.getdescuento();
	}
	
	public double getPrecioProducto() {
		
		return producto.getPrecio();
	}
	
	public void setdescripcionProducto(String descrpcionProducto) {
		this.producto.setDescripcion(descrpcionProducto);
		
	}
	
	public String getDescripcionProducto() {
		return producto.getDescripcion();
	}
	
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getFechaIngreso() {
		return fechaIngresoProducto;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngresoProducto = fechaIngreso;
	}

	public String getTipoAlmacen() {
		return tipoAlmacenProducto;
	}

	public void setTipoAlmacen(String tipoAlmacen) {
		this.tipoAlmacenProducto = tipoAlmacen;
	}
	
	
	
	public double getDesceuntoProducto() {
		double DescuentoProducto = producto.getdescuento();
		return DescuentoProducto;
	}
	
	
	
	
	
}
