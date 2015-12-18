package com.luxitec.utilitarios.exception;

@SuppressWarnings("serial")
public class ValidarException extends RuntimeException {
	
	public ValidarException(String exc) {
		super(exc);
	}

	public ValidarException(Throwable throwable) {
		super(throwable);
	}

	public ValidarException(String exc, Throwable throwable) {
		super(exc, throwable);
	}
	
}
