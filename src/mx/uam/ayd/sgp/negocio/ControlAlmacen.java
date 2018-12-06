package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.VentanaSeleccionAlmacen;

public class ControlAlmacen {
	
	DAOProducto dao;

	public ControlAlmacen(DAOProducto DAO) {
		dao=DAO;
	}
	
	public void iniciaSeleccionDeAlmacen() {
		VentanaSeleccionAlmacen GUI = new VentanaSeleccionAlmacen(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	
}
