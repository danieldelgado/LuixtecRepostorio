package com.luxitec.nucleo.bean;

public class EntidadSoporte {	
	
	private String inner;
	private String perfijo;
	private String entidad;
	private String atributo;	
	private String condicional;	
	private String value;
	
	private String query;	
	private Object valor;	
	
	private Boolean like=false;
	private Boolean igual=false;
	private Boolean menos=false;
	private Boolean mayor=false;
	
	private Boolean between=false;
	private String query2;		
	private Object valor2;
	
	
	public EntidadSoporte() {
	}		
	public EntidadSoporte(String inner, String perfijo, String entidad) {
		this.inner = inner;
		this.perfijo = perfijo;
		this.entidad = entidad;
	}
	public EntidadSoporte(String inner, String perfijo, String entidad, String atributo, String condicional,String value) {
		this.inner = inner;
		this.perfijo = perfijo;
		this.entidad = entidad;
		this.atributo = atributo;
		this.condicional = condicional;
		this.value = value;
	}
	
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	public Boolean getLike() {
		return like;
	}
	public void setLike(Boolean like) {
		this.like = like;
	}
	public Boolean getIgual() {
		return igual;
	}
	public void setIgual(Boolean igual) {
		this.igual = igual;
	}
	public Boolean getMenos() {
		return menos;
	}
	public void setMenos(Boolean menos) {
		this.menos = menos;
	}
	public Boolean getMayor() {
		return mayor;
	}
	public void setMayor(Boolean mayor) {
		this.mayor = mayor;
	}
	public Boolean getBetween() {
		return between;
	}
	public void setBetween(Boolean between) {
		this.between = between;
	}
	public String getQuery2() {
		return query2;
	}
	public void setQuery2(String query2) {
		this.query2 = query2;
	}
	public Object getValor2() {
		return valor2;
	}
	public void setValor2(Object valor2) {
		this.valor2 = valor2;
	}
	public String getInner() {
		return inner;
	}
	public void setInner(String inner) {
		this.inner = inner;
	}
	public String getPerfijo() {
		return perfijo;
	}
	public void setPerfijo(String perfijo) {
		this.perfijo = perfijo;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public String getCondicional() {
		return condicional;
	}
	public void setCondicional(String condicional) {
		this.condicional = condicional;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}	
}