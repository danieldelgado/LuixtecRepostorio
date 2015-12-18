package com.luxitec.nucleo.dao.ext;

import java.util.Date;

import javax.persistence.Query;

import com.luxitec.nucleo.bean.EntidadSoporte;
import com.luxitec.nucleo.entity.CoreEntidad;

public abstract class DAOBaseImpl<T extends CoreEntidad>  {

	protected abstract Query procesarConsulta(T filtro, StringBuffer strbfSqlQuery, EntidadSoporte... innerjoin);

	protected abstract Query procesarConsulta(T filtro, Date finit, Date ffin, StringBuffer strbfSqlQuery, EntidadSoporte... innerjoin);

	protected abstract Query procesarConsulta(T objEntidad, Integer[] ids, StringBuffer strbfSqlQuery, EntidadSoporte... innerjoin);

	protected abstract void setValues(T objEntidad, Integer[] ids, StringBuffer strbfSqlQuery, EntidadSoporte... innerjoin);

	protected abstract void setValues(T filtro, Date finit, Date ffin, StringBuffer strbfSqlQuery, EntidadSoporte... innerjoin);

	protected abstract void setFiltroEntidad(T filtro, Date finit, Date ffin, EntidadSoporte... innerjoin);

	protected abstract void setFiltroEntidad(T objEntidad, Integer[] ids, EntidadSoporte... innerjoin);

}
