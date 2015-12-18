package com.luxitec.utilitarios.config;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.luxitec.utilitarios.validate.ValidateUtil;

/**
 * @author Danielle Delgado
 * 
 */
public final class FileUtil {

	private FileUtil() {
	}

	/**
	 * Metodo que verifica si un determinado directorio existe.
	 * 
	 * @param rutaDirectorio
	 *            Ruta a validar
	 * @return true en caso de que el directorio exista, false en caso contrario
	 */
	public static boolean existeDirectorio(String rutaDirectorio) {
		boolean existe = false;
		File directorioAnalizar = new File(rutaDirectorio);
		if (directorioAnalizar.exists()) {
			existe = true;
		}
		return existe;
	}

	/**
	 * Metodo utilizado para crear un archivo plano
	 * 
	 * @param texto
	 *            El texto a escribir
	 * @param ruta
	 *            La ruta del archivo que se desea crear, tiene que ser la ruta
	 *            completa con el nombre del archivo
	 * @throws Exception
	 */
	public static void crearArchivo(String texto, String ruta)
			throws IOException {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);
			pw.println(texto);
		} finally {
			if (null != fichero) {
				fichero.close();
			}
		}
	}

	/**
	 * Metodo utilizado para copiar un archivo a otra carpeta
	 * 
	 * @param rutaOrigen
	 *            Ruta del archivo que se desea compiar, tiene que ser la ruta
	 *            completa con el nombre del archivo a copiar
	 * @param rutaDestino
	 *            Ruta del archivo a copiar, tiene que ser la ruta completa con
	 *            el el nombre del archivo a copiar
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static void copiarArchivo(String rutaOrigen, String rutaDestino)
			throws IOException {
		File origen = new File(rutaOrigen);
		FileChannel in = (new FileInputStream(origen)).getChannel();
		FileChannel out = (new FileOutputStream(new File(rutaDestino)))
				.getChannel();
		in.transferTo(0, origen.length(), out);
		in.close();
		out.close();
	}

	/**
	 * 
	 * Metodo encargado de extraer los nombres de los directorios encontrados en
	 * la ruta proporcionada.
	 * 
	 * @param rutaBaseDirectorio
	 *            Ruta base desde la que leera los nombres de los directorios.
	 * @return Retorna una lista con los nombres de todos los directorios
	 *         encontrados según la ruta rutaDirectorio proporcionada.
	 */
	public static List<String> obtenerNombreDirectorios(
			String rutaBaseDirectorio) {
		List<String> directoriesName = null;

		File baseDir = new File(rutaBaseDirectorio);
		File[] files = baseDir.listFiles();

		for (int i = 0; i < files.length; i++) {
			if (directoriesName == null) {
				directoriesName = new ArrayList<String>();
			}
			if (files[i].isDirectory()) {
				directoriesName.add(files[i].getName());
			}
		}
		return directoriesName;
	}

	/**
	 * Metodo que retorna un arreglo de directorios y archivos.
	 * 
	 * @param rutaBaseDirectorio
	 *            Ruta de la cual se obtendrá la lista de directorios y archivos
	 * @return arreglo de directorios y archivos
	 */
	public static File[] obtenerArchivosDirectorios(String rutaBaseDirectorio) {
		File baseDir = new File(rutaBaseDirectorio);
		return baseDir.listFiles();
	}

	/**
	 * Crear un directorio según la ruta proporcionada.
	 * 
	 * @param rutaCompletaDirectorio
	 *            Ruta completa en la que se creará el directorio
	 * @return el resultado de la operación.
	 */
	public static boolean crearDirectorio(String rutaCompletaDirectorio) {
		return (new File(rutaCompletaDirectorio)).mkdir();
	}

	/**
	 * Metodo que sirve para obtener la extension de un archivo
	 * 
	 * @param ruta
	 *            Ruta completa del archivo para obtener su extension
	 * @return
	 */
	public static String obtenerExtensionArchivo(String ruta) {
		int dotPos = ruta.lastIndexOf(".");
		String extension = null;
		if (dotPos > 0) {
			extension = ruta.substring(dotPos + 1);
		}
		return extension;
	}

	public static File enFile(String nombreArchivo, byte[] arreglo)
			throws FileNotFoundException, IOException {
		if (ValidateUtil.isNotNull(nombreArchivo) && ValidateUtil.isNotNull(arreglo)) {
			File archivo = new File(nombreArchivo);
			OutputStream flujoSalida;
			flujoSalida = new FileOutputStream(archivo);
			flujoSalida.write(arreglo);
			flujoSalida.close();
			return archivo;
		}
		return null;
	}

	public static byte[] enArregloByte(File archivo)
			throws FileNotFoundException, IOException {
		if (archivo != null) {
			InputStream flujoEntrada = new FileInputStream(archivo);
			int longitud = (int) archivo.length();
			byte[] arregloEntrada = new byte[longitud];
			flujoEntrada.read(arregloEntrada, 0, longitud);
			flujoEntrada.close();
			return arregloEntrada;
		}
		return null;
	}

	public static BufferedImage loadImage(String rutaImagen) throws IOException {
		BufferedImage bimg = null;
		bimg = ImageIO.read(new File(rutaImagen));
		return bimg;
	}

	public static byte[] guardarImagen(byte[] fileBytes, String filename,
			String repositorio) throws IOException {
		filename = new File(filename).getName();
		filename = repositorio + filename;
		FileOutputStream fileOut = new FileOutputStream(filename);
		fileOut.write(fileBytes, 0, fileBytes.length);
		fileOut.flush();
		fileOut.close();
		return fileBytes;
	}

	public static String obtenerNombreDeFile(String filename) {
		return filename = new File(filename).getName();
	}

}
