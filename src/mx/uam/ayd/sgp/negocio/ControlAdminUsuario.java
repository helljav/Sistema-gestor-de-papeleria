package mx.uam.ayd.sgp.negocio;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.presentacion.VentanaAddUser;

public class ControlAdminUsuario {
	
	 DAOUsuario daouser;
	 VentanaAddUser adduser;
	 
	 public ControlAdminUsuario() {}
	 
	 public ControlAdminUsuario(DAOUsuario dao) {
		 daouser=dao;
	 }
	 /**
	  * Metodo que inicia la ventana de registro del usuario
	  * **/
	public void inicia() {
		adduser=new VentanaAddUser();
		adduser.setVisible(true);
		adduser.setLocationRelativeTo(null);
	}
	
	
	public boolean adduser(String nombre,String apellidos,String telefono,int idempleado,String cargo,String user,String pass) {
		daouser=new DAOUsuario();
		Usuario useradd=new Usuario(user,pass,cargo,nombre,apellidos,telefono,idempleado);	
		
		if(daouser.agregaUsuario(useradd)==true) {
			return true;
		}
		return false;
	}
}
