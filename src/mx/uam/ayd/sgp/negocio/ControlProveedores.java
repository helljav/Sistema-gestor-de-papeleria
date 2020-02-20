package mx.uam.ayd.sgp.negocio;
import mx.uam.ayd.sgp.modelo.Proveedor;
import mx.uam.ayd.sgp.persistencia.DAOProveedores;

import mx.uam.ayd.sgp.presentacion.VentanaAñadirProveedor;
import mx.uam.ayd.sgp.presentacion.VentanaEliminarProveedor;

public class ControlProveedores {
	private DAOProveedores dao;
	private static VentanaEliminarProveedor deleteP;
	private VentanaEliminarProveedor GUIEliProv;
	private VentanaAñadirProveedor GUIAddProv;
	
	
	public ControlProveedores() {}
	
	public ControlProveedores(DAOProveedores dao){
		dao = new DAOProveedores();
		
	}
	public void VentanaAñadirProveedor() {
		GUIAddProv = new VentanaAñadirProveedor(this);
		GUIAddProv.setUndecorated(true);
		GUIAddProv.setVisible(true);
		GUIAddProv.setLocationRelativeTo(null);
		
	}
	
	/**
	 * Crea la ventana que se encarga de realizar la operacion de eliminar proveedor
	 * ***/
	public void eliminaProveedor(){
		deleteP= new VentanaEliminarProveedor(this);
		deleteP.setUndecorated(false);
		deleteP.setVisible(true);
		deleteP.setLocationRelativeTo(null);
	}
	/**
	 * Metodo que se conecta al DAOProveedores para eliminar un proveedor
	 * @param String nombre nombre del proveedor a eliminar
	 * @return true si elimina el usuario exitosamente
	 * @return false si no se pudo eliminar
	 * ***/
	public boolean deleteProvider(String nombre){
		dao=new DAOProveedores();
		if(dao.EliminaUsuario(nombre)){
			return true;
		}
		return false;
	}
	
	public boolean addProv(String Nombre_Empresa,String CorreoElectronico,String NumeroTelefonico, String Descirpcion) {
		dao=new DAOProveedores();
		Proveedor Provadd=new Proveedor(Nombre_Empresa,CorreoElectronico,NumeroTelefonico,Descirpcion);
		if(dao.AgregaProveedor(Provadd)==true) {
			return true;
		}
		return false;
	}
}
