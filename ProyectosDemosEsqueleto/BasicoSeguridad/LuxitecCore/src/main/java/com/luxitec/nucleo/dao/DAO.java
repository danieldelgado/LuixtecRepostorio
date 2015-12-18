package com.luxitec.nucleo.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.luxitec.nucleo.entity.CoreEntidad;
import com.luxitec.utilitarios.exception.DAOException;
import com.luxitec.utilitarios.validate.ValidateUtil;

/**
 * @author Danielle Delgado
 * 
 */
@SuppressWarnings({ "unchecked", "cast" })
public abstract class DAO<T extends CoreEntidad> implements IDAO<T> {

	private static final Logger log = LoggerFactory.getLogger(DAO.class);
	/**
	 * EntityManager es la variable donde el contexto obtiene la conexion a la
	 * base de datos
	 */
	protected EntityManager entityManager;
	/**
	 * Objeto por donde se ejecuatan las querys
	 */
	protected Query qy = null;
	/**
	 * La clase CoreEntidad
	 */
	private Class<CoreEntidad> clazz;

	/**
	 * Constructor donde se instancia el DAOImpl
	 */
	public DAO() {
		clazz = (Class<CoreEntidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		if (log.isDebugEnabled()) {
			log.debug(" [ Crea aspecto de la CoreEntidad:" + clazz.getName() + "]");
		}
	}

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

	/**
	 * Metodo para obtener la CoreEntidad por id
	 * 
	 * @param id
	 */
	public T get(Long id) throws DAOException {
		try {
			return (T) entityManager.find(clazz, id);
		} catch (Exception e) {
			log.error("[ get  " + clazz.getName() + " error: " + e.getMessage() + " ]", e);
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * Metodo para obtener todos los objetos
	 */
	public List<T> getTodos() throws DAOException {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0) {
			nombre = clazz.getSimpleName();
		} else {
			nombre = e.name();
		}
		StringBuffer sql = new StringBuffer(100);
		sql.append("SELECT e FROM " + nombre + " e");
		if (log.isDebugEnabled()) {
			log.debug("[ Entro al metodo getTodos de CoreEntidad " + clazz.getName() + "  con query: " + sql + " ]");
		}
		return entityManager.createQuery(sql.toString()).getResultList();
	}

	/**
	 * Metodo donde guarda o actualiza el objeto
	 */
	@Transactional
	public void guardar(T objeto) throws DAOException {
		try {
			if (log.isDebugEnabled()) {
				log.debug("[ Entro al metodo guardar de CoreEntidad " + clazz.getName() + " ]");
			}
			if (ValidateUtil.isNull(objeto.getId())) {
				entityManager.merge(objeto);
			} else {
				entityManager.persist(objeto);
			}
			if (log.isDebugEnabled()) {
				log.debug("[ Transaction terminada  " + clazz.getName() + " con id :" + objeto.getId() + "::> objeto registrado ]");
			}
		} catch (Exception e) {
			log.error("[ Transaction rollback  " + clazz.getName() + " error: " + e.getMessage() + " ]", e);
			throw new DAOException(e.getMessage());
		} finally {
			if (log.isDebugEnabled()) {
				log.debug("[ Transaction cerrada finally " + clazz.getName() + " ]");
			}
		}
	}

	/**
	 * Metodo para eliminar
	 */
	@Transactional
	public void eliminar(T objeto) throws DAOException {
		try {
			if (ValidateUtil.isNull(objeto.getId())) {
				entityManager.remove(objeto);
			}
		} catch (Exception e) {
			log.error(" Transaction rollback  " + clazz.getName() + " error: " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			if (log.isDebugEnabled()) {
				log.debug(" Transaction cerrada  " + clazz.getName());
			}
		}
	}

}