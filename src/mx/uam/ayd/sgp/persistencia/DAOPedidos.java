package mx.uam.ayd.sgp.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Pedido;
import mx.uam.ayd.sgp.modelo.Usuario;

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
			System.out.println(P.toString());
			statement2.execute("insert into Pedido values(DEFAULT ,'" + P.getFechaPedido() + "','" + P.getNombreCliente()
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
	////////////////////////////////////////////////////
	public Pedido[] damePedido(String nombreCliente) {
		
		ArrayList<Pedido> PedidoTemp = new ArrayList<Pedido>();
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Pedido WHERE nombreCliente LIKE  '%" + nombreCliente + "%'");
			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Pedido pedido = new Pedido(rs.getInt("numPedido"), rs.getString("fechaPedido"), rs.getString("nombreCliente"), rs.getString("apellidoCliente"),
						rs.getDouble("importeTotal"), rs.getDouble("importeDejado"));
				PedidoTemp.add(pedido);
			}
			Pedido PedidoTempArreglo[] = new Pedido[PedidoTemp.size()];
			PedidoTemp.toArray(PedidoTempArreglo);
			return PedidoTempArreglo;
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	///////////////////////////////////////////////////////
	public boolean cancelaPedido(Pedido P) {
		
		int pedido = 0;
		try {
			Statement statement = ManejadorBD.dameConnection().createStatement();

			/* Checar esta Query */
			System.out.println(P.getNombreCliente());
			
			//pedido = statement.executeUpdate("DELETE FROM Pedido WHERE nombreCliente = '" + P.getNombreCliente()
			//		+ "' AND apellidoCliente= '" + P.getApellidoCliente() + "'");
			
			pedido = statement.executeUpdate("DELETE FROM Pedido WHERE numPedido = " + P.getNumPedido() );

		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println(pedido);
		if (pedido == 0) {
			return false;
		} else {
			return true;
		}
		
	}

	
}
