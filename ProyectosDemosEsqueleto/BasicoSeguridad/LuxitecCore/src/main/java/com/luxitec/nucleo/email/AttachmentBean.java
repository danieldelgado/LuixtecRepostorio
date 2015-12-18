package com.luxitec.nucleo.email;

import java.io.File;
/**
 * @author Danielle Delgado
 *
 */
public class AttachmentBean {

	private File archivo;
	private String nombreDelArchivo;
	private String claveDelHeader;
	
	public AttachmentBean(File archivo) {
		this.archivo = archivo;
		this.nombreDelArchivo = null;
		this.claveDelHeader = null;
	}
	public AttachmentBean(File archivo, String nombreDelArchivo) {
		this.archivo = archivo;
		this.nombreDelArchivo = nombreDelArchivo;
		this.claveDelHeader =  null;
	}
	
	public AttachmentBean(File archivo, String nombreDelArchivo, String claveDelHeader) {
		this.archivo = archivo;
		this.nombreDelArchivo = nombreDelArchivo;
		this.claveDelHeader = claveDelHeader;
	}
	public File getArchivo() {
		return archivo;
	}
	
	public String getNombreDelArchivo() {
		return nombreDelArchivo;
	}
	
	public String getClaveDelHeader() {
		return claveDelHeader;
	}
	
	
}
