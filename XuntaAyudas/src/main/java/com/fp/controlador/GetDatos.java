package com.fp.controlador;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import com.fp.connection.Consola;
import com.fp.exceptions.DAOException;
import com.fp.modelo.Datos;
import com.fp.mysql.dao.MySQLDatosDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDatos
 */
@WebServlet("/GetDatos")
public class GetDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Consola consola = new Consola();
	static PrintWriter out ;
	List<Datos> datos = null;

    /**
     * Default constructor. 
     */
    public GetDatos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MySQLDatosDAO a = new MySQLDatosDAO();
		List<Datos> datos = null;
		try {
			datos = a.obtener_todos();
		} catch (ClassNotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(datos);
		
		request.setAttribute("datos", datos);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
