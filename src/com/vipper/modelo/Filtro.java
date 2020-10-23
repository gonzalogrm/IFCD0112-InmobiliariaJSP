package com.vipper.modelo;

import java.io.Serializable;

public class Filtro implements Serializable{
	private static final long serialVersionUID = 1L;
	private double precioDesde, precioHasta;
	private int dormitorios, banos;
	
	@Override
	public String toString() {
		return "Filtro [precioDesde=" + precioDesde + ", precioHasta=" + precioHasta + ", dormitorios=" + dormitorios
				+ ", banos=" + banos + "]";
	}
	
	public Filtro() {
		super();
	}

	public Filtro(double precioDesde, double precioHasta, int dormitorios, int banos) {
		super();
		this.precioDesde = precioDesde;
		this.precioHasta = precioHasta;
		this.dormitorios = dormitorios;
		this.banos = banos;
	}

	public double getPrecioDesde() {
		return precioDesde;
	}

	public void setPrecioDesde(double precioDesde) {
		this.precioDesde = precioDesde;
	}

	public double getPrecioHasta() {
		return precioHasta;
	}

	public void setPrecioHasta(double precioHasta) {
		this.precioHasta = precioHasta;
	}

	public int getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public int getBanos() {
		return banos;
	}

	public void setBanos(int banos) {
		this.banos = banos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
