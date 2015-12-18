package com.luxitec.nucleo.dao;

import java.util.List;

import com.luxitec.utilitarios.exception.DAOException;

/**
 * @author Danielle Delgado
 *
 */
public interface IDAO<T>{  
	/**
	 * Metodo para obtener la Entidad por id
	 * @param id
	 */
	public T get(Long id) throws DAOException;	
	/**
	 * Metodo para obtener todos los objetos
	 */
	public List<T> getTodos() throws DAOException;	
	/**
	 * Metodo donde guarda o actualiza el objeto
	 */
	public void guardar(T objeto) throws DAOException;
	/**
	 * Metodo para eliminar
	 */
	public void eliminar(T objeto) throws DAOException;
}
