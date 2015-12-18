package com.luxitec.utilitarios.formato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Danielle Delgado
 * 
 */
public class DateUtil {

	private DateUtil() {

	}

	public static String getFechaActual(DateFormatEnumUtil formato) {
		return getFormatDate(formato.value(), new Date());
	}

	public static String getFechaActual(String formato) {
		return getFormatDate(formato, new Date());
	}

	public static String formatearFecha(DateFormatEnumUtil formato, Date fecha) {
		return getFormatDate(formato.value(), fecha);
	}

	public static String formatearFecha(String formato, Date fecha) {
		return getFormatDate(formato, fecha);
	}

	private static String getFormatDate(String formato, Date date) {
		SimpleDateFormat formateador = new SimpleDateFormat(formato);
		return formateador.format(new Date());
	}

	public static Date deStringADate(DateFormatEnumUtil formato, String fecha) throws ParseException {
		return getdeStringDate(formato.value(), fecha);
	}

	public static Date deStringADate(String formato, String fecha) throws ParseException {
		return getdeStringDate(formato, fecha);
	}

	private static Date getdeStringDate(String formato, String date) throws ParseException {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formato);
		return formatoDelTexto.parse(date);
	}

	public static Date getHoy() {
		return Calendar.getInstance().getTime();
	}

	public static String getFechaActual() {
		return formatearFecha(DateFormatEnumUtil.FECHA_DD_MM_YYYY, new Date());
	}

	public static int diasDiferencia(Date inicio, Date fin) {
		long segInicio = inicio.getTime();
		long segFin = fin.getTime();
		long diferencia = segFin - segInicio;
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		return ((int) dias);
	}

	public static int diasDiferencia(String sInicio, String sFin) throws ParseException {
		Date inicio = deStringADate(DateFormatEnumUtil.FECHA_DD_MM_YYYY, sInicio);
		Date fin = deStringADate(DateFormatEnumUtil.FECHA_DD_MM_YYYY, sFin);
		long segInicio = inicio.getTime();
		long segFin = fin.getTime();
		long diferencia = segFin - segInicio;
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		return ((int) dias);
	}

	public static String getPrimerDiaDelMes(Date d) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date dddd = calendar.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat(DateFormatEnumUtil.FECHA_DD_MM_YYYY.value());
		return sdf1.format(dddd);
	}

	public static String getUltimoDiaDelMes(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date dddd = calendar.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat(DateFormatEnumUtil.FECHA_DD_MM_YYYY.value());
		return sdf1.format(dddd);

	}

	public static Calendar deStringACalendar(DateFormatEnumUtil formato, String fecha) throws ParseException {
		Date fechaConvertir = deStringADate(formato, fecha);
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaConvertir);
		return cal;
	}

	public static Calendar deStringACalendar(String formato, String fecha) throws ParseException {
		Date fechaConvertir = deStringADate(formato, fecha);
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaConvertir);
		return cal;
	}

	public static Calendar deDateACalendar(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		return cal;
	}

}
