package com.luxitec.nucleo.dao.ext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public abstract class DAOBase {
	/**
	 * EntityManager es la variable donde el contexto obtiene la conexion a la
	 * base de datos
	 */
	protected EntityManager entityManager = null;	
	/**
	 * Objeto por donde se ejecuatan las querys
	 */
	protected Query query = null;	
	/**
	 * Obtiene del contexto del Spring la conexion a la base de datos
	 * 
	 * @param em
	 */
	@PersistenceContext
	protected void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
