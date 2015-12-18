package com.luxitec.cliente.sistema.core;

import org.springframework.stereotype.Component;

import com.luxitec.utilitarios.validate.ValidateUtil;


/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {
	
	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		
		
		System.out.println(ValidateUtil.esCorreo("daniel@hotmail.com"));
		
		return "Hello world!";	
	}

}
