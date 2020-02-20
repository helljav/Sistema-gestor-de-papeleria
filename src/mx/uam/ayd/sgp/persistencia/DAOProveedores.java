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
}