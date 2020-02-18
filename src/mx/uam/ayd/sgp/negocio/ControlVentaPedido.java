package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.VentanaAdminPedido;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaModificarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaRealizaPedido;

public class ControlVentaPedido {
	//private DAOPedido dao;
	private VentanaRealizaPedido GUIRP;
	//private VentanaAgregarProductoVenta GUIAPV;
	private VentanaAdminPedido GUIVPedido;
	
	public ControlVentaPedido() {
//		dao = new DAOPedido();
	}


	
	public void IniciaVentanaPedido() {
		GUIRP = new VentanaRealizaPedido(this);
		GUIRP.setVisible(true);
		GUIRP.setLocationRelativeTo(null);
	}
	
	public void DespliegaVCRUD() {
		GUIVPedido = new VentanaAdminPedido(this);
		GUIVPedido.setVisible(true);
		GUIVPedido.setLocationRelativeTo(null);		
		
	}
	
	public void iniciaVentanaAgregarProducto() {
//		GUIVAPV = new VentanaAgregarProductoVenta(this);
//		GUIVAPV.setVisible(true);
//		GUIVAPV.setLocationRelativeTo(null);
		
	}

}
