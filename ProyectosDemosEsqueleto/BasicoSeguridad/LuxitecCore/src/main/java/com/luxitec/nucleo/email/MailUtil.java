package com.luxitec.nucleo.email;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.luxitec.utilitarios.config.MimeTypesEnumUtil;
import com.luxitec.utilitarios.validate.ValidateUtil;


/**
 * @author Danielle Delgado
 *
 */
public final class MailUtil {

	
	private static MimeMessage message = null ;
	private static List<BodyPart> cuerpoDelMensaje = null;

	private MailUtil(){
		
	}
	
	/**
	 * Metodo utilizado para enviar un correo para una sola persona
	 * @param mail Configuracion para el envio de correos
	 * @param para Correo de la persona para enviar el correo
	 * @param asunto El asunto a colocar en el correo
	 * @param contenido El texto del correo que puede estar en formato HTML
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * @throws AddressException 
	 * @throws Exception
	 * 
	 */
	public static void enviarCorreo(MailBean mail, String para, String asunto,
			String contenido, List<AttachmentBean>... archivosAdjuntos) throws  UnsupportedEncodingException, MessagingException  {
		configurarCorreo(mail, asunto, contenido);
		establecerPara(para, null);
		establecerContenido(contenido);
		if(archivosAdjuntos.length>0){
			establecerArchivosAdjuntos(archivosAdjuntos[0]);
		}
		enviar();
	}
	
	/**
	 * Metodo utilizado para enviar un correo a varias personas 
	 * @param mail Configuracion para el envio de correos
	 * @param para Correo de la persona para enviar el correo
	 * @param asunto El asunto a colocar en el correo
	 * @param contenido El texto del correo que puede estar en formato HTML
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * @throws AddressException 
	 * @throws Exception
	 */
	public static void enviarCorreo(MailBean mail, String[] para, String asunto,
			String contenido, List<AttachmentBean>... archivosAdjuntos) throws  UnsupportedEncodingException, MessagingException  {
		configurarCorreo(mail, asunto, contenido);
		establecerPara(null, para);
		establecerContenido(contenido);
		if(archivosAdjuntos.length>0){
			establecerArchivosAdjuntos(archivosAdjuntos[0]);
		}
		enviar();
	}
	
	
	/**
	 * Metodo utilizado para enviar un correo para una sola persona
	 * @param mail Configuracion para el envio de correos
	 * @param para Correo de la persona para enviar el correo
	 * @param copia Correos de las personas para enviar el correo como copia
	 * @param esCopiaOculta Si es true envia los correos de la variable <b>copia</b> como copia oculta
	 * @param asunto El asunto a colocar en el correo
	 * @param contenido El texto del correo que puede estar en formato HTML
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 * 
	 */
	public static void enviarCorreo(MailBean mail, String para, String[] copia,
			boolean esCopiaOculta, String asunto, String contenido, List<AttachmentBean>... archivosAdjuntos) throws MessagingException, UnsupportedEncodingException{
		configurarCorreo(mail, asunto, contenido);
		establecerPara(para, null);
		establecerCopia(copia);
		establecerContenido(contenido);
		if(archivosAdjuntos.length>0){
			establecerArchivosAdjuntos(archivosAdjuntos[0]);
		}
		enviar();
	}
	
	
	/**
	 * Metodo utilizado para enviar un correo a varias personas 
	 * @param mail Configuracion para el envio de correos
	 * @param para Correo de las personas para enviar el correo
	 * @param copia Correos de las personas para enviar el correo como copia
	 * @param esCopiaOculta Si es true envia los correos de la variable <b>copia</b> como copia oculta
	 * @param asunto El asunto a colocar en el correo
	 * @param contenido El texto del correo que puede estar en formato HTML
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	public static void enviarCorreo(MailBean mail, String[] para, String[] copia,
			boolean esCopiaOculta, String asunto, String contenido, List<AttachmentBean>... archivosAdjuntos) throws  MessagingException, UnsupportedEncodingException {
		configurarCorreo(mail, asunto, contenido);
		establecerPara(null, para);
		if (esCopiaOculta) {
			establecerCopiaOculta(copia);
		} else {
			establecerCopia(copia);
		}
		establecerContenido(contenido);
		if(archivosAdjuntos.length>0){
			establecerArchivosAdjuntos(archivosAdjuntos[0]);
		}
		enviar();
	}
	
	
	/**
	 * Metodo utilizado para enviar un correo para una sola persona
	 * @param mail Configuracion para el envio de correos
	 * @param para Correo de la persona para enviar el correo
	 * @param copia Correo de las personas para enviar como copia
	 * @param copiaOculta Correo de las personar para enviar como copia oculta
	 * @param asunto El asunto a colocar en el correo
	 * @param contenido El texto del correo que puede estar en formato HTML
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * @throws AddressException 
	 * @throws Exception
	 * 
	 */
	public static void enviarCorreo(MailBean mail, String para, String[] copia,
			String[] copiaOculta, String asunto, String contenido, List<AttachmentBean>... archivosAdjuntos) throws  UnsupportedEncodingException, MessagingException {
		configurarCorreo(mail, asunto, contenido);
		establecerPara(para, null);
		establecerCopia(copia);
		establecerCopiaOculta(copiaOculta);
		establecerContenido(contenido);
		if(archivosAdjuntos.length>0){
			establecerArchivosAdjuntos(archivosAdjuntos[0]);
		}
		enviar();
	}
	
