package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.VentanaIniciarSesion;
import mx.uam.ayd.sgp.presentacion.VentanaPrincipalAdministrador;

public class ControlVAdministrador {
	
	ControlAlmacen ctrl;
	DAOProducto dao;
	
	ControlVAdministrador(){
		
	}
	
	public void inicia() {
		VentanaPrincipalAdministrador GUI = new VentanaPrincipalAdministrador(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	public void DespliegaVSeleccion() {
		ctrl=new ControlAlmacen(dao);
		ctrl.iniciaSeleccionDeAlmacen();
	}
	
	
	
}
