package mx.uam.ayd.sgp.modelo;

public class Usuario {
	private String usuario;
	private String contraseña;
	private String tipoCuenta;
	private String nombre;
	private String apellidos;
	private String telefono;
	private int idEmpleado;

	public Usuario() {
		/* Constructor */

	}

	public Usuario(String usuario, String contraseña, String tipoCuenta, String nombre, String apellidos,
			String telefono, int idEmpleado) {
		this.contraseña = contraseña;
		this.usuario = usuario;
		this.tipoCuenta = tipoCuenta;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.idEmpleado = idEmpleado;

	}

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public String getIdEmpleado() {
		return Integer.toString(this.idEmpleado);
	}

	public String getNombreC() {
		return this.nombre + this.apellidos;
	}

	public String toString() {
		return "Usuario: " + this.getUsuario() + "\n\n " + "  |||Contraseña: " + this.getContraseña() + "\n\n "
				+ "  |||Cuenta: " + this.getTipoCuenta() + "\n\n" + "  |||Nombre: " + this.getNombre() + "\n\n"
				+ "  |||Apellidos: " + this.getApellidos() + "\n\n" + "  |||Telefono: " + this.getTelefono() + "\n\n"
				+ "  |||IDEmpleado: " + this.getIdEmpleado() + "\n\n";
	}

}
