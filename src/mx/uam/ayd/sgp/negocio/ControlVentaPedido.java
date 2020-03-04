package mx.uam.ayd.sgp.negocio;

import javax.swing.JFrame;

import mx.uam.ayd.sgp.modelo.Pedido;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.persistencia.DAOPedidos;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarPedido;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarUsuarios;
import mx.uam.ayd.sgp.presentacion.VentanaAdminPedido;
import mx.uam.ayd.sgp.presentacion.VentanaAgregarProductoPedido;
import mx.uam.ayd.sgp.presentacion.VentanaAgregarProductoVenta;
import mx.uam.ayd.sgp.presentacion.VentanaCRUDAlmacen;
import mx.uam.ayd.sgp.presentacion.VentanaCancelarPedido;
import mx.uam.ayd.sgp.presentacion.VentanaModificarProducto;
import mx.uam.ayd.sgp.presentacion.VentanaRealizaPedido;

public class ControlVentaPedido {
	private DAOPedidos dao;
	private VentanaRealizaPedido GUIRP;
	private ControlRealizaVenta crtlRV;
	private VentanaAdminPedido GUIVPedido;
	private VentanaAgregarProductoPedido GUIVAPP;
	private Pedido ped;
	ControlAlmacen controlAlmacen;
	private String Nombre;
	private VentanaCancelarPedido guiCancelarPedido;
	
	public ControlVentaPedido() {
		dao = new DAOPedidos();
	}


	
	public void IniciaVentanaPedido() {
		GUIRP = new VentanaRealizaPedido(this);
		GUIRP.setVisible(true);
		GUIRP.setLocationRelativeTo(null);
	}


	public void IniciaVentanaCancelarPedido() {
		
		guiCancelarPedido = new VentanaCancelarPedido(this);
		guiCancelarPedido.setVisible(true);
		guiCancelarPedido.setLocationRelativeTo(null);
		
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
	
	/**
	 * Este metodobusca pedidos con el nombre de un cliente 
	 * @param nombreCliente
	 * @return pedido en relacion al cliente buscado
	 */
	public Pedido buscarPedido(String nombreCliente) {
		// Se crea la lista de autores para poder mostrarle al usuario
		Pedido arregloPedidos[] = dao.damePedido(nombreCliente); // Obtiene lista de pedidos
		DialogoMostrarPedido dialogo = new DialogoMostrarPedido(new JFrame(), arregloPedidos); // Crea el dialogo
																											// con la lista 																								// productos
		if (arregloPedidos.length == 0) {
			guiCancelarPedido.alertaMensaje("No se encontro ningun pedido con ese nombre de cliente", "Error", 0);
		} else {
			dialogo.setVisible(true); // Muestra el dialogo
		}
		return dialogo.getClienteSeleccionado(); // Regresa el pedido del cliente seleccionado en el dialogo
	}
	
	/**
	 * Este metodo manda a llamar al DAO de pedido para que se encargue de cancelar el pedido
	 * @param pedido
	 */
	public void cancelaPedido(Pedido pedido) {
		try {
			if (dao.cancelaPedido(pedido)) {
				guiCancelarPedido.alertaMensaje("El pedido fue eliminado ", "Success exito", 1);
				guiCancelarPedido.setVisible(false);

			} else {
				guiCancelarPedido.alertaMensaje("El pedido no se pudo eliminar", "Error :(", 0);

			}

		} catch (Exception e) {
			guiCancelarPedido.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);
		}
	}

}
