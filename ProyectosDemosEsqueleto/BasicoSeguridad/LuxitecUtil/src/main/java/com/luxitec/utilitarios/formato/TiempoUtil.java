package com.luxitec.utilitarios.formato;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.luxitec.utilitarios.constantes.ConstantesUtil;
import com.luxitec.utilitarios.validate.ValidateUtil;

/**
 * @author Danielle Delgado
 *
 */
public class TiempoUtil {

	private static final String MES_ENERO = "enero";
	private static final String MES_FEBRERO = "febrero";
	private static final String MES_MARZO = "marzo";
	private static final String MES_abril = "abril";
	private static final String MES_MAYO = "mayo";
	private static final String MES_JUNIO = "junio";
	private static final String MES_JULIO = "julio";
	private static final String MES_AGOSTO = "agosto";
	private static final String MES_SEPTIEMBRE = "septiembre";
	private static final String MES_OCTUBRE = "octubre";
	private static final String MES_NOVIEMBRE = "noviembre";
	private static final String MES_DICIEMBRE = "diciembre";

	public static boolean isFechaValida(Date fecha) {
		return fecha != null;
	}

	public static Date agregarDiaMesAno(Date fecha, short dias, short meses,
			short anos) {
		return agregarDiaMesAno(fecha, new Integer(dias), new Integer(meses),
				new Integer(anos));
	}

