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
import mx.uam.ayd.sgp.presentacion.MenuProvedor_Almacen;
import mx.uam.ayd.sgp.presentacion.VentanaAgregarProductoVenta;
import mx.uam.ayd.sgp.presentacion.VentanaAñadirProducto;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaEliminarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaMenuProveedores;
import mx.uam.ayd.sgp.presentacion.VentanaModificarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaSeleccionAlmacen;

public class ControlAlmacen {

	private DAOProducto dao;
	private String tipoAlmacen;
	private VentanaAñadirProducto GUIAgregarP;
	private VentanaEliminarProducto GUIEliminarP;
	private VentanaModificarProducto GUIModificarP;
	private VentanaMenuProveedores GUIMenuP;
	private VentanaAgregarProductoVenta ventanaAgregarProductoVenta;

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
	public void DespliegaVCRUDProveedores() {
		GUIMenuP = new VentanaMenuProveedores(this);
		GUIMenuP.setVisible(true);
		GUIMenuP.setLocationRelativeTo(null);
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

	public void DespliegaVModificarProducto() {
		GUIModificarP = new VentanaModificarProducto(this);
		GUIModificarP.setVisible(true);
		GUIModificarP.setLocationRelativeTo(null);

	}

	public String getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void agregarProducto(String nombre, double precio, String descripcion, int cantidad, double descuento,
			String fecha, String tipoAlmacen) {
		try {
			Producto P = new Producto(nombre, precio, descripcion, descuento);
			Almacen A = new Almacen(P, cantidad, fecha, tipoAlmacen);
			dao.agregarAlAlmacen(A);
			GUIAgregarP.alertaMensaje("Producto agregado al almacen", "Producto agregado", 1);
			GUIAgregarP.setVisible(false);
		} catch (Exception e) {
			GUIAgregarP.alertaMensaje("El producto no se pudo agregar al almacen", "Fatal error", 0);
		}
	}

	public Almacen buscarProducto(String productoABuscar, String tipoAlmacen) {
		// Se crea la lista de autores para poder mostrarle al usuario
		Almacen arregloProdutos[] = dao.dameProductos(productoABuscar, tipoAlmacen); // Obtiene lista de autores
		DialogoMostrarProducto dialogo = new DialogoMostrarProducto(new JFrame(), arregloProdutos); // Crea el dialogo
		// con la lista de
		// productos
		if (arregloProdutos.length == 0) {
			GUIEliminarP.alertaMensaje("No se encontro el producto en este almacen", "Error", 0);
		} else {
			dialogo.setVisible(true); // Muestra el dialogo
		}
		return dialogo.getProductoSeleccionado(); // Regresa el autor seleccionado en el dialogo
	}
	////////////////////////////////////////////////////////

	public Almacen buscarProductoVenta(String productoABuscar) {

		Almacen arregloProdutos[] = dao.dameProduc(productoABuscar); // Obtiene lista de autores
		DialogoMostrarProducto dialogo = new DialogoMostrarProducto(new JFrame(), arregloProdutos); // Crea el dialogo
		// con la lista de
		// productos
		if (arregloProdutos.length == 0) {
			ventanaAgregarProductoVenta = new VentanaAgregarProductoVenta();
			ventanaAgregarProductoVenta.alertaMensaje("No se encontro el producto en este almacen", "Error", 0);
		} else {
			dialogo.setVisible(true); // Muestra el dialogo
		}
		return dialogo.getProductoSeleccionado(); // Regresa el autor seleccionado en el dialogo
	}

	///////////////////////////////////////////////////////

	public void eliminarProducto(Almacen producto) {
		try {
			if (dao.eliminarDeAlmacen(producto)) {
				GUIEliminarP.alertaMensaje("El producto fue eliminado del almacen " + producto.getTipoAlmacen(),
						"Success exito", 1);
				GUIEliminarP.setVisible(false);
			} else {
				GUIEliminarP.alertaMensaje("El producto no se pudo eliminar del almacen " + producto.getTipoAlmacen(),
						"Error :(", 0);

			}

		} catch (Exception e) {
			GUIEliminarP.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);

		}

	}

	public void modificarProducto(Almacen producto, Almacen productoAnteiror) {
		boolean bandera;
		try {
			bandera = dao.modificarProducto(producto, productoAnteiror);
			if (bandera) {
				GUIModificarP.alertaMensaje("El producto fue modificado de " + producto.getTipoAlmacen(),
						"Success exito", 1);
				GUIModificarP.setVisible(false);
			} else {
				GUIModificarP.alertaMensaje("El producto no se pudo modificar del almacen " + producto.getTipoAlmacen(),
						"Error :(", 0);
			}
		} catch (Exception e) {
			GUIModificarP.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);
		}

	}

	/**
	 * Metodo que pasa los elementos a modificar de la cantidad de porductos que hay
	 * en el almacen
	 * 
	 * @param producto
	 * @param cantidad
	 */

	public void modificarProductocantidad(Almacen producto, int cantidad) {
		boolean bandera;
		bandera = dao.modificarProductocantidad(producto, cantidad);
	}

}
