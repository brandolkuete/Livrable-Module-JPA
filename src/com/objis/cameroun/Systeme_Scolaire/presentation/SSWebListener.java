package com.objis.cameroun.Systeme_Scolaire.presentation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SSWebListener
 *
 */
@WebListener
public class SSWebListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SSWebListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent e)  { 
    	 EntityManagerFactory emf = (EntityManagerFactory)e.getServletContext().getAttribute("emf");
    	 emf.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent e)  { 
    	EntityManagerFactory emf= Persistence.createEntityManagerFactory("ssjpaweb-pu");
    	e.getServletContext().setAttribute("emf", emf);
    }
	
}
