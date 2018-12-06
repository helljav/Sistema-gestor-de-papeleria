package mx.uam.ayd.sgp;

import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.negocio.ControlAutenticacionUsusario;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.presentacion.VentanaIniciarSesion;

/**********************************************************************************************************************************
*	Proyecto de Analisis y Diseño de Sstemas (Sistema gestor de papeleria)														  *
*	Integrantes: Morales Ocaranza Carlos Jesus																					  *																						  *
*				 Iturbe Pineda Nancy Monserrat																					  *	
*				 Carrillo Pacheco Francisco Javier																				  *
*				 Raya Chula Ricardo
*							    																								  *
*																																  *
*																																  *	
**********************************************************************************************************************************/

public class Aplicacion {
	private DAOUsuario daousuario;
	//Prueba
	private Usuario user;

	public static void main(String[] args) {
		
		Aplicacion app = new Aplicacion();
		app.inicia();

	}
	/**
	* Este metodo es el constructor
	*
	*/
	public Aplicacion() {
		
		daousuario = new DAOUsuario(); 
	}
	
	/**
	* Este metodo inicia la aplicaciÃ³n
	*
	*/
	public void inicia() {
		ControlAutenticacionUsusario iniciaAutentificacion = new ControlAutenticacionUsusario(daousuario);
		iniciaAutentificacion.Inicia();	
		/**VentanaIniciarSesion GUI = new VentanaIniciarSesion(this);
		GUI.setVisible(true);;
		GUI.setLocationRelativeTo(null);**/
		 
	}
	
	public void validarUsuario(String usuario, String contraseña) {
		ControlAutenticacionUsusario iniciaAutentificacion = new ControlAutenticacionUsusario(daousuario);
		iniciaAutentificacion.Autentifica(usuario, contraseña);
		
	}

}
