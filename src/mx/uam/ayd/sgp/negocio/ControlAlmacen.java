package mx.uam.ayd.sgp.negocio;



import java.util.Calendar;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaSeleccionAlmacen;

public class ControlAlmacen {
	
	DAOProducto dao;


	public ControlAlmacen() {
		dao= new DAOProducto();
	}
	
	public void iniciaSeleccionDeAlmacen() {
		VentanaSeleccionAlmacen GUI = new VentanaSeleccionAlmacen(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	public void DespliegaVCRUD() {
		VentanaCRUDAlmacen GUI =new VentanaCRUDAlmacen(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	public void agregarProducto(String nombre, String descripcion, double precio, double descuento,int cantidad,String tipoAlmacen,Calendar fecha) {
		Producto P = new Producto(nombre,precio,descripcion,descuento);
		Almacen A = new Almacen(P,cantidad,fecha,tipoAlmacen);
		dao.agregarAlAlmacen(A);
	}
	
}
