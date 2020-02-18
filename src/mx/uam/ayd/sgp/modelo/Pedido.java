package mx.uam.ayd.sgp.modelo;

public class Pedido {

	private int numPedido;
	private String fechaPedido;
	//private String empleado;
	//private String producto;
	private String nombreCliente;
	private String apellidoCliente;
	private double importe;
	
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
	
	public double getImporte() {
		return importe;
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
	
	public void setImporte(double importe) {
		this.importe=importe;
	}
}
