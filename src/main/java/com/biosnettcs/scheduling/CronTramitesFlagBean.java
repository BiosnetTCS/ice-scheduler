package com.biosnettcs.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.biosnettcs.core.HttpUtil;

@Component("cronTramitesFlagBean")
public class CronTramitesFlagBean {
	
	private static final Logger logger = LoggerFactory.getLogger(CronTramitesFlagBean.class);
	
	@Value("${servicios.cron.tramites.flags1.url}")
	private String urlServicioTramitesFlags1;
	
	@Value("${servicios.cron.tramites.flags2.url}")
	private String urlServicioTramitesFlags2;
	
	@Value("${servicios.cron.tramites.flags3.url}")
    private String urlServicioTramitesFlags3;
	
	public void invocaServicioTramitesFlag(){
		try {
			logger.info("Inicio de invocacion al servicio de tramites flag");
			
			HttpUtil.sendPost(urlServicioTramitesFlags1, "");
			
			HttpUtil.sendPost(urlServicioTramitesFlags2, "");
			
			HttpUtil.sendPost(urlServicioTramitesFlags3, "");
			
		} catch (Exception e) {
			logger.error("Error en el servicio de tramites flag", e);
		}
	}
	
	/*
	public void printAnotherMessage2(){
		logger.info("Otro metodo...");
	}
	*/
	
}