package com.luxitec.nucleo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Danielle Delgado
 * 
 */
@MappedSuperclass
public abstract class CoreEntidad implements IEntidad {

//	@Column(name = "CODIGO_RELACIONAL", nullable = false, length = 10, unique = true, insertable = true, updatable = false, columnDefinition = "Codigo para buscar la entidad")
	@Column(name = "CODIGO_RELACIONAL", nullable = false, length = 10, unique = true, insertable = true, updatable = false)
	private String codigoRelacional;

//	@Column(name = "ACTIVO", nullable = false, insertable = true, updatable = true, columnDefinition = "Estado activo de la entidad")
	@Column(name = "ACTIVO", nullable = false, insertable = true, updatable = true)
	private Boolean activo;

//	@Column(name = "CODIGO_USUARIO", nullable = false, length = 10, insertable = true, updatable = false, columnDefinition = "Usuario(codigo_relacional) que registra la entidad")
	@Column(name = "CODIGO_USUARIO", nullable = false, length = 10, insertable = true, updatable = false)
	private String codigoUsuario;

	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "FECHA_REGISTRO", nullable = false, insertable = true, updatable = false, columnDefinition = "Fecha de registro de la entidad")
	@Column(name = "FECHA_REGISTRO", nullable = false, insertable = true, updatable = false)
	private Date fechaRegistro;

//	@Column(name = "CODIGO_USUARIO_MODIF", nullable = false, length = 10, insertable = true, updatable = true, columnDefinition = "Usuario(codigo_relacional) que modifica la entidad")
	@Column(name = "CODIGO_USUARIO_MODIF", nullable = false, length = 10, insertable = true, updatable = true)
	private String codigoUsuarioActulizar;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_ACTUALIZACION", nullable = false, insertable = true, updatable = true)
//	@Column(name = "FECHA_ACTUALIZACION", nullable = false, insertable = true, updatable = true, columnDefinition = "Fecha de actualizacion de la entidad")
	private Date fechaActualizada;

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCodigoUsuarioActulizar() {
		return codigoUsuarioActulizar;
	}

	public void setCodigoUsuarioActulizar(String codigoUsuarioActulizar) {
		this.codigoUsuarioActulizar = codigoUsuarioActulizar;
	}

	public Date getFechaActualizada() {
		return fechaActualizada;
	}

	public void setFechaActualizada(Date fechaActualizada) {
		this.fechaActualizada = fechaActualizada;
	}

	public String getCodigoRelacional() {
		return codigoRelacional;
	}

	public void setCodigoRelacional(String codigoRelacional) {
		this.codigoRelacional = codigoRelacional;
	}


}