package com.luxitec.nucleo.parse;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EscaneoClass {

	private static final Logger logger = LoggerFactory.getLogger(EscaneoClass.class);

	private Class<?> clazz,superClass;
	private String strNombre;
	private Map<String, InstanciaAtributo> parseMap;
	private List<Field> listaCampos;

	public void examinar() {
		setStrNombre(clazz.getSimpleName());
		logger.debug("Examinando : " + strNombre);
		parseMap = new LinkedHashMap<String, InstanciaAtributo>();
		Field[] campos = clazz.getDeclaredFields(),superCampos=superClass.getDeclaredFields();
		Method metodo = null;
		InstanciaAtributo parseAtributo;
		listaCampos = new ArrayList<Field>();
		try {
			for (Field field : campos) {
				parseAtributo = new InstanciaAtributo();
				parseAtributo.setField(field);
				metodo = clazz.getMethod("set" + primeraMayus(field.getName()), field.getType());
				parseAtributo.setMetodoSet(metodo);
				metodo = clazz.getMethod("get" + primeraMayus(field.getName()), null);
				parseAtributo.setMetodoGet(metodo);
				listaCampos.add(field);
				parseMap.put(field.getName(), parseAtributo);
			}
			for (Field field : superCampos) {
				parseAtributo = new InstanciaAtributo();
				parseAtributo.setField(field);
				metodo = clazz.getMethod("set" + primeraMayus(field.getName()), field.getType());
				parseAtributo.setMetodoSet(metodo);
				metodo = clazz.getMethod("get" + primeraMayus(field.getName()), null);
				parseAtributo.setMetodoGet(metodo);
				listaCampos.add(field);
				parseMap.put(field.getName(), parseAtributo);
			}						
			logger.debug("Campos escaneados : " + parseMap.keySet());
		} catch (SecurityException e) {
			logger.error("Error de seguridad en el escaneo", e);
		} catch (NoSuchMethodException e) {
			logger.error("No se encuentra el metodo en el escaneo", e);
		}
	}

	public static String primeraMayus(String str) {
		str = (str.charAt(0) + "").toUpperCase() + str.substring(1);
		return str;
	}

	public void addClase(Class<?> clazz) {
		this.setClazz(clazz);
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}

	public Map<String, InstanciaAtributo> getParseMap() {
		return parseMap;
	}

	public void setParseMap(Map<String, InstanciaAtributo> parseMap) {
		this.parseMap = parseMap;
	}

	public List<Field> getListaCampos() {
		return listaCampos;
	}

	public void setListaCampos(List<Field> listaCampos) {
		this.listaCampos = listaCampos;
	}

	public Class<?> getSuperClass() {
		return superClass;
	}

	public void setSuperClass(Class superClass) {
		this.superClass = superClass;
	}

	

	
}
