package com.luxitec.nucleo.bean;

import java.util.List;

public class ViewList {

	private String titulo;
	private Boolean withEntidad;
	private String tabla;
	private List<ViewColumn> columns;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Boolean getWithEntidad() {
		return withEntidad;
	}
	public void setWithEntidad(Boolean withEntidad) {
		this.withEntidad = withEntidad;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public List<ViewColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<ViewColumn> columns) {
		this.columns = columns;
	}
	
}
