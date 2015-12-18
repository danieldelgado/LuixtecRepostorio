package com.luxitec.nucleo.bean;

import java.util.Date;

import com.luxitec.nucleo.entity.CoreEntidad;

public class FiltroPaginado {
	/**
	 * Pasra beans
	 */
	
	private GenericBean filtro;
	private boolean _search;
	private Date fInicio;
	private Date fFin;
	private Integer pagina;
	private Integer filas;
	private String campoSort;
	private String ordenSort;
	private String nd;
	private int totalRows;	
	
	private int rows; 
	private int page; 
	private String sidx; 
	private String sord;
	
	public GenericBean getFiltro() {
		return filtro;
	}
	
	public void setFiltro(GenericBean filtro) {
		this.filtro = filtro;
	}
	public Date getfInicio() {
		return fInicio;
	}
	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}
	public Date getfFin() {
		return fFin;
	}
	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	public Integer getFilas() {
		return filas;
	}
	public void setFilas(Integer filas) {
		this.filas = filas;
	}
	public String getCampoSort() {
		return campoSort;
	}
	public void setCampoSort(String campoSort) {
		this.campoSort = campoSort;
	}
	public String getOrdenSort() {
		return ordenSort;
	}
	public void setOrdenSort(String ordenSort) {
		this.ordenSort = ordenSort;
	}
	public boolean is_search() {
		return _search;
	}
	public void set_search(boolean _search) {
		this._search = _search;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
		
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		filas = rows;
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		pagina = page;
		this.page = page;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		campoSort = sidx;
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		ordenSort = sord;
		this.sord = sord;
	}
	public FiltroEntidad getFiltroEntidad(){		
		return getFiltroEntidad(null);
	}
	
	public FiltroEntidad getFiltroEntidad(CoreEntidad filtro){
		FiltroEntidad filtroEntidad = new FiltroEntidad();	
		filtroEntidad.setFiltro(filtro);
		filtroEntidad.setfFin(fFin);
		filtroEntidad.setfInicio(fInicio);
		filtroEntidad.setFilas(filas);
		filtroEntidad.setPagina(pagina);		
		return filtroEntidad;
	}
	
	
	
}
