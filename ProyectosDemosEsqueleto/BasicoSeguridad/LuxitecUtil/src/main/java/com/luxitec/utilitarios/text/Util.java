package com.luxitec.utilitarios.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.luxitec.utilitarios.constantes.ConstantesUtil;
import com.luxitec.utilitarios.validate.ValidateUtil;

@SuppressWarnings("rawtypes")
public class Util {
	
	private static String acentosOriginal = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	private static String acentosAscii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	private static Random r = new Random();
	private static Gson gson = new Gson();

	public static String sacarAcentos(String input) {
		String output = input;
		for (int i = 0; i < acentosOriginal.length(); i++) {
			output = output.replace(acentosOriginal.charAt(i), acentosAscii.charAt(i));
		}
		return output;
	}

	public static int random() {
		return r.nextInt();
	}

	public static int random(int limit) {
		return r.nextInt(limit);
	}

	@SuppressWarnings("unchecked")
	public static String getJson(Object... ob) {
		List l = new ArrayList();
		for (int i = 0; i < ob.length; i++) {
			Object o = ob[i];
			l.add(o);
		}
		return gson.toJson(l);
	}

	public static void quitarUltimoAND(StringBuffer strbfSqlQuery, String sql_and) {
		String str = strbfSqlQuery.toString();
		int index = str.lastIndexOf(sql_and);
		if (index > 0) {
			strbfSqlQuery.delete(0, str.length());
			strbfSqlQuery.append(str.subSequence(0, index));
			str = null;
		}
	}
	

	public static String capitalizarPrimerasMayuscula(String texto) {
		if (ValidateUtil.isNotNull(texto)) {
			texto = ConstantesUtil.SPACE + texto.toLowerCase();
			StringBuilder flujo = new StringBuilder(texto);
			for (int i = 1; i < texto.length(); i++) {
				if (texto.charAt(i - 1) == ' ')
					flujo.setCharAt(i, Character.toUpperCase(texto.charAt(i)));
			}
			texto = flujo.toString();
			texto = texto.substring(1, texto.length());
		}
		return texto;
	}

	public static String mitadDerecha(String texto) {
		return texto.substring(texto.length() / ConstantesUtil.NUMBER_2, texto.length());
	}

	public static String mitadIzquierda(String texto) {
		return texto.substring(0, texto.length() / ConstantesUtil.NUMBER_2);
	}

