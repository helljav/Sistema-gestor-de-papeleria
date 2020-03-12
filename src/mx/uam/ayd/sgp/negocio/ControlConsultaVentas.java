package mx.uam.ayd.sgp.negocio;

import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Venta;
import mx.uam.ayd.sgp.persistencia.DAOVenta;
import mx.uam.ayd.sgp.presentacion.VentanaConsultaVentas;

public class ControlConsultaVentas {
	private VentanaConsultaVentas ventanaconsultarventas = new VentanaConsultaVentas(this);
	private DAOVenta daoV;

	/**
	 * Constructor de la clase que inicializa el dao Ventas y la ventana Consultar
	 * Ventas
	 */
	public ControlConsultaVentas() {

		daoV = new DAOVenta();
		ventanaconsultarventas = new VentanaConsultaVentas(this);
	}

	/**
	 * Inicia la ventana Consultar Ventas
	 */
	public void iniciaConsultarVentas() {
		ventanaconsultarventas = new VentanaConsultaVentas(this);
		ventanaconsultarventas.setVisible(true);
		ventanaconsultarventas.setLocationRelativeTo(null);

	}

	/**
	 * Lita de Ventas donde recupera todos los datos que tiene una Venta
	 * 
	 * @return regresa la lista de todas las ventas
	 */
	public ArrayList<Venta> recuperaVentas(String fecha) {
		try {
			ArrayList<Venta> lista = new ArrayList();
			lista = (ArrayList<Venta>) daoV.recuperaTodos(fecha);
			ventanaconsultarventas.llenarT(lista);

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
