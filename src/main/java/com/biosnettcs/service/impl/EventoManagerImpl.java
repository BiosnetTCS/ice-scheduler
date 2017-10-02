package com.biosnettcs.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biosnettcs.dao.EventoDAO;

@Service
public class EventoManagerImpl implements EventoManager {

	private static final Logger logger = LoggerFactory.getLogger(EventoManager.class);
	
	@Autowired
	EventoDAO eventoDAO;
	
	@Override
	public String escalar() throws Exception {
		logger.info("Escalando evento...");
		eventoDAO.escalaEvento();
		logger.info("Finaliza Escalando evento");
		return "exito";
	}

}
