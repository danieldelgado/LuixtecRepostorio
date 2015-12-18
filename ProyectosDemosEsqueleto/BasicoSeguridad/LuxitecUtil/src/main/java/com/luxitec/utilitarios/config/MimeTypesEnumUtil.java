package com.luxitec.utilitarios.config;
/**
 * @author Danielle Delgado
 *
 */
public enum MimeTypesEnumUtil {

	DOC("application/msword"),
	PDF("application/pdf"),
	RSS("application/rss+xml"),
	XLS("application/vnd.ms-excel"),
	PPS_PPT("application/vnd.ms-powerpoint"),
	ODP("application/vnd.oasis.opendocument.presentation"),
	ODS("application/vnd.oasis.opendocument.spreadsheet"),
	ODT("application/vnd.oasis.opendocument.text"),
	SXC("application/vnd.sun.xml.calc"),
	SXW("application/vnd.sun.xml.writer"),
	AU_SND("audio/basic"),
	FLAC("audio/flac"),
	MID_RMI("audio/mid"),
	M4A("audio/mp4"),
	MP3("audio/mpeg"),
	OGA_OGG("audio/ogg"),
	AIF_AIFC_AIFF("audio/x-aiff"),
	WAV("audio/x-wav"),
	GIF("image/gif"),
	JPEG_JPG_JPE("image/jpeg"),
	PNG("image/png"),
	TIFF_TIF("image/tiff"),
	WBMP("image/vnd.wap.wbmp"),
	BMP("image/x-ms-bmp"),
	ICS("text/calendar"),
	CSV("text/comma-separated-values"),
	CSS("text/css"),
	HTM_HTML("text/html"),
	TEXT_TXT_ASC_DIFF_POT("text/plain"),
	VCF("text/x-vcard"),
	MP4("video/mp4"),
	MPEG_MPG_MPE("video/mpeg"),
	OGV("video/ogg"),
	QT_MOV("video/quicktime"),
	AVI("video/x-msvideo");

	private String valor;
	
	MimeTypesEnumUtil(String valor) {
		this.valor = valor;
	}
	
	public String value(){
		return valor;
	}
}
