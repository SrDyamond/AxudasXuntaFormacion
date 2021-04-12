package com.fp.mysql.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fp.dao.DatosDAO;
import com.fp.exceptions.DAOException;
import com.fp.modelo.Datos;

public class MySQLDatosDAO implements DatosDAO {

	final String INSERT = "INSERT INTO datos_solicitante(dni, nombre, fecha_nacimiento, renta_anual, numero_miembros_familiares) VALUES(?,?,?,?,?,?)";
	final String UPDATE = "UPDATE datos_solicitante SET nombre = ?, fecha_nacimento = ?, renta_anual = ?, numero_miembros_familiares = ? WHERE dni = ?";
	final String DELETE = "DELETE FROM datos_solicitante WHERE dni = ?";
	final String GETALL = "SELECT dni, nombre, fecha_nacimiento, renta_anual, numero_miembros_familiares FROM datos_solicitante";
	final String GETONE = "SELECT dni, nombre, fecha_nacimiento, renta_anual, numero_miembros_familiares FROM datos_solicitante WHERE dni = ?";

	private Connection conn;

	public MySQLDatosDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insertar(Datos a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setString(1, a.getDni());
			stat.setString(2, a.getNombre());
			stat.setDate(3, new Date(a.getFecha_nacimiento().getTime()));
			stat.setDouble(4, a.getRenta_anual());
			stat.setInt(5, a.getNumero_miembros_familiares());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("Error sql", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error cerrando conexion", e);
				}
			}
		}
	}

	@Override
	public void modificar(Datos a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Datos a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE);
			stat.setString(1, a.getDni());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("Error sql", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error cerrando conexion", e);
				}
			}
		}

	}

	private Datos convertir(ResultSet rs) throws SQLException {
		String dni = rs.getString("dni");
		String nombre = rs.getString("nombre");
		Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
		double renta_anual = rs.getDouble("renta_anual");
		int numero_miembros_familiares = rs.findColumn("numero_miembros_familiares");
		Datos datos = new Datos(dni, nombre, fecha_nacimiento, renta_anual, numero_miembros_familiares);

		return datos;

	}

	@Override
	public List<Datos> obtener_todos() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Datos> datos = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while(rs.next()) {
				datos.add(convertir(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("Error sql", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("Error cerrando conexion", e);
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error cerrando conexion", e);
				}
			}
		}
		return datos;
	}

	@Override
	public Datos obtener(String pk) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Datos datos = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setString(1, pk);
			rs = stat.executeQuery();
			if (rs.next()) {
				datos = convertir(rs);
			} else {
				throw new DAOException("No se ha encontrado ese registro");
			}
			if (stat.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("Error sql", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("Error cerrando conexion", e);
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error cerrando conexion", e);
				}
			}
		}

		return datos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
