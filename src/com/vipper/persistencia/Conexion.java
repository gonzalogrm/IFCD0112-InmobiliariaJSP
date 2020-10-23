package com.vipper.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	 protected Connection miConexion;
	    
	    public void abrirConexion() throws ClassNotFoundException, SQLException{
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        miConexion = DriverManager.getConnection
	        ("jdbc:mysql://localhost:3306/"
	                + "inmuebles" //Nombre BBDD
	                + "?useUnicode=true"
	                + "&useJDBCCompliantTimezoneShift=true"
	                + "&useLegacyDatetimeCode=false"
	                + "&serverTimezone=UTC"
	                + "&autoReconnect=true"
	                + "&useSSL=false",
	                "USER", 
	                "PASS");
	        
	        //IMPORTANTE: Se ha de especificar el usuario y la contrase�a usado en MySQL
	        //Sustituirlos en "USER" y "PASS"
	        //En caso de tener otros par�metros hay que sustituir por completo el String de conexi�n
	    }
	    
	    public void cerrarConexion() throws SQLException {
	        miConexion.close();
	    }
}
