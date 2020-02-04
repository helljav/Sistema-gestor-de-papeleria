package mx.uam.ayd.sgp.modelo;

public class Venta {

	private int numFolio;
	private String fechaVenta;
	private String empleado;
	private int importe;
	//private Usuario usuario
	
	public Venta(/*Usuario usuario, */int numFolio, String fechaVenta, String empleado, int importe) {
		//this.usuario=usuario;
		this.numFolio=numFolio;
		this.fechaVenta=fechaVenta;
		this.empleado=empleado;
		this.importe=importe;
	}
	
	public String toString() {
  		return "numFolio: " +this.numFolio+"\n\n "
  				+"Importe de Venta: "+this.importe+"\n\n"
  				+"Quien lo atendio: "+this.empleado/*usuario.getNombre()*/+"\n\n"
  				+"Fecha de Venta: "+this.fechaVenta+"\n\n";
  	}
	
	public int getNumFolio(){
		return numFolio;
	}
	
	public void setNumFolio(int numFolio) {
		this.numFolio=numFolio;
	}
	
	public String getFechaVenta() {
		return fechaVenta;
	}
	
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta=fechaVenta;
	}
	
	//TOMAR LA CLASE USUARIO PARA ELLO
	public String getEmpleado() {
		return empleado;
		/*usuario.getNombre()*/
	}
	
	public void setEmpleado(String empleado) {
		this.empleado=empleado;
	}
	
	public int getImporte() {
		return importe;
	}
	
	public void setImporte(int importe) {
		this.importe=importe;
	}
	
	/*public Usuario getUsuario() {
		return usuario;
	}*/
	
}