	public static String extraerIdDepartamentoProvincia(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_6)
				return idUbigeo.substring(ConstantesUtil.NUMBER_0, ConstantesUtil.NUMBER_4);
		}
		return null;
	}

	public static String extraerIdDepartamento(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_5)
				return idUbigeo.substring(ConstantesUtil.NUMBER_3, ConstantesUtil.NUMBER_5);
		}
		return null;
	}

	public static String extraerIdDepartamentoUbigeo(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_9)
				return idUbigeo.substring(ConstantesUtil.NUMBER_0, ConstantesUtil.NUMBER_5);
		}
		return null;
	}

	public static String extraerIdProvincia(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_7)
				return idUbigeo.substring(ConstantesUtil.NUMBER_5, ConstantesUtil.NUMBER_7);
		}
		return null;
	}

	public static String extraerIdProvinciaUbigeo(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_9)
				return idUbigeo.substring(ConstantesUtil.NUMBER_0, ConstantesUtil.NUMBER_7);
		}
		return null;
	}

	public static String extraerIdDistrito(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_9)
				return idUbigeo.substring(ConstantesUtil.NUMBER_7, ConstantesUtil.NUMBER_9);
		}
		return null;
	}

	public static String extraerIdDistritoUbigeo(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_9)
				return idUbigeo.substring(ConstantesUtil.NUMBER_0, ConstantesUtil.NUMBER_9);
		}
		return null;
	}

	public static boolean contiene(String[] arreglo, String texto) {
		boolean encontrado = false;
		if (arreglo != null && texto != null) {
			for (int i = ConstantesUtil.NUMBER_0; i < arreglo.length && !encontrado; i++)
				encontrado = arreglo[i].equals(texto);
		}
		return encontrado;
	}

	public static String eliminarEspacioBlanco(String texto) {
		if (texto != null)
			return texto.replace( ConstantesUtil.VACIO, ConstantesUtil.VACIO);
		return texto;
	}

	public static String eliminarCaracter(String texto, String caracter) {
		if (texto != null)
			return texto.replace(caracter,  ConstantesUtil.VACIO);
		return texto;
	}

	public static String completarIzquierda(String textoBase,
			String textoComplementario, Integer longitud) {
		while (textoBase.length() < longitud)
			textoBase = textoComplementario + textoBase;
		return textoBase;
	}

	public static String extraerUbigeoNoPais(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_9)
				return idUbigeo.substring(ConstantesUtil.NUMBER_3, ConstantesUtil.NUMBER_9);
		}
		return null;
	}

	public static String extraerPais(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_9)
				return idUbigeo.substring(ConstantesUtil.NUMBER_0, ConstantesUtil.NUMBER_3);
		}
		return null;
	}

	public static String incluirPaisEnUbigeo(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() == ConstantesUtil.NUMBER_6)
				return "001" + idUbigeo;
		}
		return idUbigeo;
	}

	public static String incluirPais(String idUbigeo) {
		if (ValidateUtil.isNotNull(idUbigeo)) {
			idUbigeo = idUbigeo.toUpperCase();
			if (idUbigeo.length() != ConstantesUtil.NUMBER_0)
				return "001" + idUbigeo;
		}
		return idUbigeo;
	}

	public static boolean contieneEspacioEnBlanco(String texto) {
		char esp_blanco = ' ';
		for (int i = ConstantesUtil.NUMBER_0; i < texto.length(); i++) {
			Character caracter = texto.charAt(i);
			if (caracter.equals(esp_blanco))
				return true;
		}
		return false;
	}

	public static boolean contieneCaracteresPermitidos(String[] listasEvaluar, String texto) {
		for (int i = ConstantesUtil.NUMBER_0; i < texto.length(); i++) {
			Character caracter = texto.charAt(i);
			int j = ConstantesUtil.NUMBER_0;
			for (j = ConstantesUtil.NUMBER_0; j < listasEvaluar.length; j++) {
				Character caracterPermitido = listasEvaluar[j].charAt(ConstantesUtil.NUMBER_0);
				if (caracter.compareTo(caracterPermitido)!= ConstantesUtil.NUMBER_0 )
					return true; 
			}
		}
		return false;
	}
	
	public static String generarClaveAleatoria(int tamanoCadena) {
		StringBuilder claveAleatoria = new StringBuilder();
		Random numeroAleatorio = new Random();
		for (int i = ConstantesUtil.NUMBER_0; i < tamanoCadena; i++) {
			claveAleatoria.append(numeroAleatorio.nextInt(ConstantesUtil.NUMBER_10));
		}
		return claveAleatoria.toString();
	}

	public static String extraerCorrelativoSecuencia(String secuencia) {
		if (ValidateUtil.isNotNull(secuencia)) {
			secuencia = secuencia.toUpperCase();
			if (secuencia.length() == ConstantesUtil.NUMBER_6)
				return secuencia.substring(ConstantesUtil.NUMBER_0, ConstantesUtil.NUMBER_2);
		}
		return null;
	}

	public static String Left(String text, int length) {
		return text.substring(ConstantesUtil.NUMBER_0, length);
	}

	public static String Right(String text, int length) {
		return text.substring(text.length() - length, length);
	}

	public static String Mid(String text, int start, int end) {
		return text.substring(start, end);
	}

	public static String Mid(String text, int start) {
		return text.substring(start, text.length() - start);
	}

	public static String formatearTelefonoCargas(String telefono) {
		// telefono = telefono.replaceAll(".0", "");
		telefono = telefono.replaceAll("\\.", "");
		telefono = telefono.replaceAll("E8", "");
		return telefono;
	}

}
