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
			
			
			statement.execute("create table Productos(nombre varchar(40), precio double precision,descripcion varchar(50),cantidad int, fecha date, tipoAlmacen varchar(20))");
			System.out.println("locura creada");
			statement.execute("insert into Productos values('" + "prit" + "'," + 23 + ",'" + "pega de locuraaaaaa" + "' ," + 20 + "," + "'2018-12-07'" +",'" + "Almacen general" + "')");
			
			ManejadorBD.termina();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
