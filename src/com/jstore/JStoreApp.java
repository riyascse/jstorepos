/*
 * JStoreApp.java
 */

package com.jstore;

import java.util.EventObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.ejb.HibernatePersistence;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class JStoreApp extends SingleFrameApplication {

    HibernatePersistence hbp = new HibernatePersistence();
    EntityManagerFactory emf = hbp.createEntityManagerFactory("PeluSpaHibernate", null);
    private EntityManager em = emf.createEntityManager();


    public EntityManager getEntityManager(){
        return em;
    }
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new JStoreView(this));
    }

    @Override
    public void exit(EventObject event) {
        super.exit(event);
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of JStoreApp
     */
    public static JStoreApp getApplication() {
        return Application.getInstance(JStoreApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(JStoreApp.class, args);
    }
}
