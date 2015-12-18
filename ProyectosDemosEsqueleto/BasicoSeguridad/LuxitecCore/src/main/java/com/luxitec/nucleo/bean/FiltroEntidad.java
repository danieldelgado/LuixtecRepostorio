package com.luxitec.nucleo.bean;

import java.util.Date;

import com.luxitec.nucleo.entity.CoreEntidad;
import com.luxitec.utilitarios.validate.ValidateUtil;


public class FiltroEntidad {
	
	private Date fInicio;
	private Date fFin;
	private Integer pagina;
	private Integer filas;
	private String strSort;
	private String strOrder;
	private CoreEntidad filtro;
	private EntidadSoporte[] innerjoin;
	
	public CoreEntidad getFiltro() {
		return filtro;
	}
	public void setFiltro(CoreEntidad filtro) {
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
	public EntidadSoporte[] getInnerjoin() {
		return innerjoin;
	}
	public void setInnerjoin(EntidadSoporte[] innerjoin) {
		this.innerjoin = innerjoin;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		if(ValidateUtil.isNull(pagina)){
			pagina = 0;
		}
		this.pagina = pagina;
	}
	public Integer getFilas() {
		return filas;
	}
	public void setFilas(Integer filas) {
		if(ValidateUtil.isNull(filas)){
			filas = 0;
		}
		this.filas = filas;
	}
	public String getStrSort() {
		return strSort;
	}
	public void setStrSort(String strSort) {
		this.strSort = strSort;
	}
	public String getStrOrder() {
		return strOrder;
	}
	public void setStrOrder(String strOrder) {
		this.strOrder = strOrder;
	}
	public FiltroPaginado getFiltroPaginado(){		
		return getFiltroPaginado(null);
	}
	
	public FiltroPaginado getFiltroPaginado(GenericBean filtro){
		FiltroPaginado filtroPaginado = new FiltroPaginado();	
		filtroPaginado.setFiltro(filtro);
		filtroPaginado.setfFin(fFin);
		filtroPaginado.setfInicio(fInicio);
		filtroPaginado.setFilas(filas);
		filtroPaginado.setPagina(pagina);		
		return filtroPaginado;
	}
	

	
}
