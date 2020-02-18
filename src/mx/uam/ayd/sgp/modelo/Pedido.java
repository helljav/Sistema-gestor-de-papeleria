package mx.uam.ayd.sgp.modelo;

public class Pedido {

	private int numPedido;
	private String fechaPedido;
	//private String empleado;
	//private String producto;
	private String nombreCliente;
	private String apellidoCliente;
	private double importeTotal;
	private double importeDejado;
	
	public Pedido() {
		
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
}
