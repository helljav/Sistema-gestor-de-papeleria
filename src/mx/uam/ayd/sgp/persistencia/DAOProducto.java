package mx.uam.ayd.sgp.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.uam.ayd.sgp.persistencia.ManejadorBD;
import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;

public class DAOProducto {
	
	public DAOProducto() {
		
	}
	
	/**
	 * Regresa los productos del almacen como un arreglo de almacen
	 * 
	 * @return el arreglo de almacen
	 */
	public Almacen [] dameProductos(String productoABuscar, String tipoAlmacen ) {
		
		ArrayList<Almacen> productosTemp = new ArrayList<Almacen>();
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Productos WHERE nombre = '"+productoABuscar+"' AND tipoAlmacen ='"+ tipoAlmacen+"'");
			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Producto p = new Producto(rs.getString("nombre"),rs.getDouble("precio"),rs.getString("descripcion"),rs.getDouble("descuento"));
				Almacen producto = new Almacen(p, rs.getInt("cantidad"), rs.getString("fecha"),rs.getString("tipoAlmacen"));
				productosTemp.add(producto);
			}
			Almacen productosTempArreglo[] = new Almacen[productosTemp.size()];
			productosTemp.toArray(productosTempArreglo);
			return productosTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean agregarAlAlmacen(Almacen A) {
		try {
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement2.execute("insert into Productos values('" + A.getNombreProducto() + "'," + A.getPrecioProducto() + ",'" + A.getDescripcionProducto() + "'," + A.getCantidad()+"," +A.getDesceuntoProducto()+ ",'"  +A.getFechaIngreso()+"','"+ A.getTipoAlmacen() +"')");
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

}
