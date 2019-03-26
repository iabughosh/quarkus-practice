package org.ibra.quickstart;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class ApplicationListener {

	private static Logger LOG = LoggerFactory.getLogger(ApplicationListener.class);
	
	public void onStartUp(@Observes StartupEvent se) {
		LOG.info("Application has started");
	}
	
	public void onShutDown(@Observes ShutdownEvent se) {
		LOG.info("Application is being stopped");
	}
}
