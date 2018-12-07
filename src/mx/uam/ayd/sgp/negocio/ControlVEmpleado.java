package mx.uam.ayd.sgp.negocio;

import mx.uam.ayd.sgp.presentacion.VentanaPrincipalEmpleado;

public class ControlVEmpleado {

	ControlVEmpleado() {
	}

	public void inicia() {
		VentanaPrincipalEmpleado GUI = new VentanaPrincipalEmpleado(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
}
