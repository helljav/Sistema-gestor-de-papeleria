package mx.uam.ayd.sgp.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mx.uam.ayd.sgp.modelo.Pedido;

public class DAOPedidos {

	public DAOPedidos() {
		
	}
	
	/**
	 * Agrega un productos a la venta
	 * 
	 * @param P
	 *            implementado para el llamado a metodos de la clase pedido
	 * @return verdadero en caso que se agregue automaticamente
	 */
	public boolean almacenaPedido(Pedido P) {
		try {
			System.out.println("ACCEDI AL DAO");
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			
			statement2.execute("insert into Venta values(DEFAULT ,'" + P.getFechaPedido() + "','" + P.getNombreCliente()
					+ "','" + P.getApellidoCliente() + "'," + P.getImporteDejado() + ","+P.getImporteTotal()+")", Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = statement2.getGeneratedKeys();
			if (rs != null && rs.next()) {
				int llave = rs.getInt(1);
				P.setNumPedido(llave);// asigna llave al gasto
			}
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	
}
