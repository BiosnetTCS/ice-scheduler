package com.biosnettcs.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.biosnettcs.scheduling.AnotherBean;
import com.biosnettcs.scheduling.CronTramitesFlagBean;

public class ScheduledJob extends QuartzJobBean{

	
	private AnotherBean anotherBean;
	
	private CronTramitesFlagBean cronTramitesFlagBean;
	
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		anotherBean.printAnotherMessage();
		cronTramitesFlagBean.invocaServicioTramitesFlag();
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}

	public void setCronTramitesFlagBean(CronTramitesFlagBean cronTramitesFlagBean) {
		this.cronTramitesFlagBean = cronTramitesFlagBean;
	}
}
