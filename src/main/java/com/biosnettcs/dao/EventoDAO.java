package com.biosnettcs.dao;

public interface EventoDAO {

	/**
	 * Escala eventos de la aplicacion
	 * @return Mensaje de respuesta
	 * @throws Exception
	 */
	public String escalaEvento() throws Exception;
	
	
	/**
	 * Obtiene los procesos a ejecutar en background
	 * @return
	 * @throws Exception
	 */
	public String obtenerProcesosBackground() throws Exception;
	
}
