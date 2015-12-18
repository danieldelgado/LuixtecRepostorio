package com.luxitec.nucleo.service;

import java.util.List;

import com.luxitec.nucleo.bean.FiltroPaginado;
import com.luxitec.nucleo.bean.GenericBean;
import com.luxitec.nucleo.entity.CoreEntidad;
import com.luxitec.utilitarios.exception.ServiceException;

public abstract class LuxitecEntityGenericService<Entidad extends CoreEntidad,Bean extends GenericBean> extends LuxitecService{

	public abstract List<Bean> listar(FiltroPaginado filtro) throws ServiceException;
	public abstract void guardar(Entidad bean) throws ServiceException;
	public abstract Entidad get(Long id) throws ServiceException;
	public abstract Entidad eliminar(Entidad object) throws ServiceException;
	
}
