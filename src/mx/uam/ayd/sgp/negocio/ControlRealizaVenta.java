package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.presentacion.VentanaRealizaVenta;

public class ControlRealizaVenta {
private VentanaRealizaVenta ventanarealizarventa;
	//se inicializa la ventana
	public void iniciarealizarventa() {
//		definir el constructor
		ventanarealizarventa= new VentanaRealizaVenta(this);
		ventanarealizarventa.setVisible(true);
		ventanarealizarventa.setLocationRelativeTo(null);
	}
}
