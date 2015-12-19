package com.luxitec.cliente.sistema.service;

import org.springframework.stereotype.Component;

import com.luxitec.utilitarios.validate.ValidateUtil;


/**
 * {@link Service} with hard-coded input data.
 */
@Component("Service")
public class ExampleService implements Service {
	
	/**
	 * Reads next record from input
	 */
	public String getMessage() {

		System.out.println(ValidateUtil.esCorreo("daniel@hotmail.com"));
		
		
		return "Hello world!";	
	}

}
