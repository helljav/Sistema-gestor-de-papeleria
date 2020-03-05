package mx.uam.ayd.sgp.modelo;

public class Pedido {

	private int numPedido;
	private String fechaPedido;
	private String empleado;
	//private String producto;
	private String nombreCliente;
	private String apellidoCliente;
	private double importeTotal;
	private double importeDejado;

	
	@Override
	public String toString() {
		return "Pedido [numPedido=" + numPedido + ", fechaPedido=" + fechaPedido + ", empleado=" + empleado
				+ ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", importeTotal="
				+ importeTotal + ", importeDejado=" + importeDejado + "]";
	}

	

	public Pedido(String fechaPedido, String nombreCliente, String apellidoCliente, double importeTotal,
			double importeDejado,String empleado) {
		
		this.fechaPedido = fechaPedido;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.importeTotal = importeTotal;
		this.importeDejado = importeDejado;
		this.empleado = empleado;
	}


	/**
	 * Constructor que utilizo al obtener los pedidos de la BD
	 * @param numpedido int 
	 * @param fecha String
	 * @param empleado String
	 * @param nombre String
	 * @param apellido String
	 * @param importeT double
	 * @param importeD double
	 * @author Hector Hernan Dominguez Gonzalez
	 * **/
	public Pedido(int numpedido, String fecha, String empleado, String nombre, String apellido, double importeT, double importeD) {
		this.numPedido=numpedido;
		this.fechaPedido=fecha;
		this.empleado=empleado;
		this.nombreCliente=nombre;
		this.apellidoCliente=apellido;
		this.importeTotal=importeT;
		this.importeDejado=importeD;
		
	}



	public int getNumPedido() {
		return numPedido;
	}
	
	public String getFechaPedido() {
		return fechaPedido;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	
	public double getImporteTotal() {
		return importeTotal;
	}
	
	public double getImporteDejado() {
		return importeDejado;
	}
	
	public void setNumPedido(int numPedido) {
		this.numPedido=numPedido;
	}
	
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido=fechaPedido;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente=nombreCliente;
	}
	
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente=apellidoCliente;
	}
	
	public void setImporteTotal(double importeTotal) {
		this.importeTotal=importeTotal;
	}
	
	public void setImporteDejado(double importeDejado) {
		this.importeDejado=importeDejado;
	}



	public String getEmpleado() {
		return empleado;
	}



	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
}
