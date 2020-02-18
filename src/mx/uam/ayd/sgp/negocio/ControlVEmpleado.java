package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.presentacion.VentanaAdminPedido;
import mx.uam.ayd.sgp.presentacion.VentanaPrincipalEmpleado;

public class ControlVEmpleado {
	private VentanaPrincipalEmpleado GUI;
	private VentanaAdminPedido GUIVPedido;
	private ControlRealizaVenta ctrlVenta;
	private ControlVentaPedido ctrlPedido;

	ControlVEmpleado() {
		ctrlVenta = new ControlRealizaVenta();
		ctrlPedido = new ControlVentaPedido();
	}

	public void inicia() {
		GUI = new VentanaPrincipalEmpleado(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}

	public void DespliegaVCRUDPedido() {
		ctrlPedido.DespliegaVCRUD();
	}

	public void iniciaVenta() {
		ctrlVenta.iniciarealizarventa();
	}

}
