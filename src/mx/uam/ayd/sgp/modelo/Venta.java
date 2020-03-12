package mx.uam.ayd.sgp.modelo;

public class Venta {

	private int numFolio;
	private String fechaVenta;
	private String empleado;
	private Double importe;
	// private Usuario usuario

	public Venta(/* Usuario usuario, */ String fechaVenta, String empleado, double importe) {

		this.fechaVenta = fechaVenta;
		this.empleado = empleado;
		this.importe = importe;
	}

	public Venta() {

	}

	public String toString() {
		return "Numero de Folio : " + this.numFolio + "\n\n " 
				+"   |||Importe de Venta : " + this.importe + "\n\n"
				+"   |||Quien lo atendio :  " + this.empleado/* usuario.getNombre() */ 
				+"   |||Fecha de Venta : " + this.fechaVenta;
	}

	public int getNumFolio() {
		return numFolio;
	}

	public void setNumFolio(int numFolio) {
		this.numFolio = numFolio;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	// TOMAR LA CLASE USUARIO PARA ELLO
	public String getEmpleado() {
		return empleado;
		/* usuario.getNombre() */
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	/*
	 * public Usuario getUsuario() { return usuario; }
	 */

}
