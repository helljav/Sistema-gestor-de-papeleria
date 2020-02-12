package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.persistencia.DAOVenta;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaConsultaVentas;
import mx.uam.ayd.sgp.presentacion.VentanaIniciarSesion;
import mx.uam.ayd.sgp.presentacion.VentanaPrincipalAdministrador;

public class ControlVAdministrador {
	private VentanaConsultaVentas ventanaconsultarventas; 
	ControlAlmacen ctrlAlmacen;
	ControlConsultaVentas ctrlconsultaventas;
	 DAOVenta daoVentas; 
	DAOProducto dao;
	
	ControlVAdministrador(){
		ctrlAlmacen=new ControlAlmacen();
	}
	
	public void inicia() {
		VentanaPrincipalAdministrador GUI = new VentanaPrincipalAdministrador(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	public void DespliegaVSeleccion() {		
		ctrlAlmacen.iniciaSeleccionDeAlmacen();
	}
	 public void iniciaConsultarVentas() {
		 	ctrlconsultaventas=new ControlConsultaVentas();
		 	
		}
	
	
	
}
