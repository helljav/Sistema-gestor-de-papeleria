package mx.uam.ayd.sgp.negocio;
import java.util.ArrayList;

import javax.swing.JFrame;

import mx.uam.ayd.sgp.modelo.Proveedor;
import mx.uam.ayd.sgp.persistencia.DAOProveedores;
import mx.uam.ayd.sgp.presentacion.DialogoMostrarProveedor;
import mx.uam.ayd.sgp.presentacion.VentanaAñadirProveedor;
import mx.uam.ayd.sgp.presentacion.VentanaEliminarProveedor;
import mx.uam.ayd.sgp.presentacion.VentanaModificarProveedor;

public class ControlProveedores {
	private static DAOProveedores dao;
	private static VentanaEliminarProveedor deleteP;
	private VentanaEliminarProveedor GUIEliProv;
	private VentanaAñadirProveedor GUIAddProv;
	private static VentanaModificarProveedor ModifProv;

	
	public ControlProveedores() {}
	
	public ControlProveedores(DAOProveedores dao){
		dao = new DAOProveedores();
		
	}
	public static Proveedor BuscaProveedor(String proveedor) {/*MODIFICAR*/
		System.out.println(proveedor);
		dao=new DAOProveedores();
		ArrayList<Proveedor> arregloProveedor =new ArrayList<Proveedor>();
		arregloProveedor=dao.dameProveedor(proveedor);
		DialogoMostrarProveedor dialogo = new DialogoMostrarProveedor(new JFrame(),arregloProveedor);
		if(arregloProveedor.size()==0) {
			
			ModifProv.alertaMensaje("No se encontro el Proveedor", "Error", 0);
		} else {
			dialogo.setVisible(true);
			
		}
	return dialogo.getProveedorSeleccionado();
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
		deleteP.setUndecorated(true);
		deleteP.setVisible(true);
		deleteP.setLocationRelativeTo(null);
	}
	
	public  void MuestraModificaProveedor() {
		ModifProv= new VentanaModificarProveedor(this);
		ModifProv.setUndecorated(false);
		ModifProv.setVisible(true);
		ModifProv.setLocationRelativeTo(null);
	}
	
	/**
	 * Metodo que se conecta al DAOProveedores para eliminar un proveedor
	 * @param String nombre nombre del proveedor a eliminar
	 * @return true si elimina el usuario exitosamente
	 * @return false si no se pudo eliminar
	 * ***/
	public boolean deleteProvider(int id){
		dao=new DAOProveedores();
		if(dao.EliminaUsuario(id)){
			return true;
		}
		return false;
	}
	
	/**
	 * addProv Metodo que sirve para agregar un proveedor al sistema
	 * @param Nombre_Empresa String nombre del proveedor
	 * @param Apellido String Apellido del proveedor
	 * @param CorreoElectronico String CorreoElectronico del proveedor
	 * @param NumeroTelefonico String NumeroTelefonico del proveedor
	 * @param Descirpcion String Descripcion del proveedor
	 * @return
	 */
	
	
	public boolean addProv(String Nombre_Empresa,String Apellido,String CorreoElectronico,String NumeroTelefonico, String Descirpcion) {
		dao=new DAOProveedores();
		Proveedor Provadd=new Proveedor(Nombre_Empresa,Apellido,CorreoElectronico,NumeroTelefonico,Descirpcion);
		if(dao.AgregaProveedor(Provadd)==true) {
			return true;
		}
		return false;
	}
	public ArrayList<Proveedor> traeproveedor() {
		ArrayList proveedoresL=new ArrayList();
		dao=new DAOProveedores();
		proveedoresL=DAOProveedores.traeProveedores();
		return proveedoresL;
	}

	/**Metodo que nos regresa el estado del proveedor Modificado
	 *  
	 * @param Prov-  Proveedor Proveedor a modificar 
	 * @param ProvAnt Proveedor proveedor a comparar
	 * @return true si es que se logro modificar el proveedor
	 * @return false si no se pudo modificar
	 */
	
	
	public static void ModificaProv(Proveedor Prov, Proveedor ProvAnt) {
		
		boolean bandera=true;
		try {
			bandera = dao.ModificaProveedor(Prov, ProvAnt);
			if (bandera) {
				ModifProv.alertaMensaje("El proveedor fue modificado ", "Success exito", 1);
				ModifProv.setVisible(false);

			} else {
				ModifProv.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);
			}
		} catch (Exception e) {
			ModifProv.alertaMensaje("Ocurrio un error, llame al administrador ", "Error", 0);
		}


		
	}
}
