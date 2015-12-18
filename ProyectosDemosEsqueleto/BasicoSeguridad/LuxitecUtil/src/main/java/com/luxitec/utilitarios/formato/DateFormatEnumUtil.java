package com.luxitec.utilitarios.formato;

/**
 * @author Danielle Delgado
 *
 */
public enum DateFormatEnumUtil {
	//Formato para fechas
	FECHA_DD("dd"),
	FECHA_MM("MM"),
	FECHA_YYYY("yyyy"),
	FECHA_DDMMYYYY("dd/MM/yyyy"),
	FECHA_MMDDYYYY("MM/dd/yyyy"),
	FECHA_DD_MM_YYYY("dd-MM-yyyy"),
	FECHA_YYYYMMDD("yyyy-MM-dd"),
	//Formato para horas
	HORA_HH("hh"),
	HORA_MM("mm"),
	HORA_KK("kk"),
	
	HORA_HHMMSS("hh:mm:ss"),
	HORA_HHMMSS_S("hh:mm:ss:S"),
	HORA_HHMMSSA("hh:mm:ss a"),
	
	HORA_KKMMSS("kk:mm:ss"),
	HORA_KKMMSS_S("kk:mm:ss:S");
	
	private String tipo;

	DateFormatEnumUtil(String tipo) {
		this.tipo = tipo;
	}

	public String value() {
		return tipo;
	}
}
