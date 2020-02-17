package mx.uam.ayd.sgp.negocio;

import javax.swing.JFrame;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarProducto;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarUsuarios;
import mx.uam.ayd.sgp.presentacion.VentanaAddUser;
import mx.uam.ayd.sgp.presentacion.VentanaEliminarUsuario;
import mx.uam.ayd.sgp.presentacion.ventanaCRUDAdminUsuarios;
import mx.uam.ayd.sgp.presentacion.ventanaModificarUsuario;

public class ControlAdminUsuario {
	private static DAOUsuario dao;
	private ventanaCRUDAdminUsuarios GUICRUD;
	private static ventanaModificarUsuario GUIMU;
	private VentanaAddUser adduser;
	private VentanaEliminarUsuario GUIEraseUser;

	public ControlAdminUsuario() {
		dao = new DAOUsuario();
	}

	public void ventanaCRUDAdminUsuarios() {
		ventanaCRUDAdminUsuarios GUICRUD = new ventanaCRUDAdminUsuarios(this);
		GUICRUD.setVisible(true);
		GUICRUD.setLocationRelativeTo(null);
	}

	public void agregausuario() {
		adduser = new VentanaAddUser(this);
		adduser.setUndecorated(true);
		adduser.setVisible(true);
		adduser.setLocationRelativeTo(null);

	}

	public void DespliegaVModificarUsuario() {
		GUIMU = new ventanaModificarUsuario(this);
		GUIMU.setVisible(true);
		GUIMU.setLocationRelativeTo(null);

	}

	public void DespliegaVEliminaUsuario() {
		GUIEraseUser = new VentanaEliminarUsuario(this);
		GUIEraseUser.setVisible(true);
		GUIEraseUser.setLocationRelativeTo(null);

	}

	/**
	 * Este metodo sirve para buscar un usuario base al nombre del usuario o el id
	 * del empleado
	 * 
	 * @param usuarioABuscar
	 * @return Regresa el usuario seleccionado en el dialogo (Variable de tipo
	 *         usuario)
	 */
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
		return dialogo.getUsuarioSeleccionado(); // Regresa el usuario seleccionado en el dialogo
	}

	/**
	 * 
	 * @param usuario:
	 *            Es un objeto usuario el cual contiene los datos del nuevos datos
	 *            del usuario
	 * @param usuarioAnteiror:
	 *            Objeto tipo usuario el cual contiene los datos del usuario a quien
	 *            quieren modificar
	 * 
	 *            Se lo pasasmos al dao de usuarios y verificamos si se hizo los
	 *            cambios oportunos en la tabla de la base de datos
	 * 
	 */

	public static void modificarUsuario(Usuario usuario, Usuario usuarioAnteiror) {

		boolean bandera = true;
		try {
			bandera = dao.modificarUsuario(usuario, usuarioAnteiror);
			if (bandera) {
				GUIMU.alertaMensaje("El usuario fue modificado ", "Success exito", 1);
				GUIMU.setVisible(false);

			} else {
				GUIMU.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);
			}
		} catch (Exception e) {
			GUIMU.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);
		}

	}

	/**
	 * 
	 * @param usuario
	 * @return
	 */

	public void EliminarUsuario(Usuario usuario) {
		try {
			if (dao.EliminarUsuario(usuario)) {
				GUIEraseUser.alertaMensaje("El usuario fue eliminado del almacen ", "Success exito", 1);
				GUIEraseUser.setVisible(false);

			} else {
				GUIEraseUser.alertaMensaje("El usuario no se pudo eliminar del almacen ", "Error :(", 0);

			}

		} catch (Exception e) {
			GUIEraseUser.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);
		}

	}

	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param idempleado
	 * @param cargo
	 * @param user
	 * @param pass
	 * @return
	 */
	public boolean adduser(String nombre, String apellidos, String telefono, int idempleado, String cargo, String user,
			String pass) {
		dao = new DAOUsuario();
		Usuario useradd = new Usuario(user, pass, cargo, nombre, apellidos, telefono, idempleado);

		if (dao.agregaUsuario(useradd) == true) {
			return true;
		}
		return false;
	}

}
