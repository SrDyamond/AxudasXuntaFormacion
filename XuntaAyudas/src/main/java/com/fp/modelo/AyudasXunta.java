package com.fp.modelo;

public class AyudasXunta {
	private long id;
	private String tipo_ayuda;

	public AyudasXunta(long id, String tipo_ayuda) {
		super();
		this.id = id;
		this.tipo_ayuda = tipo_ayuda;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo_ayuda() {
		return tipo_ayuda;
	}

	public void setTipo_ayuda(String tipo_ayuda) {
		this.tipo_ayuda = tipo_ayuda;
	}

	@Override
	public String toString() {
		return "Ayudas_xunta [id=" + id + ", tipo_ayuda=" + tipo_ayuda + "]";
	}

}
