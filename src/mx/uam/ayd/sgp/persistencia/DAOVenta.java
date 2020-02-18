package mx.uam.ayd.sgp.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Venta;

public class DAOVenta {

	public DAOVenta() {

	}

	/**
	 * Agrega un productos a la venta
	 * 
	 * @param V
	 *            implementado para el llamado a metodos de la clase venta
	 * @return verdadero en caso que se agregue automaticamente
	 */
	public boolean agregarAVenta(Venta V) {
		try {
			System.out.println("ACCEDI AL DAO");
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement2.execute("insert into Venta values(DEFAULT ,'" + V.getFechaVenta() + "','" + V.getEmpleado()
					+ "'," + V.getImporte() + ")", Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement2.getGeneratedKeys();
			if (rs != null && rs.next()) {
				int llave = rs.getInt(1);
				V.setNumFolio(llave);// asigna llave al gasto
			}
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Recupera todas las ventas
	 * 
	 * @return regresa en una lista las ventas totales
	 */
	public ArrayList<Venta> recuperaTodos(String fecha) {
		ArrayList<Venta> ventas = new ArrayList<Venta>();

		try {
			System.out.println(fecha);
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement2.executeQuery("SELECT * FROM Venta WHERE fechaventa LIKE'" + fecha + "'");

			while (rs.next()) {
				Venta venta = new Venta();
				venta.setNumFolio(rs.getInt("numFolio"));
				venta.setFechaVenta(rs.getString("fechaVenta"));
				venta.setEmpleado(rs.getString("empleado"));
				venta.setImporte(rs.getDouble("importe"));
				ventas.add(venta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ventas;
	}

}