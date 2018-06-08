package edu.webapp.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author 
 * @version 1.0
 */
public class InitApplicationListener implements ServletContextListener {
	
	Logger logger = Logger.getLogger(InitApplicationListener.class);

	public void contextInitialized(ServletContextEvent sce) {
		logger.log(Level.INFO, "Context Initialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		logger.log(Level.INFO, "Context Destroyed");
	}
}
