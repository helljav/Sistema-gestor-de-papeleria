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

	


	public ControlRealizaVenta(){
	daoV = new DAOVenta();
	}
	public void iniciaVAPV() {
	controlAlmacen =new ControlAlmacen();
	ventanaAgregarProductoVenta=new VentanaAgregarProductoVenta(controlAlmacen,this,ventanarealizarventa);
	ventanaAgregarProductoVenta.setVisible(true);
	ventanaAgregarProductoVenta.setLocationRelativeTo(null);
	
}
	//se inicializa la ventana
	public void iniciarealizarventa() {
//		definir el constructor
		ventanarealizarventa= new VentanaRealizaVenta(this);
		ventanarealizarventa.setVisible(true);
		ventanarealizarventa.setLocationRelativeTo(null);
	}
	public void agregarProductoVenta(String fechaVenta, String empleado, double importe ) {
		try {
			System.out.println("ENTRE A CONTROL");
			Venta V = new Venta(fechaVenta, empleado, importe);
			System.out.println("ENTRE A CONTROL");
			daoV.agregarAVenta(V);
			System.out.println("ENTRE A CONTROL");
			ventanarealizarventa.alertaMensaje("Producto agregado al almacen", "Producto agregado", 1);
			ventanarealizarventa.setVisible(false);
		} catch (Exception e) {
			ventanarealizarventa.alertaMensaje("El producto no se pudo agregar al almacen", "Fatal error", 0);
		}
	}
	public void agregarProductoAviso(Almacen producto) {
		try {
			System.out.println(producto.getNombreProducto()+" "+producto.getFechaIngreso());
			ventanaAgregarProductoVenta.alertaMensaje("Producto agregado a la venta", "Producto agregado", 1);
			ventanaAgregarProductoVenta.setVisible(false);
		} catch (Exception e) {
			ventanaAgregarProductoVenta.alertaMensaje("El producto no se pudo agregar a la venta", "Fatal error", 0);
		}

	}
	
	
	
	
}
