package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.presentacion.VentanaAdminPedido;
import mx.uam.ayd.sgp.presentacion.VentanaPrincipalEmpleado;

public class ControlVEmpleado {
	private VentanaPrincipalEmpleado GUI;
	private VentanaAdminPedido GUIVPedido;
	ControlRealizaVenta ctrlVenta;
	ControlAlmacen ctrlAlmacen;
	
	ControlVEmpleado() {
		ctrlAlmacen= new ControlAlmacen();
		ctrlVenta=new ControlRealizaVenta();
	}

	public void inicia() {
		GUI = new VentanaPrincipalEmpleado(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	public void iniciaVAdminPedido() {
		GUIVPedido = new VentanaAdminPedido(this);
		GUIVPedido.setVisible(true);
		GUIVPedido.setLocationRelativeTo(null);
		
	}
	public void iniciaVenta() {
		ctrlVenta.iniciarealizarventa();
	}
	
}
