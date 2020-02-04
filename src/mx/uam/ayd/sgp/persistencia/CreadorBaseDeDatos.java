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
			statement.execute("insert into Usuarios values('" + "admin" + "','" + "123"+ "','" + "ADMINISTRADOR" + "')");
			statement.execute("insert into Usuarios values('" + "empleado" + "','" + "321"+ "','" + "EMPLEADO" + "')");
			
			//////////////////////////////////////////////////////////////////////////////////////
			statement.execute("create table Productos(nombre varchar(40), precio double precision,descripcion varchar(50),cantidad int, descuento double precision, fecha varchar(12), tipoAlmacen varchar(40))");
			System.out.println("locura creada");
			statement.execute("insert into Productos values('" + "prit" + "'," + 23 + ",'" + "pega de locuraaaaaa" + "' ," + 20 + "," + 50 + "," +"'2018-12-07'" +",'" + "Almacen general" + "')");
			//////////////////////////////////////////////////////////////////////////////////////
			 /**
	         * CREA TABLA VENTAS
	         */
	        System.out.println("Creando tabla ventas");
	        statement.execute("CREATE TABLE Venta("+ 
	        "numFolio INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	        "fechaventa varchar(20),"+
	        "empleado varchar(40),"+
	        "importe FLOAT, "
	        );
	        ////////////////////////////////////////////////////////////////////////////////////////////
	        statement.execute("INSERT INTO Venta VALUES (DEFAULT,"+"2010/01/14"+","+"maribel Contreras"+")",Statement.RETURN_GENERATED_KEYS);
	       
			
			
			
			ManejadorBD.termina();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
