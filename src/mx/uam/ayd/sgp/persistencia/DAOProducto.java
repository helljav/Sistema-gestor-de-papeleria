package mx.uam.ayd.sgp.persistencia;

import java.sql.SQLException;
import java.sql.Statement;


import mx.uam.ayd.sgp.modelo.Almacen;

public class DAOProducto {
	
	public DAOProducto() {
		
	}
	
	public boolean agregarAlAlmacen(Almacen A) {
		try {
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement2.execute("insert into Productos values('" + A.getNombreProducto() + "'," + A.getPrecioProducto() + ",'" + A.getDescripcionProducto() + "'," + A.getCantidad()+",'" +A.getDesceuntoProducto()+ ","  +A.getFechaIngreso()+"','"+ A.getTipoAlmacen() +"')");
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
		
		
	}

}
