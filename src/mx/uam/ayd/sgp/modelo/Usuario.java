package mx.uam.ayd.sgp.modelo;

public class Usuario {
	private String usuario;
	private String contraseña;
	private String tipoCuenta;
	private String nombre;
	private String apellidos;
	private String telefono;
	private int idEmpleado;
	
	
	public Usuario(String usuario, String contraseña, String tipoCuenta, String nombre, String apellidos, String telefono, int idEmpleado){
		this.contraseña = contraseña;
		this.usuario = usuario;
		this.tipoCuenta = tipoCuenta;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.telefono=telefono;
		this.idEmpleado=idEmpleado;
	}
	
	public String getUsuario(){
		return usuario;
	}
	public String getNombre() {
		return this.nombre + this.apellidos;
	}
	public String getContraseña(){
		return contraseña;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	
	

}
