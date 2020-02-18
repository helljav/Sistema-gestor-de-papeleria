package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.modelo.Pedido;
import mx.uam.ayd.sgp.persistencia.DAOPedidos;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.VentanaAdminPedido;
import mx.uam.ayd.sgp.presentacion.VentanaAgregarProductoVenta;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaModificarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaRealizaPedido;

public class ControlVentaPedido {
	private DAOPedidos dao;
	private VentanaRealizaPedido GUIRP;
	private ControlRealizaVenta crtlRV;
	private VentanaAdminPedido GUIVPedido;
	private Pedido ped;
	
	public ControlVentaPedido() {
		dao = new DAOPedidos();
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
		crtlRV = new ControlRealizaVenta();
		crtlRV.iniciaVAPV();
		
	}
	
	public boolean realizaPedido(String fecha, String nombre, String apellido, double importeDejado, double importeTotal, String empleado ) {
		ped = new Pedido(fecha,nombre,apellido,importeTotal,importeDejado, empleado);
		dao.almacenaPedido(ped);
		return true;
		
	}

}
