package mx.uam.ayd.sgp.persistencia;


import java.sql.Connection;
import java.sql.Statement;

public class CreadorBaseDeDatos {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		try
		{
			Connection connection = ManejadorBD.dameConnection();

			Statement statement = connection.createStatement();
			statement.execute("create table Usuarios(usuario varchar(40), contraseña varchar(40),tipoCuenta varchar(20))"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			System.out.println("Tabla de Usuarios creada exitosamente");
			statement.execute("insert into Usuarios values('" + "carlos" + "','" + "123"+ "','" + "ADMINISTRADOR" + "')");
			statement.execute("insert into Usuarios values('" + "solrac" + "','" + "321"+ "','" + "EMPLEADO" + "')");
			
			ManejadorBD.termina();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
