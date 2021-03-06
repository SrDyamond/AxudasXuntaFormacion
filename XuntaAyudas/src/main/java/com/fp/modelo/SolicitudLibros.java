package com.fp.modelo;

import java.sql.Date;

public class SolicitudLibros {
	private long cod_sol;
	private Date codigo_solicitud;
	private String curso;
	private int id_LFK;
	private String dni_LFK;
	private int cuantia_LFK;

	public SolicitudLibros(long cod_sol, Date codigo_solicitud, String curso, int id_LFK, String dni_LFK,
			int cuantia_LFK) {
		super();
		this.cod_sol = cod_sol;
		this.codigo_solicitud = codigo_solicitud;
		this.curso = curso;
		this.id_LFK = id_LFK;
		this.dni_LFK = dni_LFK;
		this.cuantia_LFK = cuantia_LFK;
	}

	public long getCod_sol() {
		return cod_sol;
	}

	public void setCod_sol(long cod_sol) {
		this.cod_sol = cod_sol;
	}

	public Date getCodigo_solicitud() {
		return codigo_solicitud;
	}

	public void setCodigo_solicitud(Date codigo_solicitud) {
		this.codigo_solicitud = codigo_solicitud;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getId_LFK() {
		return id_LFK;
	}

	public void setId_LFK(int id_LFK) {
		this.id_LFK = id_LFK;
	}

	public String getDni_LFK() {
		return dni_LFK;
	}

	public void setDni_LFK(String dni_LFK) {
		this.dni_LFK = dni_LFK;
	}

	public int getCuantia_LFK() {
		return cuantia_LFK;
	}

	public void setCuantia_LFK(int cuantia_LFK) {
		this.cuantia_LFK = cuantia_LFK;
	}

	@Override
	public String toString() {
		return "Solicitud_libros [cod_sol=" + cod_sol + ", codigo_solicitud=" + codigo_solicitud + ", curso=" + curso
				+ ", id_LFK=" + id_LFK + ", dni_LFK=" + dni_LFK + ", cuantia_LFK=" + cuantia_LFK + "]";
	}

}
