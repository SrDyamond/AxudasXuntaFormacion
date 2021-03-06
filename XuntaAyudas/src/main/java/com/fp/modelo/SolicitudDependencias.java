package com.fp.modelo;

import java.sql.Date;

public class SolicitudDependencias {
	private long cod_sol;
	private Date codigo_solicitud;
	private int grado_dependecia;
	private int id_DFK;
	private String dni_DFK;
	private int cuantia_DFK;

	public SolicitudDependencias(long cod_sol, Date codigo_solicitud, int grado_dependecia, int id_DFK, String dni_DFK,
			int cuantia_DFK) {
		super();
		this.cod_sol = cod_sol;
		this.codigo_solicitud = codigo_solicitud;
		this.grado_dependecia = grado_dependecia;
		this.id_DFK = id_DFK;
		this.dni_DFK = dni_DFK;
		this.cuantia_DFK = cuantia_DFK;
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

	public int getGrado_dependecia() {
		return grado_dependecia;
	}

	public void setGrado_dependecia(int grado_dependecia) {
		this.grado_dependecia = grado_dependecia;
	}

	public int getId_DFK() {
		return id_DFK;
	}

	public void setId_DFK(int id_DFK) {
		this.id_DFK = id_DFK;
	}

	public String getDni_DFK() {
		return dni_DFK;
	}

	public void setDni_DFK(String dni_DFK) {
		this.dni_DFK = dni_DFK;
	}

	public int getCuantia_DFK() {
		return cuantia_DFK;
	}

	public void setCuantia_DFK(int cuantia_DFK) {
		this.cuantia_DFK = cuantia_DFK;
	}

	@Override
	public String toString() {
		return "Solicitud_dependencias [cod_sol=" + cod_sol + ", codigo_solicitud=" + codigo_solicitud
				+ ", grado_dependecia=" + grado_dependecia + ", id_DFK=" + id_DFK + ", dni_DFK=" + dni_DFK
				+ ", cuantia_DFK=" + cuantia_DFK + "]";
	}

}
