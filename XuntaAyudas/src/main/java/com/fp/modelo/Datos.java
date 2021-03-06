package com.fp.modelo;

import java.sql.Date;

public class Datos {
	private String dni;
	private String nombre;
	private Date fecha_nacimiento;
	private double renta_anual;
	private int numero_miembros_familiares;

	public Datos(String dni, String nombre, Date fecha_nacimiento, double renta_anual,
			int numero_miembros_familiares) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.renta_anual = renta_anual;
		this.numero_miembros_familiares = numero_miembros_familiares;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public double getRenta_anual() {
		return renta_anual;
	}

	public void setRenta_anual(double renta_anual) {
		this.renta_anual = renta_anual;
	}

	public int getNumero_miembros_familiares() {
		return numero_miembros_familiares;
	}

	public void setNumero_miembros_familiares(int numero_miembros_familiares) {
		this.numero_miembros_familiares = numero_miembros_familiares;
	}

	@Override
	public String toString() {
		return "Datos_solicitante [dni=" + dni + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", renta_anual=" + renta_anual + ", numero_mienbros_familiares=" + numero_miembros_familiares + "]";
	}

}
