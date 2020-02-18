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
			/**
			 * CREA TABLA USUARIOS
			 */
			Statement statement = connection.createStatement();
			statement.execute("create table Usuarios(idempleado varchar(20) PRIMARY KEY,usuario varchar(40), contraseña varchar(40),tipoCuenta varchar(20),nombre varchar(40),apellidos varchar(100),telefono varchar(40))");// , CONSTRAINT primary_key PRIMARY KEY (autorId)
			System.out.println("Tabla de Usuarios creada exitosamente");
			statement.execute("insert into Usuarios values('" +"1245"+"','"+ "admin" + "','" + "123"+ "','" + "ADMINISTRADOR" +"','"+"Hernan"+"','"+"Dominguez"+"','"+"5959571482"+ "')");
			statement.execute("insert into Usuarios values('"+"1996"+"','" + "empleado" + "','" + "321"+ "','" + "EMPLEADO" +"','"+"eduardo"+"','"+"oseguera"+"','"+"5568971845"+ "')");
			/**
			 * TABLA CREA PRODUCTOS		
			 */
			//////////////////////////////////////////////////////////////////////////////////////
			statement.execute("create table Productos(nombre varchar(40), precio double precision,descripcion varchar(50),cantidad int, descuento double precision, fecha varchar(12), tipoAlmacen varchar(40))");
			statement.execute("insert into Productos values('" + "Prit 11g" + "'," + 15 + ",'" + "pega de locuraaaaaa" + "' ," + 20 + "," + 0 + "," +"'2018-12-07'" +",'" + "Almacen general" + "')");
			statement.execute("insert into Productos values('" + "Resistol 850 110g" + "'," + 25 + ",'" + "Pegamento blanco escolar" + "' ," + 20 + "," + 0 + "," +"'2018-12-07'" +",'" + "Almacen general" + "')");
			statement.execute("insert into Productos values('" + "Hojas Blancas Scribe" + "'," + 80 + ",'" + "Hojas blancas de 500 hojas" + "' ," + 20 + "," + 0 + "," +"'2018-12-07'" +",'" + "Almacen general" + "')");
			statement.execute("insert into Productos values('" + "Carpeta panoramica OFFIS" + "'," + 40 + ",'" + " Carpeta de 2.5 cm capacidad aprox 200 hojas" + "' ," + 20 + "," + 5 + "," +"'2018-12-07'" +",'" + "Almacen general" + "')");
			statement.execute("insert into Productos values('" + "Colores Norma 24 pzs" + "'," + 150 + ",'" + "Lapices de colores punta gruesa" + "' ," + 5 + "," + 0 + "," +"'2018-12-07'" +",'" + "Almacen general" + "')");
					
			//////////////////////////////////////////////////////////////////////////////////////
			 /**
	         * CREA TABLA VENTAS
	         */
	        System.out.println("Creando tabla ventas");
	        statement.execute("CREATE TABLE Venta("+ 
	        "numFolio INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	        "fechaventa varchar(20),"+
	        "empleado varchar(40),"+
	        "importe double )");
	        
	        
	        statement.execute("CREATE TABLE Pedido("+
	        "numPedido INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	        //"nombreProducto varchar(40),"+
	        "fechaPedido varchar(20),"+
	        "nombreCliente varchar(20),"+
	        "apellidoCliente varchar(40),"+
	        "importe double )");
	        
	        
	        // statement.execute("INSERT INTO Venta VALUES (DEFAULT,"+"2010/01/14"+","+"maribel Contreras"+"+)",Statement.RETURN_GENERATED_KEYS);
	        statement.execute("INSERT INTO Venta VALUES (DEFAULT,'"+"15/02/2020"+"','"+"Empleado"+"',"+150.5+")",Statement.RETURN_GENERATED_KEYS);
	        statement.execute("INSERT INTO Venta VALUES (DEFAULT,'"+"15/02/2020"+"','"+"Empleado"+"',"+266.89+")",Statement.RETURN_GENERATED_KEYS);
	        ////////////////////////////////////////////////////////////////////////////////////////////
	
			
			
			ManejadorBD.termina();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
