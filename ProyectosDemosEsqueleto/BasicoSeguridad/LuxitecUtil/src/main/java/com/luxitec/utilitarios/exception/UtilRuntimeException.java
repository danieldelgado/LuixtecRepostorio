package com.luxitec.utilitarios.exception;

@SuppressWarnings("serial")
public class UtilRuntimeException extends RuntimeException {

	public UtilRuntimeException(String exc) {
		super(exc);
	}

	public UtilRuntimeException(Throwable throwable) {
		super(throwable);
	}

	public UtilRuntimeException(String exc, Throwable throwable) {
		super(exc, throwable);
	}
}
