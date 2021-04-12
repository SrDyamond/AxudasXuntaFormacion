package com.fp.mysql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.fp.connection.DatabaseConnection;
import com.fp.dao.AyudaCuantiaDAO;
import com.fp.dao.AyudasXuntaDAO;
import com.fp.dao.DAOManager;
import com.fp.dao.DatosDAO;
import com.fp.dao.SolicitudDependenciasDAO;
import com.fp.dao.SolicitudLibrosDAO;
import com.fp.exceptions.DAOException;
import com.fp.modelo.Datos;

public class MySQLDaoManager implements DAOManager {

	private Connection conn;

	private DatosDAO datos = null;
	private AyudaCuantiaDAO ayudaCuantia = null;
	private AyudasXuntaDAO ayudasXunta = null;
	private SolicitudDependenciasDAO solicitudDependencias = null;
	private SolicitudLibrosDAO solicitudLibros = null;


	@Override
	public DatosDAO getDatosDAO() {
		if (datos == null) {
			datos = new MySQLDatosDAO(conn);
		}
		return datos;
	}

	@Override
	public AyudaCuantiaDAO getAyudaCuantiaDAO() {
		if (ayudaCuantia == null) {
			ayudaCuantia = new MySQLAyudaCuantiaDAO();
		}
		return ayudaCuantia;
	}

	@Override
	public AyudasXuntaDAO getAyudasXuntaDAO() {
		if (ayudasXunta == null) {
			ayudasXunta = new MySQLAyudasXuntaDAO();
		}
		return ayudasXunta;
	}

	@Override
	public SolicitudDependenciasDAO getSolicitudDependeciasDAO() {
		if (solicitudDependencias == null) {
			solicitudDependencias = new MySQLSolicitudDependenciasDAO();
		}
		return solicitudDependencias;
	}

	@Override
	public SolicitudLibrosDAO getSolicitudLibrosDAO() {
		if (solicitudLibros == null) {
			solicitudLibros = new MySQLSolicitudLibrosDAO();
		}
		return solicitudLibros;
	}
}
