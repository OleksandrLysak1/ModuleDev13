package com.spacetravel.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Створення SessionFactory з конфігураційного файлу hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Виведення повідомлення про помилку під час ініціалізації SessionFactory
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
        // Закриття кешу та пулу з'єднань
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
