package com.luxitec.utilitarios.exception;

@SuppressWarnings("serial")
public class UtilException extends Exception {

	public UtilException(String exc) {
		super(exc);
	}

	public UtilException(Throwable throwable) {
		super(throwable);
	}

	public UtilException(String exc, Throwable throwable) {
		super(exc, throwable);
	}

}