	public static Date agregarDiaMesAno(Date fecha, Integer dias,
			Integer meses, Integer anos) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		if (ValidateUtil.isValPositivo(dias))
			calendario.add(Calendar.DAY_OF_MONTH, dias);
		if (ValidateUtil.isValPositivo(meses))
			calendario.add(Calendar.MONTH, meses);
		if (ValidateUtil.isValPositivo(anos))
			calendario.add(Calendar.YEAR, anos);
		return calendario.getTime();
	}

	public static Timestamp enTimestamp(Date fecha) {
		if (fecha != null)
			return new Timestamp(fecha.getTime());
		return null;
	}

	public static Integer getAnoActual() {
		return (new GregorianCalendar()).get(Calendar.YEAR);
	}

	public static Integer getMesActual() {
		return (new GregorianCalendar()).get(Calendar.MONTH)
				+ ConstantesUtil.NUMBER_1;
	}

	public static Integer getDiaActual() {
		return (new GregorianCalendar()).get(Calendar.DAY_OF_MONTH);
	}

	public static String getNombreMesActual() {
		String mes = ConstantesUtil.VACIO;
		switch (getMesActual()) {
			case ConstantesUtil.NUMBER_1: {
				mes = MES_ENERO;
				break;
			}
			case ConstantesUtil.NUMBER_2: {
				mes = MES_FEBRERO;
				break;
			}
			case ConstantesUtil.NUMBER_3: {
				mes = MES_MARZO;
				break;
			}
			case ConstantesUtil.NUMBER_4: {
				mes = MES_abril;
				break;
			}
			case ConstantesUtil.NUMBER_5: {
				mes = MES_MAYO;
				break;
			}
			case ConstantesUtil.NUMBER_6: {
				mes = MES_JUNIO;
				break;
			}
			case ConstantesUtil.NUMBER_7: {
				mes = MES_JULIO;
				break;
			}
			case ConstantesUtil.NUMBER_8: {
				mes = MES_AGOSTO;
				break;
			}
			case ConstantesUtil.NUMBER_9: {
				mes = MES_SEPTIEMBRE;
				break;
			}
			case ConstantesUtil.NUMBER_10: {
				mes = MES_OCTUBRE;
				break;
			}
			case ConstantesUtil.NUMBER_11: {
				mes = MES_NOVIEMBRE;
				break;
			}
			case ConstantesUtil.NUMBER_12: {
				mes = MES_DICIEMBRE;
				break;
			}
		}
		return mes;
	}

	public static Integer getAno(Date fecha) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		return calendario.get(Calendar.YEAR);
	}

	public static Integer getMes(Date fecha) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		return calendario.get(Calendar.MONTH) + ConstantesUtil.NUMBER_1;
	}

	public static Integer getDia(Date fecha) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		return calendario.get(Calendar.DAY_OF_MONTH);
	}

	public static Timestamp getTiempoActualEnTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static Date getTiempoActualEnDate() {
		return Calendar.getInstance().getTime();
	}

	public static String getFechaLargaEnTexto(Date fecha) {
		if (fecha != null)
			return DateFormat.getDateInstance(DateFormat.FULL).format(fecha);
		return ConstantesUtil.VACIO;
	}

	public static String getFechaCortaEnTexto(Date fecha) {
		if (fecha != null)
			return DateFormat.getDateInstance(DateFormat.SHORT).format(fecha);
		return ConstantesUtil.VACIO;
	}

	public static String getFechaCortaEnTextoActual() {
		return getFechaCortaEnTexto(getTiempoActualEnDate());
	}

	public static String getFechaActualConPatron(String patron) {
		if (patron != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			return formato.format(getTiempoActualEnDate());
		}
		return null;
	}

	public static Date getFechaActualEnDateConPatron(String patron)
			throws ParseException {
		if (patron != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			return formato.parse(getTiempoActualEnDate().toString());
		}
		return null;
	}

	public static Integer getAnosTranscurridos(Date fecha) {
		if (fecha != null) {
			Calendar calendarioFecha = Calendar.getInstance();
			Calendar calendarioActual = Calendar.getInstance();
			calendarioFecha.setTime(fecha);
			return calendarioActual.get(Calendar.YEAR)
					- calendarioFecha.get(Calendar.YEAR);
		}
		return null;
	}

	public static Integer getDiasTranscurridos(Date fecha) {
		if (fecha != null) {
			return getTiempoActualEnDate().compareTo(fecha);
		}
		return null;
	}

	public static Integer getMinutosTranscurridos(Date fecha) {
		if (fecha != null) {
			Calendar calendarioFecha = Calendar.getInstance();
			Calendar calendarioActual = Calendar.getInstance();
			calendarioFecha.setTime(fecha);
			return calendarioActual.get(Calendar.MINUTE)
					- calendarioFecha.get(Calendar.MINUTE);
		}
		return null;
	}

	public static Integer getAnosTranscurridosDesdeNacimiento(
			Date fechaNacimiento) {
		Integer anosTranscurridos = new Integer(ConstantesUtil.NUMBER_0);
		if (fechaNacimiento != null) {
			anosTranscurridos = getAnosTranscurridos(fechaNacimiento);
			if ((getMesActual() - getMes(fechaNacimiento)) < ConstantesUtil.NUMBER_0) {
				anosTranscurridos = anosTranscurridos - ConstantesUtil.NUMBER_1;
			} else if ((getMesActual() - getMes(fechaNacimiento)) == ConstantesUtil.NUMBER_0) {
				if ((getDiaActual() - getDia(fechaNacimiento)) < ConstantesUtil.NUMBER_0) {
					anosTranscurridos = anosTranscurridos - ConstantesUtil.NUMBER_1;
				}
			}
		}
		return anosTranscurridos;
	}

	public static Date getFechaStringDate(String fecha) throws ParseException {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat(
					DateFormatEnumUtil.FECHA_DD_MM_YYYY.value());
			return formato.parse(fecha);
		}
		return null;
	}

	public static Date getFechaStringDateAMD(String fecha)
			throws ParseException {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat(
					DateFormatEnumUtil.FECHA_YYYYMMDD.value());
			return formato.parse(fecha);
		}
		return null;
	}

	public static Date getFechaStringDateSlash(String fecha)
			throws ParseException {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat(
					DateFormatEnumUtil.FECHA_DDMMYYYY.value());
			return formato.parse(fecha);
		}
		return null;
	}

	public static Date getFechaStringDateSlashSQL(String fecha)
			throws ParseException {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat(
					DateFormatEnumUtil.FECHA_MMDDYYYY.value());
			return formato.parse(fecha);
		}
		return null;
	}

	public static Date getFechaStringDateSlashSQL(String fecha, String patron)
			throws ParseException {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			return formato.parse(fecha);
		}
		return null;
	}

	public static String getFechaActualConPatronyDate(String patron, Date fecha) {
		if (patron != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			return formato.format(fecha);
		}
		return null;
	}

}
