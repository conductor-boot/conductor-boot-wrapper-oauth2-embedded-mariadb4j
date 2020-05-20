package com.my.conductorbootwrapperoauth2embeddedmariadb4j.environment.config;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.my.conductorbootwrapperoauth2embeddedmariadb4j.conductor.runner.thread.ConductorRunnerThreadProvider;

 public class ShutdownServletContextListener implements ServletContextListener {

	@Override
    public void contextDestroyed(
        ServletContextEvent sce) {
		
	if(ConductorRunnerThreadProvider.getInstance().isAlive())
	{
        ConductorRunnerThreadProvider.getInstance().stopThread();
	}  
       System.out.println("############ RAN SHUTDOWN HOOK ##########");
   }
 }