package com.luxitec.nucleo.email;

/**
 * @author Danielle Delgado
 *
 */
public class MailBean {
    
    private boolean smtpAuth;
    private boolean smtpStarttlsEnable;
    private String smtpHost;
    private String smtpPort;
    private String remitente;
    private String nombreRemitente;
    private String nombreDestinatario;
    private String destinario;
    private String claveDestinatario;
    
    public MailBean() {
    }

    public MailBean(boolean smtpAuth, boolean smtpStarttlsEnable, String smtpHost, String smtpPort) {
        this.smtpAuth = smtpAuth;
        this.smtpStarttlsEnable = smtpStarttlsEnable;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    
    
    /**
     * @return the smtpAuth
     */
    public boolean getSmtpAuth() {
        return smtpAuth;
    }

    /**
     * @param smtpAuth the smtpAuth to set
     */
    public void setSmtpAuth(boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    /**
     * @return the smtpStarttlsEnable
     */
    public boolean getSmtpStarttlsEnable() {
        return smtpStarttlsEnable;
    }

    /**
     * @param smtpStarttlsEnable the smtpStarttlsEnable to set
     */
    public void setSmtpStarttlsEnable(boolean smtpStarttlsEnable) {
        this.smtpStarttlsEnable = smtpStarttlsEnable;
    }

    /**
     * @return the smtpHost
     */
    public String getSmtpHost() {
        return smtpHost;
    }

    /**
     * @param smtpHost the smtpHost to set
     */
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    /**
     * @return the smtpPort
     */
    public String getSmtpPort() {
        return smtpPort;
    }

    /**
     * @param smtpPort the smtpPort to set
     */
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    /**
     * @return the destinario
     */
    public String getDestinario() {
        return destinario;
    }

    /**
     * @param destinario the destinario to set
     */
    public void setDestinario(String destinario) {
        this.destinario = destinario;
    }

    /**
     * @return the claveDestinatario
     */
    public String getClaveDestinatario() {
        return claveDestinatario;
    }

    /**
     * @param claveDestinatario the claveDestinatario to set
     */
    public void setClaveDestinatario(String claveDestinatario) {
        this.claveDestinatario = claveDestinatario;
    }
    
    /**
     * 
     * @return
     */
    public String getNombreDestinatario() {
		return nombreDestinatario;
	}
    
    /**
     * 
     * @param nombreDestinatario
     */
    public void setNombreDestinatario(String nombreDestinatario) {
		this.nombreDestinatario = nombreDestinatario;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getNombreRemitente() {
		return nombreRemitente;
	}

	public void setNombreRemitente(String nombreRemitente) {
		this.nombreRemitente = nombreRemitente;
	}
    
    
}
