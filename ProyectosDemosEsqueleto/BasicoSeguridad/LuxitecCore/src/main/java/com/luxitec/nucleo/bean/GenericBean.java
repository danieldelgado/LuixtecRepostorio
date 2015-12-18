package com.luxitec.nucleo.bean;

public abstract class GenericBean {

	private String codigoRelacional;
	private String estado;
	
	public String getCodigoRelacional() {
		return codigoRelacional;
	}

	public void setCodigoRelacional(String codigoRelacional) {
		this.codigoRelacional = codigoRelacional;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public abstract void init();
	
}
