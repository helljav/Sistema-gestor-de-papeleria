package mx.uam.ayd.sgp;

import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.negocio.ControlAutenticacionUsusario;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.presentacion.VentanaIniciarSesion;

/**********************************************************************************************************************************
*	Proyecto de Analisis y Diseño de Sstemas (Sistema gestor de papeleria)                                           
*	Proyecto de Ingenieria de Software (StarShop)													                              *
*	Integrantes:  Carrillo Pacheco Francisco Javier 
*				  Contreras Vidal Maribel
*				  Dominguez Gonzalez Hector Hernan
*				  Iturbe Pineda Nancy Monserrat
*				  Morales Ocaranza Carlos Jesus																					  *	
*				  Oseguera Sanchez Eduardo																					      *	
*				  Raya Chula Ricardo
*					Holi profe																				              *
*				 
*					Hello
*				 
*				 
*							    																								  *
*																																  *
*																																  *	
**********************************************************************************************************************************/
/**
 * Esta clase se encarga de iniciar la aplicacion del sistema StarShop
 * 
 * @author *
 *
 */
public class Aplicacion {
	private DAOUsuario daousuario;
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
	 * Este metodo inicia la aplicacion e inicia primero la autentificacion del
	 * usuario llamando a la ventana IniciarSesion por medio del
	 * ControlAutenticacionUsuario
	 *
	 */
	public void inicia() {
		ControlAutenticacionUsusario iniciaAutentificacion = new ControlAutenticacionUsusario(daousuario);
		iniciaAutentificacion.Inicia();

	}
}
