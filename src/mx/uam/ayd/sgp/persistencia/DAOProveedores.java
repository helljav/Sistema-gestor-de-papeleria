package mx.uam.ayd.sgp.persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Proveedor;
import mx.uam.ayd.sgp.modelo.Usuario;
public class DAOProveedores {
	
	/**
	 * AgregaProveedor Metodo que agrega un proveedor a la base de datos
	 * @param Prov
	 * @return true si es que se logro agregar el proveedor
	 * @return false Si no se logro agregar
	 */
	
	
	
	public boolean AgregaProveedor(Proveedor Prov) {
		try {
		Statement statement=ManejadorBD.dameConnection().createStatement();
		String Nombre_Empresa=Prov.getNombre();
		String Apellido ="Perez";
		String Correo_Electronico= Prov.getCorreo_Electronico();
		String Numero_Telefonico =Prov.getNumero_Telefonico();
		String Descripcion =Prov.getDescripcion();
		statement.execute("insert into proveedores values(DEFAULT,'"+Nombre_Empresa+"','"+Apellido+"','"+Numero_Telefonico+"','"+Correo_Electronico+"','"+Descripcion+"')",statement.RETURN_GENERATED_KEYS);
		return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * accede a la base de datos para eliminar un Proveedor
	 * 
	 * ***/
	public boolean EliminaUsuario(String nombre) {
		try {
			Statement statement = ManejadorBD.dameConnection().createStatement();
			String name;
			String lastname;
			String[] nombres=nombre.split(" ");
			name=nombres[0];
			lastname=nombres[1];
			
			statement.execute("DELETE FROM proveedores WHERE nombre='"+name+"'AND apellidos='"+lastname+"'");
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	

	
	/**
	 * ModificaProveedor metodo que sirve para modificar los datos de un proveedor ya existente en la BD
	 * 
	 * @param Prov Proveedor Provedor a modificar
	 * @param ProvAnterior Proveedor  a comparar
	 * @return true si es que se logro modificar el proveedor
	 *@false false si es que no logro modificar el proveedor 
	 */
	public boolean ModificaProveedor(Proveedor Prov, Proveedor ProvAnterior) {
		try {
			// Crea el statement para hacer la conexion a la base de datos
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement2.executeUpdate("UPDATE proveedores SET nombre ='" + Prov.getNombre() + "', apellidos = '"
					+ Prov.getApellido() + "', telefono = '" + Prov.getNumero_Telefonico() + "', email = '" + Prov.getCorreo_Electronico()
					+ "', descripcion ='" + Prov.getDescripcion() + "'WHERE nombre='" + ProvAnterior.getNombre()  + "'");
		
			return true;
		
		
	} 
		catch (SQLException e) {
		// Cacha excepcion
		e.printStackTrace();
		return false;
	}
	
	}
	
	public ArrayList<Proveedor> dameProveedor(String ProveedorABuscar) {
		System.out.println("Entrando al dao proveedor");
		
		try {
			ArrayList<Proveedor> ProveedorTemp = new ArrayList<Proveedor>();
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT *  FROM proveedores WHERE nombre LIKE '%" + ProveedorABuscar+"%'");
			System.out.println("i am here" + rs);
			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Proveedor prov = new Proveedor(rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("telefono"), rs.getString("email"), rs.getString("descripcion"));
				ProveedorTemp.add(prov);
			}
			
			return ProveedorTemp;
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	
}