package com.vipper.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.vipper.modelo.Inmueble;
import com.vipper.persistencia.AccesoBBDD;

@WebListener
public class ListenerSession implements HttpSessionListener {

    public ListenerSession() {}

    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession session= se.getSession();    	
    	AccesoBBDD acceso = new AccesoBBDD();      
    	List<Inmueble> inmueblesList = null;
    	try {
    		inmueblesList = acceso.mostrarInmuebles();
			//Puede que no haya error, pero la BBDD esté vacía
			if(inmueblesList.size()==0) {
				inmueblesList.add(new Inmueble("No hay inmuebles"));
			}			
		} catch (ClassNotFoundException | SQLException e) {
			//Si hay error en la llamada a la BBDD generamos una nueva lista
			inmueblesList = new ArrayList<Inmueble>();
			inmueblesList.add(new Inmueble("No hay inmuebles"));
		}
    	finally {
    		//System.out.println(inmueblesList);
    		session.setAttribute("inmueblesList", inmueblesList);
    		session.setAttribute("todosInmuebles", inmueblesList);
    	}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    }
	
}
