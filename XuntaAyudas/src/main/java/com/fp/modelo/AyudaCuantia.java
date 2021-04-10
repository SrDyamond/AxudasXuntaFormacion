package com.fp.modelo;

public class AyudaCuantia {
	private long ayuda;

	public AyudaCuantia(long ayuda) {
		super();
		this.ayuda = ayuda;
	}

	public long getAyuda() {
		return ayuda;
	}

	public void setAyuda(long ayuda) {
		this.ayuda = ayuda;
	}

	@Override
	public String toString() {
		return "Ayuda_cuantia [ayuda=" + ayuda + "]";
	}

}
