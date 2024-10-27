package com.spacetravel.service;

import com.spacetravel.entities.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {

    private final Session session;

    public PlanetCrudService(Session session) {
        this.session = session;
    }

    public void createPlanet(Planet planet) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Planet getPlanetById(String id) {
        return session.get(Planet.class, id);
    }

    public List<Planet> getAllPlanets() {
        return session.createQuery("from Planet", Planet.class).list();
    }

    public void updatePlanet(Planet planet) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletePlanet(Planet planet) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
