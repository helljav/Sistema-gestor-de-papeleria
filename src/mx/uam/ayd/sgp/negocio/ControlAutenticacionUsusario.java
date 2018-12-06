package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.presentacion.VentanaIniciarSesion;

public class ControlAutenticacionUsusario {
	DAOUsuario UserDAO;
	
	VentanaIniciarSesion GUI;
	
	public ControlAutenticacionUsusario (DAOUsuario dao) {
		UserDAO=dao;
	}
	
	public void Inicia() {
		GUI = new VentanaIniciarSesion(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	
	
	public void Autentifica(String usuario, String contraseña) {
		Usuario bandera = UserDAO.Autentifica(usuario,contraseña);
		System.out.println(bandera);
		System.out.println(bandera.getTipoCuenta());
		if(bandera.getTipoCuenta().equals("ADMINISTRADOR")) {
			ControlVAdministrador ctrl = new ControlVAdministrador();
			ctrl.inicia();
			GUI.setVisible(false);
			
		}
		
	}
	
	

}
