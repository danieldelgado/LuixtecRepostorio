package com.luxitec.nucleo.parse;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InstanciaAtributo {
	private Field field;
	private Method metodoSet, metodoGet;

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Method getMetodoSet() {
		return metodoSet;
	}

	public void setMetodoSet(Method metodoSet) {
		this.metodoSet = metodoSet;
	}

	public Method getMetodoGet() {
		return metodoGet;
	}

	public void setMetodoGet(Method metodoGet) {
		this.metodoGet = metodoGet;
	}
}
