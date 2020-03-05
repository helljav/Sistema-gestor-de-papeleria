package mx.uam.ayd.sgp.modelo;

public class Proveedor {
	
	private String Nombre;
	private String Correo_Electronico;
	private String Apellido;
	private String Numero_Telefonico;
	private String Descripcion;
	
	public Proveedor(String Nombre_Empresa,String Apellido,String Correo_Electronico, String Numero_Telefonico, String Descripcion) {
		this.Nombre =Nombre_Empresa;
		this.Correo_Electronico=Correo_Electronico;
		this.Apellido =Apellido;
		this.Numero_Telefonico=Numero_Telefonico;
		this.Descripcion=Descripcion;
		
	}
	/*Constructor*/
	public Proveedor() {}
	
	
	public String  getNombre() {
		return Nombre;
	}
	public String getApellido() {
		return Apellido;
		
	}
	public String getCorreo_Electronico() {
		return Correo_Electronico;
	}
	public String getNumero_Telefonico() {
		return Numero_Telefonico;
	}
	public String getDescripcion() {
		return Descripcion;
	}

}
