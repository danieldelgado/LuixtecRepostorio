package com.luxitec.nucleo.dao.ext;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luxitec.nucleo.bean.FiltroEntidad;
import com.luxitec.nucleo.bean.EntidadSoporte;
import com.luxitec.nucleo.entity.CoreEntidad;
import com.luxitec.utilitarios.constantes.ConstantesUtil;
import com.luxitec.utilitarios.exception.DAOException;
import com.luxitec.utilitarios.text.Util;
import com.luxitec.utilitarios.validate.ValidateUtil;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class QueryUtil {

	private static final Logger log = LoggerFactory.getLogger(QueryUtil.class);
	/**
	 * %
	 */
	public static String SQL_PORCENT = "%";
	/**
	 * IN
	 */
	public static String SQL_IN = " in ";
	/**
	 * AND
	 */
	public static String SQL_AND = " and ";
	/**
	 * OR
	 */
	public static String SQL_OR = " or ";
	/**
	 * Where
	 */
	public static String SQL_WHERE = " where ";
	/**
	 * p
	 */
	public static String SQL_SE = " p";
	/**
	 * p.
	 */
	public static String SQL_SEA = " p.";
	/**
	 * :
	 */
	public static String SQL_FILTRO = ":";
	/**
	 * menos
	 */
	public static String SQL_MENOS = " < ";
	/**
	 * mas
	 */
	public static String SQL_MAS = " > ";
	/**
	 * select
	 */
	public static String SQL_SELECT = " select ";
	/**
	 * from
	 */
	public static String SQL_FROM = " from ";
	/**
	 * igual
	 */
	public static String SQL_EQ = " = ";
	/**
	 * count
	 */
	public static String SQL_COUNT = " count ";
	/**
	 * like
	 */
	public static String SQL_LIKE = " like ";
	/**
	 * asc
	 */
	public static String SQL_ASC = " asc ";
	/**
	 * desc
	 */
	public static String SQL_DESC = " desc ";
	/**
	 * desigual
	 */
	public static String SQL_EN = " <> ";
	/**
	 * orden
	 */
	public static String ORDER_BY = " order by ";

	public static final String JOIN = " join ";

	public static final String LEFT_JOIN = " left join  ";

	public static final String LEFT_OUTER_JOIN = " left outer join  ";

	public static final String INNER_JOIN = " inner join ";

	public static final String LEFT_JOIN_FETCH = " LEFT JOIN FETCH ";

	public static final String DISTINCT = " DISTINCT ";

	public static final String BETWEEN = " BETWEEN $0$ AND $1$ ";

	public static final String TOKEMN1 = "0";

	public static final String TOKEMNB1 = "$0$";

	public static final String TOKEMN2 = "1";

	public static final String TOKEMNB2 = "$1$";

	public static final String LISTA_LIMItADA_CBO = "limite_cbo";

	public static final String LISTA_COMPLETA = "lista_full";

	private QueryUtil() {
	}

	public static Long count(DAOBaseImpl daobase, FiltroEntidad filtro, String consulta, Query qy) throws DAOException {
		StringBuffer strbfSqlQuery = new StringBuffer();
		strbfSqlQuery.append(consulta);
		qy = daobase.procesarConsulta(filtro.getFiltro(), filtro.getfInicio(), filtro.getfInicio(), strbfSqlQuery);
		Long count = (Long) qy.getSingleResult();
		return count;
	}

	public static <ED extends CoreEntidad> List<ED> getLista(DAOBaseImpl daobase, FiltroEntidad filtro, String consulta, Query qy) throws DAOException {
		StringBuffer strbfSqlQuery = new StringBuffer();
		strbfSqlQuery.append(consulta);
		qy = daobase.procesarConsulta(filtro.getFiltro(), filtro.getfInicio(), filtro.getfFin(), strbfSqlQuery, filtro.getInnerjoin());
		setPaginador(qy, filtro.getFilas() * filtro.getPagina() - filtro.getFilas(), filtro.getFilas());
		setOrder(strbfSqlQuery, filtro.getStrSort(), filtro.getStrOrder());
		List<ED> p = qy.getResultList();
		return p;
	}

	public static <ED extends CoreEntidad> List<ED> getCbo(DAOBaseImpl daobase, FiltroEntidad filtro, String consulta, Query qy, String campoValue) throws DAOException {
		StringBuffer strbfSqlQuery = new StringBuffer();
		strbfSqlQuery.append(consulta);
		qy = daobase.procesarConsulta(filtro.getFiltro(), strbfSqlQuery);
		setOrder(strbfSqlQuery, campoValue, SQL_ASC);
		List<ED> p = qy.getResultList();
		return p;
	}

	public static <ED extends CoreEntidad> List<ED> getPorID(DAOBaseImpl daobase, FiltroEntidad filtro, String queryLimite, String queryALL, Query qy, String campoValue, Integer[] ids, String tipo) throws DAOException {
		StringBuffer strbfSqlQuery = new StringBuffer();
		if (tipo.equals(LISTA_LIMItADA_CBO)) {
			strbfSqlQuery.append(queryLimite);
		} else if (tipo.equals(LISTA_COMPLETA)) {
			strbfSqlQuery.append(queryALL);
		}
		qy = daobase.procesarConsulta(filtro.getFiltro(), ids, strbfSqlQuery, filtro.getInnerjoin());
		setOrder(strbfSqlQuery, campoValue, SQL_ASC);
		List<ED> p = qy.getResultList();
		return p;
	}

	public static String getCodigoGenerico(CoreEntidad CoreEntidad) {
		Calendar c = Calendar.getInstance();
		return CoreEntidad.getClass().getSimpleName() + "-" + c.getTimeInMillis() + "-" + Util.random();
	}

	public static String getJsonObject(CoreEntidad CoreEntidad) {
		String gsonString = Util.getJson(CoreEntidad);
		return "{" + CoreEntidad.getClass().getSimpleName() + ":[" + gsonString + "]}";
	}

	/**
	 * Agrega condicion
	 * 
	 * @param sbQuery
	 * @param condicion
	 * @param param
	 */
	public static boolean establecerCondicion(StringBuffer sbQuery, String condicion, Object param) {
		if (sbQuery.toString().indexOf(SQL_WHERE) == -1 && ValidateUtil.isNotNull(param)) {
			sbQuery.append(SQL_WHERE);
		}
		if (ValidateUtil.isNotNull(param)) {
			sbQuery.append(condicion);
			sbQuery.append(SQL_AND);
			return true;
		} else
			return false;
	}

	/**
	 * Agrega condicion IN
	 * 
	 * @param sbQuery
	 * @param condicion
	 * @param param
	 */
	public static boolean establecerCondicionIN(StringBuffer sbQuery, String condicion, List<?> param) {
		if (sbQuery.toString().indexOf(SQL_WHERE) == -1 && ValidateUtil.isNotNull(param)) {
			sbQuery.append(SQL_WHERE);
		}
		if (param != null && !param.isEmpty()) {
			sbQuery.append(condicion);
			sbQuery.append(SQL_AND);
			return true;
		} else
			return false;
	}

	/**
	 * Agrega parametro
	 * 
	 * @param query
	 * @param nombCampo
	 * @param param
	 */
	public static void establecerParam(Query query, String nombCampo, Object param) {
		establecerParam(query, nombCampo, param, false, false);
	}

	/**
	 * Agrega parametro IN
	 * 
	 * @param query
	 * @param nombCampo
	 * @param param
	 */
	public static void establecerParamIN(Query query, String nombCampo, List<?> param) {
		if (param != null && !param.isEmpty()) {
			query.setParameter(nombCampo, param);
		}
	}

	/**
	 * Agrega parametro like mayuscula
	 * 
	 * @param query
	 * @param nombCampo
	 * @param param
	 * @param esLike
	 * @param convertirMayuscula
	 */
	public static void establecerParam(Query query, String nombCampo, Object param, boolean esLike, boolean convertirMayuscula) {
		if (ValidateUtil.isNotNull(param)) {
			if (esLike) {
				query.setParameter(nombCampo, SQL_PORCENT + (convertirMayuscula ? param.toString().toUpperCase() : param) + SQL_PORCENT);
			} else {
				query.setParameter(nombCampo, param);
			}
		}
	}

	/**
	 * Asignar al query inicio y fin
	 * 
	 * @param qy
	 * @param inicio
	 * @param fin
	 */
	public static void setPaginador(Query qy, int inicio, int fin) {
		if (inicio > ConstantesUtil.NUMBER_0 && fin > ConstantesUtil.NUMBER_0) {
			qy.setFirstResult(inicio);
			qy.setMaxResults(fin);
		}
	}

	/**
	 * Asignar al query inicio y fin
	 * 
	 * @param qy
	 * @param inicio
	 * @param fin
	 */
	public static void setPaginado(Query qy, int filas, int pagina) {
		if (filas > ConstantesUtil.NUMBER_0 && pagina > -ConstantesUtil.NUMBER_1) {
			qy.setFirstResult(filas * pagina - filas);
			qy.setMaxResults(filas);
		}
	}

	public static void setOrder(StringBuffer sbQuery, String strCampo, String order) {
		if (ValidateUtil.isNotNull(strCampo) && ValidateUtil.isNotNull(order)) {
			sbQuery.append(ORDER_BY + strCampo + order);
		}
	}

	/**
	 * Print query
	 * 
	 * @param q
	 */
	public static void printParameterQuery(Query q) {
//		if (log.isDebugEnabled()) {
			log.debug("printParameterQuery");
			List<Parameter<?>> listaParametros = Arrays.asList(q.getParameters().toArray(new Parameter<?>[0]));
			if (ValidateUtil.isNotNull(listaParametros)) {
				for (Parameter<?> parameter : listaParametros) {
					log.debug(parameter.getName() + SQL_FILTRO + q.getParameterValue(parameter.getName()).toString());
				}
			}
//		}
	}

	/**
	 * Establece los inner joins para el query
	 * 
	 * @param strbfSqlQuery
	 * @param innerjoin
	 */
	public static void establecerCondicionInnerJoins(StringBuffer sbQuery, EntidadSoporte... innerjoin) {
		int existe = sbQuery.toString().indexOf(SQL_WHERE);
		String strCondicionales = ConstantesUtil.VACIO;
		if (existe >= ConstantesUtil.NUMBER_0 && ValidateUtil.isNotNull(innerjoin)) {
			String strTemp1 = sbQuery.toString();
			strCondicionales = strTemp1.substring(existe, strTemp1.length());
			strTemp1 = strTemp1.substring(existe);
			sbQuery = new StringBuffer(strTemp1);
		}
		if (ValidateUtil.isNotNull(innerjoin)) {
			for (EntidadSoporte ij : innerjoin) {
				sbQuery.append(ij.getInner() + ConstantesUtil.SPACE);
				sbQuery.append(SQL_SEA + ij.getEntidad() + ConstantesUtil.SPACE + ij.getPerfijo());
				if (ValidateUtil.isNotNull(ij.getAtributo())) {
					sbQuery.append(ij.getPerfijo() + ConstantesUtil.PERIOD + ij.getAtributo() + " ");
					sbQuery.append(ij.getCondicional() + ConstantesUtil.SPACE);
					sbQuery.append(SQL_FILTRO + ij.getAtributo() + ConstantesUtil.SPACE);
				}
			}
		}
		sbQuery.append(strCondicionales);
	}

	/**
	 * Establece los valores de la conuslta sobre los joins
	 * 
	 * @param qy
	 * @param innerjoin
	 */
	public static void establecerInnerJoinsParam(Query qy, EntidadSoporte[] innerjoin) {
		if (ValidateUtil.isNotNull(innerjoin)) {
			for (EntidadSoporte joinCoreEntidad : innerjoin) {
				if (ValidateUtil.isNotNull(joinCoreEntidad.getAtributo()) && ValidateUtil.isNotNull(joinCoreEntidad.getValue())) {
					qy.setParameter(joinCoreEntidad.getAtributo(), joinCoreEntidad.getValue());
				}
			}
		}
	}

}
