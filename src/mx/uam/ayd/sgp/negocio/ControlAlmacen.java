package mx.uam.ayd.sgp.negocio;



import java.util.Calendar;

import javax.swing.JOptionPane;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.VentanaAñadirProducto;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaSeleccionAlmacen;

public class ControlAlmacen {
	
	private DAOProducto dao;
	private String tipoAlmacen;


	public ControlAlmacen() {
		dao= new DAOProducto();
	}
	
	public void iniciaSeleccionDeAlmacen() {
		VentanaSeleccionAlmacen GUI = new VentanaSeleccionAlmacen(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	
	public void DespliegaVCRUD(String tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
		VentanaCRUDAlmacen GUI =new VentanaCRUDAlmacen(this);
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
	}
	public void DespliegaVAñadirAlamcen() {
		VentanaAñadirProducto GUIAgregarP = new VentanaAñadirProducto(this);
		GUIAgregarP.setVisible(true);
		GUIAgregarP.setLocationRelativeTo(null);
		
	}
	public String getTipoAlmacen() {
		return tipoAlmacen;
	}
	public void agregarProducto(String nombre, String descripcion, double precio, double descuento,int cantidad,String tipoAlmacen,String fecha) {
		Producto P = new Producto(nombre,precio,descripcion,descuento);
		Almacen A = new Almacen(P,cantidad,fecha,tipoAlmacen);
		if(dao.agregarAlAlmacen(A)) {
			JOptionPane.showMessageDialog(null, "Producto agregado al almacen", "Producto agregado", 0);
		}
	}
	
}
