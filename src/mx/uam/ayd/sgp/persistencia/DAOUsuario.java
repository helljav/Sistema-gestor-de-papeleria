package mx.uam.ayd.sgp.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.modelo.Usuario;

public class DAOUsuario {

	/**
	 * Accede a la base de datos para identificar al usuario y la contraseña
	 * 
	 * @param usuario
	 * @param contraseña
	 * @return
	 */

	public Usuario Autentifica(String usuario, String contraseña) {
		System.out.println("holi");

		Usuario user = null;
		try {

			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM Usuarios WHERE usuario='" + usuario + "'	AND contraseña='" + contraseña + "'");
			if (rs.next()) {

				// Crea una nueva instancia del objeto
				user = new Usuario(rs.getString("usuario"), rs.getString("contraseña"), rs.getString("tipoCuenta"),
						rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"),
						rs.getInt("idempleado"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Regresa los productos del almacen como un arreglo de almacen
	 * 
	 * @return el arreglo de almacen
	 */
	public Usuario[] dameUsuarios(String usuariosABuscar) {

		ArrayList<Usuario> UsuariosTemp = new ArrayList<Usuario>();
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Usuarios WHERE usuario LIKE  '%" + usuariosABuscar
					+ "%' OR idempleado = '" + usuariosABuscar + "'");
			System.out.println("i am here" + rs);
			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Usuario user = new Usuario(rs.getString("usuario"), rs.getString("contraseña"),
						rs.getString("tipoCuenta"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("telefono"), rs.getInt("idempleado"));
				UsuariosTemp.add(user);
			}
			Usuario UsuariosTempArreglo[] = new Usuario[UsuariosTemp.size()];
			UsuariosTemp.toArray(UsuariosTempArreglo);
			return UsuariosTempArreglo;
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param U
	 *            Objeto tipo usuario el cual cobtiene los datos nuevos
	 * @param usuarioAnterior
	 *            Objeto tipo usuario el cual tiene los datos que seran remplazado
	 * @return: devuelve un true si se pudo modificar los datos en la tabla o false
	 *          si no se pudo hacer la modificacion de usuarios
	 */

	public boolean modificarUsuario(Usuario U, Usuario usuarioAnterior) {
		System.out.println("Nuevo producto en dao \n\n" + U.toString() + "\n\n");
		System.out.println("viejo producto en dao \n\n" + usuarioAnterior.toString());
		try {
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement2.executeUpdate("UPDATE Usuarios SET idempleado ='" + U.getIdEmpleado() + "', usuario = '"
					+ U.getUsuario() + "', contraseña = '" + U.getContraseña() + "', tipoCuenta = '" + U.getTipoCuenta()
					+ "', nombre ='" + U.getNombre() + "', apellidos ='" + U.getApellidos() + "', telefono ='"
					+ U.getTelefono() + "'WHERE idempleado='" + usuarioAnterior.getIdEmpleado() + "' AND  usuario = '"
					+ usuarioAnterior.getUsuario() + "'");// "precio ="+usuarioAnterior.getPrecioProducto()+" AND
															// "+"descripcion
															// ='"+ProductoAnteior.getDescripcionProducto()+"' AND
															// "+"cantidad= "+ProductoAnteior.getCantidadProducto()+"
															// AND "+"descuento
															// ="+ProductoAnteior.getDesceuntoProducto()+" AND "+"fecha
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
	 * 
	 * @param user
	 * @return
	 */
	public boolean EliminarUsuario(Usuario user) {
		int Usuario = 0;
		try {
			Statement statement = ManejadorBD.dameConnection().createStatement();

			/* Checar esta Query */
			System.out.println(user.getIdEmpleado());
			Usuario = statement.executeUpdate("DELETE FROM Usuarios WHERE usuario = '" + user.getUsuario()
					+ "' AND idempleado= '" + user.getIdEmpleado() + "'");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println(Usuario);
		if (Usuario == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean agregaUsuario(Usuario user) {
		try {
			Statement statement = ManejadorBD.dameConnection().createStatement();

			String idempleado = user.getIdEmpleado();
			String usuario = user.getUsuario();
			String pass = user.getContraseña();
			String cargo = user.getTipoCuenta();
			String nombre = user.getNombre();
			String apellidos = user.getApellidos();
			String telefono = user.getTelefono();

			statement.execute("insert into Usuarios values('" + idempleado + "','" + usuario + "','" + pass + "','"
					+ cargo + "','" + nombre + "','" + apellidos + "','" + telefono + "')");
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
