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
	/**
	 * Metodo que me regresa el id del pedido y el nombre y apellidos del cliente
	 * @return listapedidos ArrayList<Pedido>
	 * @author Hector Hernan Dominguez Gonzalez
	 * ***/
	public ArrayList<Pedido> TraePedidos(){ 
		try {
			ArrayList<Pedido> listapedidos=new ArrayList<Pedido>();
			//conectamos a la base de datos
			Statement statement=ManejadorBD.dameConnection().createStatement();
			///obtenemos los pedidos pidiendo el numpedido,nombreCliente,apellidoCliente
			ResultSet rs=statement.executeQuery("SELECT * FROM Pedido");
			///leemos todos los registros devueltos y llenamos la lista de pedidos que vamos a regresar
			while(rs.next()){
				//para cada registro obtenido del query se crea una instancia de Pedido
				int IDpedido= rs.getInt("numPedido");
				String nombre=rs.getString("nombreCliente");
				String apellido= rs.getString("apellidoCliente");
				Pedido p=new Pedido(IDpedido,"","",nombre,apellido,0.0,0.0);
				listapedidos.add(p);
			}
			return listapedidos;
		}catch(SQLException ex) {
			ex.printStackTrace();
	////////////////////////////////////////////////////
	/**
	 * Este metodo obtiene todos los pedidos relacionados  con el nombre de un cliente 
	 * @param nombreCliente
	 * @return PedidoTempArreglo devuelve un arreglo con los pedidos relacionados
	 */
	public Pedido[] damePedido(String nombreCliente) {
		
		ArrayList<Pedido> PedidoTemp = new ArrayList<Pedido>();
		try {
			// Crea el statement para hacer la conexion a la base de datos
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
	/**
	 * Metodo que regresar un pedido en especifico
	 * @param ID int id del pedido a recuperar
	 * @return p Pedido Objeto con los valores del pedido solicitado
	 * @return null valor devuelto por default
	 * @author Hector Hernan Dominguez gonzalez 
	 * **/
	public Pedido recuperaPedido(int ID) {
		try {
			///conectamos a la base de datos
			Statement statement=ManejadorBD.dameConnection().createStatement();
			///se ejecuta la consulta
			ResultSet rs=statement.executeQuery("SELECT * FROM Pedido WHERE numPedido="+ID);
			///se leen los valores obtenidos de la consulta y se crea el objeto pedido a regresar
			if(rs.next()) {
				int IDpedido= (int) rs.getInt("numPedido");
				String nombre=rs.getString("nombreCliente");
				String apellido= rs.getString("apellidoCliente");
				String fecha=rs.getString("fechaPedido");
				double importD=rs.getDouble("importeDejado");
				double importT=rs.getDouble("importeTotal");
					
				Pedido p=new Pedido(IDpedido,fecha,"",nombre,apellido,importT,importD);
				return p;
				
			}
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	///////////////////////////////////////////////////////
	/**
	 * Este metodobusca pedidos con el nombre de un cliente 
	 * @param Pedido P
	 * @return verdadero en caso de haberlo removido y falso en caso contrario
	 */
	public boolean cancelaPedido(Pedido P) {
		
		int pedido = 0;
		try {
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement = ManejadorBD.dameConnection().createStatement();

			
			System.out.println(P.getNombreCliente());
			/* Realiza Query */
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
