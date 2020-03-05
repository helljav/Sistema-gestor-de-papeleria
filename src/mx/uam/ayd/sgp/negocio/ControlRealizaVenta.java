package mx.uam.ayd.sgp.negocio;

import javax.swing.JFrame;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Venta;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.persistencia.DAOVenta;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaAgregarProductoVenta;
import mx.uam.ayd.sgp.presentacion.VentanaRealizaVenta;

public class ControlRealizaVenta {
	private VentanaRealizaVenta ventanarealizarventa;
	private VentanaAgregarProductoVenta ventanaAgregarProductoVenta;
	private DAOProducto dao;
	private DAOVenta daoV;
	ControlAlmacen controlAlmacen;
	private String Nombre;
	public boolean bandera;

	/**
	 * Constructor de la clase que inicializa el dao Venta
	 */
	public ControlRealizaVenta() {
		daoV = new DAOVenta();
	}

	/**
	 * Metodo que inicializa la Ventana Agregar Producto a venta
	 */
	public void iniciaVAPV() {
		controlAlmacen = new ControlAlmacen();
		ventanaAgregarProductoVenta = new VentanaAgregarProductoVenta(controlAlmacen, this, ventanarealizarventa);
		ventanaAgregarProductoVenta.setVisible(true);
		ventanaAgregarProductoVenta.setLocationRelativeTo(null);

	}

	/**
	 * Metodo que inicializa la clase Ventana Realizar Venta
	 */
	public void iniciarealizarventa() {
		// definir el constructor
		ventanarealizarventa = new VentanaRealizaVenta(this);
		ventanarealizarventa.setVisible(true);
		ventanarealizarventa.setLocationRelativeTo(null);
	}

	/**
	 * Manda datos al dao agregar una venta para que se guarde y posteriormente se
	 * muestre en consultar ventas
	 * 
	 * @param fechaVenta
	 * @param empleado
	 *            Nombre del empleado
	 * @param importe
	 *            importe de la venta final
	 */
	public void agregarProductoVenta(String fechaVenta, String empleado, double importe) {
		try {
			Venta V = new Venta(fechaVenta, empleado, importe);
			daoV.agregarAVenta(V);
			ventanarealizarventa.alertaMensaje("Producto agregado al almacen", "Producto agregado", 1);
			ventanarealizarventa.setVisible(false);
		} catch (Exception e) {
			ventanarealizarventa.alertaMensaje("El producto no se pudo agregar al almacen", "Fatal error", 0);
		}
	}

	/**
	 * Mensaje de aviso para saber si se guardo bien el producto o no
	 * 
	 * @param producto
	 */
	public void agregarProductoAviso(Almacen producto) {
		try {
			System.out.println(producto.getNombreProducto() + " " + producto.getFechaIngreso());
			ventanaAgregarProductoVenta.alertaMensaje("Producto agregado a la venta", "Producto agregado", 1);
			ventanaAgregarProductoVenta.setVisible(false);
		} catch (Exception e) {
			ventanaAgregarProductoVenta.alertaMensaje("El producto no se pudo agregar a la venta", "Fatal error", 0);
		}

	}

	/**
	 * Son los datos del empleado que se van guardando para poder mostrarlo en las
	 * tablas
	 * 
	 * @param Nombre
	 */
	public void empleadoaut(String Nombre) {
		this.Nombre = Nombre;
	}

	/**
	 * Devuelve el empleado
	 * 
	 * @return Nombre del empleado
	 */
	public String getempleadoaut() {
		return Nombre;
	}

	/**
	 * Aqui se hacen los calculos del descuento que el empleado selecciono
	 * 
	 * @param descuento
	 * @return descuento final
	 */
	public double realizadescuento(double descuento) {
		String Importe = ventanarealizarventa.textFieldImporteFinal.getText().toUpperCase();
		double fin = Double.valueOf(Importe);
		fin = fin * descuento;
		return fin;
	}

	/**
	 * Metodo que hace el descuento de productos que se encuentran en el almacen
	 */
	public void cerrarVentaProductos() {
		for (int i = 0; i < ventanaAgregarProductoVenta.productosau.size(); i++) {
			int cantidad = ventanaAgregarProductoVenta.cantidadProductos;
			controlAlmacen.modificarProductocantidad(ventanaAgregarProductoVenta.productosau.get(i), cantidad);

		}

	}
}
