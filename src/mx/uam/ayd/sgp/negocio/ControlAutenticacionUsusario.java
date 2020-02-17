package mx.uam.ayd.sgp.negocio;

import javax.swing.JOptionPane;

import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.presentacion.VentanaIniciarSesion;

public class ControlAutenticacionUsusario {
	DAOUsuario UserDAO;
	VentanaIniciarSesion GUI;

	// Constructor
	public ControlAutenticacionUsusario() {
	}

	public ControlAutenticacionUsusario(DAOUsuario dao) {
		UserDAO = dao;
	}

	/**
	 * Metodo que inicia la ventana llamado por el control principal (Aplicacion)
	 */
	public void Inicia() {
		GUI = new VentanaIniciarSesion(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}

	/**
	 * Este metodo es utilizado por la ventana al momento de que el cliente da clic
	 * en LOGIN
	 * 
	 * @param usuario:
	 *            Ususario que proporciona el cliente desde la ventana
	 * @param contraseña:Contraseña
	 *            que porporciona el cliente desde la ventana
	 */
	public void Autentifica(String usuario, String contraseña) {
		try {
			Usuario bandera = UserDAO.Autentifica(usuario, contraseña);
			System.out.println(bandera);
			System.out.println(bandera.getTipoCuenta());
			if (bandera.getTipoCuenta().equals("ADMINISTRADOR")) {
				ControlVAdministrador ctrl = new ControlVAdministrador();
				ctrl.inicia();
				GUI.setVisible(false);

			} else if (bandera.getTipoCuenta().equals("EMPLEADO")) {
				ControlVEmpleado ctrl = new ControlVEmpleado();
				ctrl.inicia();
				GUI.setVisible(false);
			}
		} catch (Exception e) {
			GUI.alertaMensaje();

		}

	}

}
