package com.fp.connection;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.*;

import com.fp.exceptions.DAOException;
import com.fp.modelo.Datos;
import com.fp.mysql.dao.MySQLDatosDAO;

public class Consola {
	private static final Logger logger = Logger.getLogger(Consola.class);
	public static void main(String[] args) throws SQLException, DAOException {
		
		MySQLDatosDAO a = new MySQLDatosDAO();
		List<Datos> datos = a.obtener_todos();
		System.out.println(datos);
		logger.debug(datos);
	}
	
	public void getStringForJSPPage() throws DAOException {
		MySQLDatosDAO a = new MySQLDatosDAO();
		List<Datos> datos = a.obtener_todos();
		System.out.println(datos);
		logger.debug(datos);
		
		
	}

}
