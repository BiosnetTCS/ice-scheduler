package com.biosnettcs.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.biosnettcs.scheduling.AnotherBean;
import com.biosnettcs.scheduling.CronTramitesFlagBean;

public class ScheduledJob extends QuartzJobBean{
	
	private CronTramitesFlagBean cronTramitesFlagBean;
	
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

		cronTramitesFlagBean.invocaServicioTramitesFlag();
	}

	public void setCronTramitesFlagBean(CronTramitesFlagBean cronTramitesFlagBean) {
		this.cronTramitesFlagBean = cronTramitesFlagBean;
	}
}
