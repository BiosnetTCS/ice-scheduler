package com.biosnettcs.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biosnettcs.service.impl.EventoManager;

@Component("eventoBean")
public class EventoBean {
	
	private static final Logger logger = LoggerFactory.getLogger(EventoBean.class);
	
	@Autowired
	private EventoManager eventoManager;
	
	public void printAnotherMessage(){
		try {
			logger.info("I am called by Quartz jobBean using CronTriggerFactoryBean");
			eventoManager.escalar();
		} catch (Exception e) {
			logger.error("Error al escalar el evento", e);
		}
	}
	
	public void printAnotherMessage2(){
		logger.info("Otro metodo...");
	}
	
}