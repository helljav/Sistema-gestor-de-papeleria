package mx.uam.ayd.sgp.negocio;

import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Pedido;
import mx.uam.ayd.sgp.persistencia.DAOPedidos;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.VentanaAdminPedido;
import mx.uam.ayd.sgp.presentacion.VentanaAgregarProductoPedido;
import mx.uam.ayd.sgp.presentacion.VentanaAgregarProductoVenta;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaDetallesPedido;
import mx.uam.ayd.sgp.presentacion.VentanaModificarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaMuestraPedidos;
import mx.uam.ayd.sgp.presentacion.VentanaRealizaPedido;

public class ControlVentaPedido {
	private DAOPedidos dao;
	private VentanaRealizaPedido GUIRP;
	private ControlRealizaVenta crtlRV;
	private VentanaAdminPedido GUIVPedido;
	private VentanaAgregarProductoPedido GUIVAPP;
	private VentanaMuestraPedidos VentanaPedidos;
	private VentanaDetallesPedido VentanaDetalles;
	private Pedido ped;
	ControlAlmacen controlAlmacen;
	private String Nombre;
	
	public ControlVentaPedido() {
		dao = new DAOPedidos();
	}


	
	public void IniciaVentanaPedido() {
		GUIRP = new VentanaRealizaPedido(this);
		GUIRP.setVisible(true);
		GUIRP.setLocationRelativeTo(null);
	}
	
	public void DespliegaVCRUD() {
		GUIVPedido = new VentanaAdminPedido(this);
		GUIVPedido.setVisible(true);
		GUIVPedido.setLocationRelativeTo(null);		
		
	}
	
	public void iniciaVentanaAgregarProducto() {
//		crtlRV = new ControlRealizaVenta();
//		crtlRV.iniciaVAPV();
		controlAlmacen = new ControlAlmacen();
		GUIVAPP = new VentanaAgregarProductoPedido(controlAlmacen, this, GUIRP);
		GUIVAPP.setVisible(true);
		GUIVAPP.setLocationRelativeTo(null);
		
	}
	/**Metodo que despliega una ventana que muestra los detalles de un pedido
	 * @param IDpedido int el numero del pedido que se va a visualizar
	 * @author Hector hernan Dominguez Gonzalez
	 * **/
	public void MuestraVentanaDetallePedido(int IDpedido) {
		VentanaDetalles=new VentanaDetallesPedido(IDpedido,this);
		VentanaDetalles.setVisible(true);
	}
	/**
	 * Metodo que despliega la ventana con la lista de pedidos 
	 * @author Hector Hernan Dominguez Gonzalez
	 * **/
	public void MuestraVentanapedidos() {
		VentanaPedidos=new VentanaMuestraPedidos(this);
		VentanaPedidos.setVisible(true);
	}
	  public void empleadoaut(String Nombre){
		 this.Nombre=Nombre;
	 }
	  public String getempleadoaut(){
		  return Nombre;
		 }
	 
	
	public boolean realizaPedido(String fecha, String nombre, String apellido, double importeDejado, double importeTotal) {
		
		ped = new Pedido(fecha,nombre,apellido,importeTotal,importeDejado, Nombre);
		dao.almacenaPedido(ped);
		return true;
		
	}
	/**Metodo que trae la lista de pedidos a mostrar
	 * @return pedidos ArrayList<Pedido> Lista de pedidos
	 * @author Hector Hernan Dominguez Gonzalez
	 * **/
	public ArrayList<Pedido> traePedidos(){
		
		dao=new DAOPedidos();
		ArrayList<Pedido> pedidos;
		pedidos=dao.TraePedidos();
		return pedidos;
		
	}
	/***
	 * Metodo que trae un pedido que sera visualizado por el empleado
	 * @param ID int ID del pedido a consultar
	 * @return p Pedido Objeto pedido que se va a mostrar
	 * @author Hector Hernan Dominguez Gonzalez
	 * **/
	public Pedido traePedido(int ID) {
		Pedido p;
		dao=new DAOPedidos();
		p=dao.recuperaPedido(ID);
		return p;
	}

}