	/**
	 * Metodo utilizado para enviar un correo a varias personas 
	 * @param mail Configuracion para el envio de correos
	 * @param para Correo de la persona para enviar el correo
	 * @param copia Correo de las personas para enviar como copia
	 * @param copiaOculta Correo de las personar para enviar como copia oculta
	 * @param asunto El asunto a colocar en el correo
	 * @param contenido El texto del correo que puede estar en formato HTML
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	public static void enviarCorreo(MailBean mail, String[] para, String[] copia,
			String[] copiaOculta, String asunto, String contenido, List<AttachmentBean>... archivosAdjuntos) throws  MessagingException, UnsupportedEncodingException {
		configurarCorreo(mail, asunto, contenido);
		establecerPara(null, para);
		establecerCopia(copia);
		establecerCopiaOculta(copiaOculta);
		establecerContenido(contenido);
		if(archivosAdjuntos.length>0){
			establecerArchivosAdjuntos(archivosAdjuntos[0]);
		}
		enviar();
	}
	
	
	
	private static void configurarCorreo(MailBean mail, String asunto, String contenido) throws  MessagingException, UnsupportedEncodingException  {
		Properties props = new Properties();
		props.put("mail.smtp.auth", mail.getSmtpAuth());
		props.put("mail.smtp.starttls.enable", mail.getSmtpStarttlsEnable());
		props.put("mail.smtp.host", mail.getSmtpHost());
		props.put("mail.smtp.port", mail.getSmtpPort());
		final String username = mail.getDestinario();
		final String password = mail.getClaveDestinatario();
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
	    
		//Creando la informaci�n para el envio del correo
		message = new MimeMessage(session);
		if(ValidateUtil.isNotNull(mail.getNombreDestinatario())){
			message.setFrom(new InternetAddress(username));
		}else{
			message.setFrom(new InternetAddress(username, mail.getNombreDestinatario()));
		}
		message.setSubject(asunto);
		
			
	}
	
	private static void establecerPara(String para, String[] paraVarios) throws  MessagingException {
		if(paraVarios==null){
			// Solo envio correo a un destinatario
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(para));
		}else{
			// Se envia correo a varios destinatarios
			InternetAddress[] addressTo = new InternetAddress[paraVarios.length];
			for (int i = 0; i < paraVarios.length; i++) {
				addressTo[i] = new InternetAddress(paraVarios[i]);
			}
			message.setRecipients(Message.RecipientType.TO, addressTo);
		}
	}
	
	
	private static void establecerCopia(String[] paraVarios) throws MessagingException {
			InternetAddress[] addressTo = new InternetAddress[paraVarios.length];
			for (int i = 0; i < paraVarios.length; i++) {
				addressTo[i] = new InternetAddress(paraVarios[i]);
			}
			message.setRecipients(Message.RecipientType.CC, addressTo);
	} 
		
	private static void establecerCopiaOculta(String[] paraVarios) throws MessagingException {
			InternetAddress[] addressTo = new InternetAddress[paraVarios.length];
			for (int i = 0; i < paraVarios.length; i++) {
				addressTo[i] = new InternetAddress(paraVarios[i]);
			}
			message.setRecipients(Message.RecipientType.BCC, addressTo);
	}
	
	private static void establecerContenido(String texto) throws MessagingException {
		if(cuerpoDelMensaje==null){
			cuerpoDelMensaje = new ArrayList<BodyPart>();
		}
		BodyPart body = new MimeBodyPart();
		body.setContent(texto, MimeTypesEnumUtil.HTM_HTML.value());
		cuerpoDelMensaje.add(body);
	}
	
	private static void establecerArchivosAdjuntos(List<AttachmentBean> listaDeAdjuntos) throws MessagingException {
		for(AttachmentBean attachmentMessage : listaDeAdjuntos){
			BodyPart body = new MimeBodyPart();
			body.setDataHandler(new DataHandler(new FileDataSource(attachmentMessage.getArchivo())));
			if(attachmentMessage.getNombreDelArchivo()!=null){
				body.setFileName(attachmentMessage.getNombreDelArchivo());
			}
			//Se utiliza cuando se quiere que en el texto del correo se muestre la imagen
			if(attachmentMessage.getClaveDelHeader()!=null){
				body.setHeader("Content-ID", "<"+attachmentMessage.getClaveDelHeader()+">");
			}
			cuerpoDelMensaje.add(body);
		}
		
	}
	
	private static void enviar() throws MessagingException {
        MimeMultipart mimeMultipart = new MimeMultipart("related");
        for(BodyPart bodyPart : cuerpoDelMensaje){
        	mimeMultipart.addBodyPart(bodyPart);
        }
        message.setContent(mimeMultipart);
		Transport.send(message);
		message = null;
		cuerpoDelMensaje = null;
	}

}
