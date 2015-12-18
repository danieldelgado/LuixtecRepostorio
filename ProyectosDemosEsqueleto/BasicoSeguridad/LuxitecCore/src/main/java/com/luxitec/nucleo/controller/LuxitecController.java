package com.luxitec.nucleo.controller;

import com.luxitec.utilitarios.config.Config;


public abstract class LuxitecController {

	public static String RUTA_PUBLICA=Config.getPropiedad("luxitec.proyecto.ruta.publico");
	
	public static String RUTA_PRIVADA=Config.getPropiedad("luxitec.proyecto.ruta.privada");
	public static String RUTA_PRIVADA_ADMINISTRATIVO=Config.getPropiedad("luxitec.proyecto.ruta.privada.administrativo");
	public static String RUTA_PRIVADA_MANTENIMIENTO=Config.getPropiedad("luxitec.proyecto.ruta.privada.mantenimiento");
		
	public LuxitecController(){
		
	}
	
}
