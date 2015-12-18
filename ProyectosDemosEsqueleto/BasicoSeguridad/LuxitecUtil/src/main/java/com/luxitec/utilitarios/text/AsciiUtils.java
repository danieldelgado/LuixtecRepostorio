package com.luxitec.utilitarios.text;

import com.luxitec.utilitarios.formato.UnicodeFormatter;


/**
 * @author Danielle Delgado
 * 
 */
public class AsciiUtils {
	/**
	 * grave acute circumflex tilde umlaut ring cedilla double acute
	 */
	private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";

	private static final String UNICODE = "\u00C0\u00E0\u00C8\u00E8\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"
			+ "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD"
			+ "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177"
			+ "\u00C3\u00E3\u00D5\u00F5\u00D1\u00F1"
			+ "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF"
			+ "\u00C5\u00E5" + "\u00C7\u00E7" + "\u0150\u0151\u0170\u0171";

	private AsciiUtils() {
	}

	/**
	 *  las letras con tildes las pone sin tildes
	 * @param s
	 * @return
	 */
	public static String quitarTildes(String s) {
		if (s == null)
			return null;
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			int pos = UNICODE.indexOf(c);
			if (pos > -1) {
				sb.append(PLAIN_ASCII.charAt(pos));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 *  las letras con tildes las pone en unicode
	 * @param s1
	 * @return
	 */
	public static String tildesAUnicode(String s1) {
		if (s1 == null)
			return null;
		StringBuilder sb = new StringBuilder();
		int n = s1.length();
		for (int i = 0; i < n; i++) {
			char c = s1.charAt(i);
			int pos = UNICODE.indexOf(c);
			if (pos > -1) {
				sb.append(UnicodeFormatter.toString(Character.toString(c)));// José
																			// =
																			// Jos\u00e9
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}