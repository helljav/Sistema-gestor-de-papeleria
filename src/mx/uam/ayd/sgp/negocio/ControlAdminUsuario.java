package mx.uam.ayd.sgp.negocio;
import javax.swing.JFrame;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarProducto;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarUsuarios;
import mx.uam.ayd.sgp.presentacion.VentanaAddUser;
import mx.uam.ayd.sgp.presentacion.ventanaCRUDAdminUsuarios;
import mx.uam.ayd.sgp.presentacion.ventanaModificarUsuario;
import mx.uam.ayd.sgp.presentacion.VentanaEliminarUsuario;
import mx.uam.ayd.sgp.presentacion.VentanaIniciarSesion;



public class ControlAdminUsuario {
	private static DAOUsuario dao;
	private ventanaCRUDAdminUsuarios GUICRUD;
	private static ventanaModificarUsuario GUIMU;
	VentanaAddUser adduser;
	
	

	//Constructor
	public ControlAdminUsuario() {}
	
	public ControlAdminUsuario(DAOUsuario dao) {
		dao = new DAOUsuario();
	}
	
	
	public void ventanaCRUDAdminUsuarios() {
		ventanaCRUDAdminUsuarios GUICRUD = new ventanaCRUDAdminUsuarios(this);
		GUICRUD.setVisible(true);
		GUICRUD.setLocationRelativeTo(null);
	}
	public void agregausuario() {
		adduser=new VentanaAddUser(this);
		adduser.setUndecorated(true);
		adduser.setVisible(true);
		adduser.setLocationRelativeTo(null);
		
	}
	
	
	public void DespliegaVModificarUsuario(){
		ventanaModificarUsuario GUIMU = new ventanaModificarUsuario(this);
		GUIMU.setVisible(true);
		GUIMU.setLocationRelativeTo(null);
		
	}
	



	public void DespliegaVEliminaUsuario() {
		VentanaEliminarUsuario GUI =new VentanaEliminarUsuario(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
		
	}	
	
	public static Usuario buscarUsuario(String usuarioABuscar) {
		
		// Se crea la lista de autores para poder mostrarle al usuario
		Usuario arregloUsuarios[] = dao.dameUsuarios(usuarioABuscar); // Obtiene lista de autores
		DialogoMostrarUsuarios dialogo = new DialogoMostrarUsuarios(new JFrame(), arregloUsuarios); // Crea el dialogo
																									// con la lista de
																									// productos
		if (arregloUsuarios.length == 0) {
			GUIMU.alertaMensaje("No se encontro el usuario", "Error", 0);
		} else {
			dialogo.setVisible(true); // Muestra el dialogo
		}
		return dialogo.getUsuarioSeleccionado(); // Regresa el autor seleccionado en el dialogo
	}
	
	public boolean EliminarUsuario(Usuario usuario) {
		dao = new DAOUsuario();
		if(dao.EliminarUsuario(usuario)) {
			return true;	
		}
		
		return false;
	}
	public boolean adduser(String nombre,String apellidos,String telefono,int idempleado,String cargo,String user,String pass) {
		dao=new DAOUsuario();
		Usuario useradd=new Usuario(user,pass,cargo,nombre,apellidos,telefono,idempleado);	
		
		if(dao.agregaUsuario(useradd)==true) {
			return true;
		}
		return false;
	}
	
}
