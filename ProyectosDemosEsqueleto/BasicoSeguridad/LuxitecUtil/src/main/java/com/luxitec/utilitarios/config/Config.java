package com.luxitec.utilitarios.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.luxitec.utilitarios.constantes.ConstantesSistema;
import com.luxitec.utilitarios.constantes.ConstantesUtil;
import com.luxitec.utilitarios.exception.UtilException;
import com.luxitec.utilitarios.exception.UtilRuntimeException;

/**
 * @author Danielle Delgado
 *
 */
public final class Config {

	private static Properties propiedades;

	private Config() {
		super();
	}

	public static String getPropiedad(String propiedad) {
		cargarConfiguracion();
		return propiedades.getProperty(propiedad);
	}

	public static int getPropiedadInt(String propiedad) throws UtilException {
		cargarConfiguracion();
		String prop = propiedades.getProperty(propiedad);
		int valor = 0;
		if (prop != null) {
			try {
				valor = Integer.parseInt(prop);
			} catch (NumberFormatException e) {
				throw new UtilException(e);
			}
		}
		return valor;
	}

	public static boolean getPropiedadBoolean(String propiedad) {
		return getPropiedadBoolean(propiedad, false);
	}

	public static boolean getPropiedadBoolean(String propiedad, boolean porDefecto) {
		cargarConfiguracion();
		String prop = propiedades.getProperty(propiedad);
		if (prop != null) {
			prop = prop.trim();
			if (ConstantesUtil.VALTRUE.equalsIgnoreCase(prop) || ConstantesUtil.VALYES.equalsIgnoreCase(prop) || ConstantesUtil.VALVERDAD.equalsIgnoreCase(prop)
					|| ConstantesUtil.VALSI.equalsIgnoreCase(prop)) {
				return true;
			}
		}
		return porDefecto;
	}

	private static void cargarConfiguracion() {
		cargarConfiguracion(ConstantesUtil.VACIO);
	}

	private static void cargarConfiguracion(InputStream archivo) {
		if (propiedades != null) {
			return;
		}
		if (archivo == null) {
			throw new UtilRuntimeException(ConstantesSistema.NO_CARGA_CONFIGURACION);
		}
		try {
			propiedades = new Properties();
			propiedades.load(archivo);			
		} catch (IOException ioe) {
			throw new UtilRuntimeException(ConstantesSistema.NO_CARGA_CONFIGURACION, ioe);
		}
	}

	private static void cargarConfiguracion(String archivo) {
		if (propiedades != null) {
			return;
		}
		String rutaArchivo = System.getProperty(ConstantesSistema.TNOVA_UTIL_PROPERTIES);
		try {
			InputStream is;
			if (archivo != null && !"".equals(archivo)) {
				is = new FileInputStream(archivo);
			} else if (rutaArchivo != null) {
				is = new FileInputStream(rutaArchivo);
			} else {
				is = Config.class.getResourceAsStream(ConstantesSistema.TNOVA_UTIL_PROPERTIES);
			}
			cargarConfiguracion(is);
		} catch (IOException ioe) {
			throw new UtilRuntimeException(ConstantesSistema.NO_CARGA_CONFIGURACION, ioe);
		}
	}
	
}