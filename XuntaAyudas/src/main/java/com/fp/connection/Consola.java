package com.fp.connection;

import java.sql.SQLException;
import java.util.List;

import com.fp.exceptions.DAOException;
import com.fp.modelo.Datos;
import com.fp.mysql.dao.MySQLDatosDAO;

public class Consola {
	public static void main(String[] args) throws SQLException, DAOException {
//		MySQLDaoManager man = new MySQLDaoManager("jdbc:mysql://localhost:3306/xunta_galicia_axudas", "root", "3270Clb20616!");
//		List<Datos> datos = man.getDatosDAO().obtener_todos();
//		System.out.println(datos);
		MySQLDatosDAO a = new MySQLDatosDAO();
		List<Datos> datos = a.obtener_todos();
		System.out.println(datos);
	}

}
