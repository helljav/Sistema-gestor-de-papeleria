package mx.uam.ayd.sgp.negocio;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import mx.uam.ayd.practica7.modelo.Autor;
//import mx.uam.ayd.practica7.presentacion.DialogoSeleccionAutor;
import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaAñadirProducto;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaEliminarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaSeleccionAlmacen;

public class ControlAlmacen {

	private DAOProducto dao;
	private String tipoAlmacen;
	private VentanaAñadirProducto GUIAgregarP;
	private VentanaEliminarProducto GUIEliminarP;

	public ControlAlmacen() {
		dao = new DAOProducto();
	}

	public void iniciaSeleccionDeAlmacen() {
		VentanaSeleccionAlmacen GUI = new VentanaSeleccionAlmacen(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}

	public void DespliegaVCRUD(String tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
		VentanaCRUDAlmacen GUI = new VentanaCRUDAlmacen(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}

	public void DespliegaVAñadirAlamcen() {
		GUIAgregarP = new VentanaAñadirProducto(this);
		GUIAgregarP.setVisible(true);
		GUIAgregarP.setLocationRelativeTo(null);

	}
	public void DespliegaVEliminarProducto() {
		GUIEliminarP = new VentanaEliminarProducto(this);
		GUIEliminarP.setVisible(true);
		GUIEliminarP.setLocationRelativeTo(null);

	}

	public String getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void agregarProducto(String nombre, double precio, String descripcion, int cantidad, double descuento,String fecha, String tipoAlmacen) {
		try {
			Producto P = new Producto(nombre, precio, descripcion, descuento);
			Almacen A = new Almacen(P, cantidad, fecha, tipoAlmacen);
			dao.agregarAlAlmacen(A);
			GUIAgregarP.alertaMensaje("Producto agregado al almacen", "Producto agregado", 1);
		} catch (Exception e) {
			GUIAgregarP.alertaMensaje("El producto no se pudo agregar al almacen", "Fatal error", 0);
		}

	}
	
	public Almacen buscarProducto(String productoABuscar, String tipoAlmacen) {
		//Se crea la lista de autores para poder mostrarle al usuario
		Almacen arregloProdutos[] = dao.dameProductos(productoABuscar, tipoAlmacen); // Obtiene lista de autores
		DialogoMostrarProducto dialogo = new DialogoMostrarProducto(new JFrame(), arregloProdutos); // Crea el dialogo con
																									// la lista de
																									// autores
		dialogo.setVisible(true); // Muestra el dialogo
		return dialogo.getProductoSeleccionado(); // Regresa el autor seleccionado en el dialogo
	}

}
