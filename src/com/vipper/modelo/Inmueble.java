package com.vipper.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inmueble implements Serializable{
	private static final long serialVersionUID = 1L;
	private String referencia, direccion, cp, localidad, descripcion, tipo, urlimagen;
	private double metros, precio;
	private int banos, dormitorios;
	private boolean disponible;
	private LocalDate fbaja;
	
	@Override
	public String toString() {
		return "Inmueble [referencia=" + referencia + ", direccion=" + direccion + ", cp=" + cp + ", localidad="
				+ localidad + ", descripcion=" + descripcion + ", tipo=" + tipo + ", urlimagen=" + urlimagen
				+ ", metros=" + metros + ", precio=" + precio + ", banos=" + banos + ", dormitorios=" + dormitorios
				+ ", disponible=" + disponible + ", fbaja=" + fbaja + "]";
	}

	
	public Inmueble() {	}
	
	public Inmueble(String descripcion) {
		this.descripcion = descripcion;
	}

	public Inmueble(String referencia, String direccion, String cp, String localidad, String urlimagen, double metros,
			double precio, int banos, int dormitorios) {
		this.referencia = referencia;
		this.direccion = direccion;
		this.cp = cp;
		this.localidad = localidad;
		this.urlimagen = urlimagen;
		this.metros = metros;
		this.precio = precio;
		this.banos = banos;
		this.dormitorios = dormitorios;
	}

	public Inmueble(String referencia, String direccion, String cp, String localidad, String descripcion, String tipo,
			String urlimagen, double metros, double precio, int banos, int dormitorios, boolean disponible,
			LocalDate fbaja) {
		this.referencia = referencia;
		this.direccion = direccion;
		this.cp = cp;
		this.localidad = localidad;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.urlimagen = urlimagen;
		this.metros = metros;
		this.precio = precio;
		this.banos = banos;
		this.dormitorios = dormitorios;
		this.disponible = disponible;
		this.fbaja = fbaja;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getUrlimagen() {
		return urlimagen;
	}


	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}


	public double getMetros() {
		return metros;
	}


	public void setMetros(double metros) {
		this.metros = metros;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getBanos() {
		return banos;
	}


	public void setBanos(int banos) {
		this.banos = banos;
	}


	public int getDormitorios() {
		return dormitorios;
	}


	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public LocalDate getFbaja() {
		return fbaja;
	}


	public void setFbaja(LocalDate fbaja) {
		this.fbaja = fbaja;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
