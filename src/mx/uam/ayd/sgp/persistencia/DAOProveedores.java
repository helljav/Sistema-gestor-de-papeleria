package mx.uam.ayd.sgp.persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.sgp.modelo.Proveedor;
public class DAOProveedores {
	public boolean AgregaProveedor(Proveedor Prov) {
		try {
		Statement statement=ManejadorBD.dameConnection().createStatement();
		String Nombre_Empresa=Prov.getNombre_Empresa();
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
	public boolean EliminaUsuario(int id) {
		try {
			Statement statement = ManejadorBD.dameConnection().createStatement();
			statement.execute("DELETE FROM proveedores WHERE idproveedor="+id);
			return true;

		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static ArrayList<Proveedor> traeProveedores(){
		try {
			ArrayList<Proveedor> lista=new ArrayList();
			Statement statement=ManejadorBD.dameConnection().createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM proveedores");
			while(rs.next()) {
				int id=rs.getInt("idproveedor");
				String name1=rs.getString("nombre");
				String lastname1=rs.getString("apellidos");
				String telefono=rs.getString("telefono"); 
				String email=rs.getString("email");
				String desc=rs.getString("descripcion");
				
				lista.add(new Proveedor(id,name1+" "+lastname1,email,telefono,desc));	
			}
			return lista;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}