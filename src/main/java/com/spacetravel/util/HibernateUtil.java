package com.spacetravel.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {

            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Повертає об'єкт SessionFactory
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Закриває SessionFactory, коли більше не потрібен
     */
    public static void shutdown() {

        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
