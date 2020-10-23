package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.Filtro;
import com.vipper.modelo.Inmueble;
import com.vipper.persistencia.AccesoBBDD;
import com.vipper.persistencia.Conexion;


@WebServlet("/ServletDetalleInmueble")
public class ServletDetalleInmueble extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletDetalleInmueble() {
        super();
    }

    //Entra desde un href
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String referencia = request.getParameter("referencia");
		Inmueble inmuebleDetalle = null;
		AccesoBBDD acceso = new AccesoBBDD();
		try {
			inmuebleDetalle = acceso.selectInmuebles(referencia);
			request.setAttribute("inmuebleDetalle", inmuebleDetalle);
			RequestDispatcher rd = request.getRequestDispatcher("/mostrardetalle.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);		
		HttpSession session = request.getSession();
		Filtro filtro = (Filtro)(request.getAttribute("filtroBean"));
		
        AccesoBBDD acceso = new AccesoBBDD();
        List<Inmueble> inmueblesFiltro = null;    
        
        inmueblesFiltro = acceso.filtrarPrecio(
			(List<Inmueble>)(session.getAttribute("todosInmuebles")), filtro);          
        if(filtro.getDormitorios()>0) {
        	inmueblesFiltro = acceso.filtrarDormitorios(inmueblesFiltro, filtro);
        }      
        if(filtro.getBanos()>0) {
        	inmueblesFiltro = acceso.filtrarBanos(inmueblesFiltro, filtro);
        }
        
        //Guardar en session
		session.setAttribute("inmueblesList", inmueblesFiltro);
		//Redireccionar al jsp
		//RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");		
		//rd.forward(request, response);
		
		//Como hay Beans de por medio, enviamos con sendRedirect. Ignora los beans
		response.sendRedirect("index.jsp");
		
	}

}
