package com.luxitec.nucleo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;

import com.luxitec.nucleo.bean.FiltroPaginado;
import com.luxitec.nucleo.bean.GenericBean;
import com.luxitec.nucleo.bean.ValidateResult;
import com.luxitec.nucleo.msg.MessageCore;
import com.luxitec.utilitarios.exception.ControllerException;
import com.luxitec.utilitarios.exception.ValidarException;

public abstract class LuxitecEntityGenericController<Bean extends GenericBean> extends LuxitecController {

	private static final Logger log = LoggerFactory.getLogger(LuxitecEntityGenericController.class);
	
	@Autowired
	protected MessageCore messageCore;
	
	public void mensajeInfo(HttpRequest req, String string) {
		log.debug("mensajeInfo:"+string);
	}
	
	public void mensajeWarning(HttpRequest req, String string) {
		log.debug("mensajeWarning:"+string);
	}
	
	public void mensajeError(HttpRequest req, String string) {
		log.debug("mensajeError:"+string);
	}
	
//	public abstract List<Bean> listar(boolean _search, String nd, int rows, int page, String sidx, String sord, Bean bean) throws ControllerException;
	public abstract List<Bean> listar( Bean bean, FiltroPaginado filtro, HttpServletRequest httpServletRequest,  HttpServletResponse httpServletResponse, HttpSession httpSession, Model model ) throws ControllerException;
	public abstract void guardar(Bean bean, HttpServletRequest httpServletRequest,  HttpServletResponse httpServletResponse, HttpSession httpSession, Model model ) throws ControllerException;
	public abstract Bean get(Long id, HttpServletRequest httpServletRequest,  HttpServletResponse httpServletResponse, HttpSession httpSession, Model model ) throws ControllerException;
	public abstract Bean eliminar(Bean object, HttpServletRequest httpServletRequest,  HttpServletResponse httpServletResponse, HttpSession httpSession, Model model ) throws ControllerException;
	public abstract ValidateResult validar(Bean object) throws ValidarException;
	
}
