package mx.uam.ayd.sgp.negocio;

import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Venta;
import mx.uam.ayd.sgp.persistencia.DAOVenta;
import mx.uam.ayd.sgp.presentacion.VentanaConsultaVentas;

public class ControlConsultaVentas {
	private VentanaConsultaVentas ventanaconsultarventas=new VentanaConsultaVentas(this);
	private DAOVenta daoV;

	public ControlConsultaVentas() {
		
		daoV = new DAOVenta();
		ventanaconsultarventas = new VentanaConsultaVentas(this);
	}

	public void iniciaConsultarVentas() {
		ventanaconsultarventas = new VentanaConsultaVentas(this);
		ventanaconsultarventas.setVisible(true);

	}

	public ArrayList<Venta> recuperaVentas() {
		try {
			ArrayList<Venta> lista = new ArrayList();
			lista = (ArrayList<Venta>) daoV.recuperaTodos();
			ventanaconsultarventas.llenarT(lista);
//			for (int i = 0; i < lista.size(); i++) {
				//System.out.println(lista.get(i));
			//ventanaconsultarventas.tabl
					
//					vRv.tablaVenta.setValueAt(producto.getNombreProducto(),vRv.contador , 0);
//					vRv.tablaVenta.setValueAt(producto.getPrecioProducto(), vRv.contador, 1);
//					vRv.tablaVenta.setValueAt(producto.getCantidadProducto(),vRv.contador, 2);
//					vRv.tablaVenta.setValueAt(producto.getCantidadProducto()*producto.getPrecioProducto(),vRv.contador, 3);	
//					vRv.contador++;
				
			
			//}
			

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
