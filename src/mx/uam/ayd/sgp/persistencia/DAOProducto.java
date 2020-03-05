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
	public Almacen[] dameProductos(String productoABuscar, String tipoAlmacen) {

		ArrayList<Almacen> productosTemp = new ArrayList<Almacen>();
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Productos WHERE nombre LIKE '%" + productoABuscar
					+ "%' AND tipoAlmacen ='" + tipoAlmacen + "'");
			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Producto p = new Producto(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("descripcion"),
						rs.getDouble("descuento"));
				Almacen producto = new Almacen(p, rs.getInt("cantidad"), rs.getString("fecha"),
						rs.getString("tipoAlmacen"));
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
	////////////////////////////////////////////////////

	public Almacen[] dameProduc(String productoABuscar) {

		ArrayList<Almacen> productosTemp = new ArrayList<Almacen>();
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement
					.executeQuery("SELECT * FROM Productos WHERE nombre LIKE '%" + productoABuscar + "'");
			System.out.println("entre dame producto  dao");
			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Producto p = new Producto(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("descripcion"),
						rs.getDouble("descuento"));
				Almacen producto = new Almacen(p, rs.getInt("cantidad"), rs.getString("fecha"),
						rs.getString("tipoAlmacen"));
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

	///////////////////////////////////////////////////

	public boolean eliminarDeAlmacen(Almacen producto) {
		int resultado = 0;
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Productos WHERE nombre='" + producto.getNombreProducto()
					+ "' AND tipoAlmacen='" + producto.getTipoAlmacen() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (resultado == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean agregarAlAlmacen(Almacen A) {
		try {
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement2.execute("insert into Productos values('" + A.getNombreProducto() + "'," + A.getPrecioProducto()
					+ ",'" + A.getDescripcionProducto() + "'," + A.getCantidadProducto() + ","
					+ A.getDesceuntoProducto() + ",'" + A.getFechaIngreso() + "','" + A.getTipoAlmacen() + "')");
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	public boolean modificarProducto(Almacen A, Almacen ProductoAnteior) {
		System.out.println("Nuevo producto en dao \n\n" + A.toString() + "\n\n");
		System.out.println("viejo producto en dao \n\n" + ProductoAnteior.toString());
		try {
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement2.executeUpdate("UPDATE Productos SET nombre='" + A.getNombreProducto() + "', precio = "
					+ A.getPrecioProducto() + ", descripcion = '" + A.getDescripcionProducto() + "', cantidad = "
					+ A.getCantidadProducto() + ", descuento =" + A.getDesceuntoProducto() + ", fecha ='"
					+ A.getFechaIngreso() + "', tipoAlmacen ='" + A.getTipoAlmacen() + "'WHERE nombre='"
					+ ProductoAnteior.getNombreProducto() + "' AND  descripcion = '"
					+ ProductoAnteior.getDescripcionProducto() + "'");// "precio
																		// ="+ProductoAnteior.getPrecioProducto()+" AND
																		// "+"descripcion
																		// ='"+ProductoAnteior.getDescripcionProducto()+"'
																		// AND "+"cantidad=
																		// "+ProductoAnteior.getCantidadProducto()+" AND
																		// "+"descuento
																		// ="+ProductoAnteior.getDesceuntoProducto()+"
																		// AND "+"fecha
																		// ='"+ProductoAnteior.getFechaIngreso()+"' AND
																		// "+"tipoAlmacen =
																		// '"+ProductoAnteior.getTipoAlmacen()+"'");
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Metodo que modifica la cantidad de productos que hay en el almacen
	 * 
	 * @param producto
	 * @param cantidad
	 * @return verdadero o falso si se realizo la operacion
	 */
	public boolean modificarProductocantidad(Almacen producto, int cantidad) {
		try {

			int cantidadNueva = producto.getCantidadProducto() - cantidad;
			Statement statement = ManejadorBD.dameConnection().createStatement();
			statement.execute("UPDATE Productos SET cantidad =" + cantidadNueva + "WHERE nombre='"
					+ producto.getNombreProducto() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
