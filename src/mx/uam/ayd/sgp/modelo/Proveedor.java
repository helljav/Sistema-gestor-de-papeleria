package mx.uam.ayd.sgp.modelo;

public class Proveedor {
	
	private String Nombre_Empresa;
	private String Correo_Electronico;
	private String Numero_Telefonico;
	private String Descripcion;
	private int idproveedor;
	
	public Proveedor(String Nombre_Empresa,String Correo_Electronico, String Numero_Telefonico, String Descripcion) {
		this.Nombre_Empresa =Nombre_Empresa;
		this.Correo_Electronico=Correo_Electronico;
		this.Numero_Telefonico=Numero_Telefonico;
		this.Descripcion=Descripcion;
		
	}
	public Proveedor(int idProveedor,String Nombre_Empresa,String Correo_Electronico, String Numero_Telefonico, String Descripcion) {
		this.idproveedor=idProveedor;
		this.Nombre_Empresa =Nombre_Empresa;
		this.Correo_Electronico=Correo_Electronico;
		this.Numero_Telefonico=Numero_Telefonico;
		this.Descripcion=Descripcion;
	}
	/*Constructor*/
	public Proveedor() {}
	
	
	public String  getNombre_Empresa() {
		return Nombre_Empresa;
	}
	public int getidproveedor() {
		return this.idproveedor;
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
