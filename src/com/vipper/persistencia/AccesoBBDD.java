package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;

import com.vipper.modelo.*;
import java.util.Calendar;
import java.util.HashMap;

public class AccesoBBDD extends Conexion {
	
	//Acceso a tablas en la BBDD
	public List<Inmueble> mostrarInmuebles() throws ClassNotFoundException, SQLException{
		//Definir variables
        CallableStatement st;
        ResultSet rs;
        String sql = "call inmuebles.mostrarInmuebles();";
        List<Inmueble> result = new ArrayList<Inmueble>();
        
        //Abrir la conexion
        abrirConexion();        
        //Obtener el ResultSet
        st = miConexion.prepareCall(sql);
        //Ejecutar
        rs = st.executeQuery();
        
        //Recorrer el resultSet
        while (rs.next()) {
        	Inmueble addInmueble = new Inmueble();
        	//String
        	addInmueble.setReferencia(rs.getString("referencia"));
        	addInmueble.setDireccion(rs.getString("direccion"));
        	addInmueble.setCp(rs.getString("cp"));
        	addInmueble.setLocalidad(rs.getString("localidad"));
        	addInmueble.setUrlimagen(rs.getString("urlimagen"));      
        	//Double
        	addInmueble.setMetros(rs.getDouble("metros"));
        	addInmueble.setPrecio(rs.getDouble("precio"));	   
        	//Integer
        	addInmueble.setBanos(rs.getInt("banos"));
        	addInmueble.setDormitorios(rs.getInt("dormitorios"));	
        	
        	result.add(addInmueble);
        }
        
        cerrarConexion();
        
        return result;
	}

	public Inmueble selectInmuebles(String referencia) throws ClassNotFoundException, SQLException{
		//Definir variables
        CallableStatement st;
        ResultSet rs;
        String sql = "call inmuebles.selectInmuebles(?);";
        Inmueble result = null;
        
        //Abrir la conexion
        abrirConexion();        
        //Obtener el ResultSet
        st = miConexion.prepareCall(sql);
        st.setString(1,referencia);
      //Ejecutar
        rs = st.executeQuery();
        
        //Recorrer el resultSet
        /*
         * String referencia, String direccion, String cp, String localidad, String descripcion, String tipo,
			String urlimagen, double metros, double precio, int banos, int dormitorios, boolean disponible,
			LocalDate fbaja
         */
        if (rs.next()) {
        	result = new Inmueble(
                    rs.getString("referencia"),
                    rs.getString("direccion"),
                    rs.getString("cp"),
                    rs.getString("localidad"),
                    rs.getString("descripcion"),
                    rs.getString("tipo"),
                    rs.getString("urlimagen"),
                    rs.getDouble("metros"),
                    rs.getDouble("precio"),
                    rs.getInt("banos"),
                    rs.getInt("dormitorios"),
                    rs.getBoolean("disponible"),
                    rs.getDate("fbaja").toLocalDate()
        			);
        }
        
        System.out.println("RESULT:" + result);
        
        cerrarConexion();
        
        return result;
	}

	public List<Inmueble> filtrarPrecio(List<Inmueble> entrada, Filtro filtro){
		Stream<Inmueble> filtrado = 
				entrada.stream().filter(
						i -> (i.getPrecio() >= filtro.getPrecioDesde() && i.getPrecio() <= filtro.getPrecioHasta()));
		return filtrado.collect(Collectors.toList());
	}
	
	public List<Inmueble> filtrarDormitorios(List<Inmueble> entrada, Filtro filtro){
		Stream<Inmueble> filtrado = 
				entrada.stream().filter(i -> i.getDormitorios()==filtro.getDormitorios());
		return filtrado.collect(Collectors.toList());
	}
	
	public List<Inmueble> filtrarBanos(List<Inmueble> entrada, Filtro filtro){
		Stream<Inmueble> filtrado = 
				entrada.stream().filter(i -> i.getBanos()==filtro.getBanos());
		return filtrado.collect(Collectors.toList());
	}
}
