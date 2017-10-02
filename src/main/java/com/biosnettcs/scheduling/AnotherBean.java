package com.biosnettcs.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biosnettcs.service.impl.EventoManager;

@Component("anotherBean")
public class AnotherBean {
	
	private static final Logger logger = LoggerFactory.getLogger(AnotherBean.class);
	
	@Autowired
	private EventoManager eventoManager;
	
	public void printAnotherMessage(){
		try {
			logger.info("Iniciando Quartz jobBean usando CronTriggerFactoryBean, escalar...");
			eventoManager.escalar();
			logger.info("Finalizando Quartz jobBean usando CronTriggerFactoryBean, escalar");
		} catch (Exception e) {
			logger.error("Error en el procedimiento para escalar las tareas", e);
		}
	}
	
	public void printAnotherMessage2(){
		logger.info("Otro metodo...");
	}
	
}
