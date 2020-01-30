package mx.uam.ayd.sgp.modelo;

public class Usuario {
	private String usuario;
	private String contraseña;
	private String tipoCuenta;
	private String nombre;
	private String apellidos;
	private String telefono;
	private int idEmpleado;
	
	
	public Usuario(String usuario, String contraseña, String tipoCuenta){
		this.contraseña = contraseña;
		this.usuario = usuario;
		this.tipoCuenta = tipoCuenta;
		
	}
	
	public String getUsuario(){
		return usuario;
	}
	public String getContraseña(){
		return contraseña;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	
	

}
