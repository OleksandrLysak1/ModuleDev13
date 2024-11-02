package com.spacetravel.service;

import com.spacetravel.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.regex.Pattern;

public class PlanetCrudService {

    private static final Pattern ID_PATTERN = Pattern.compile("^[A-Z0-9]+$");
    private final Session session;

    public PlanetCrudService(Session session) {
        this.session = session;
    }

    private boolean isValidId(String id) {
        return ID_PATTERN.matcher(id).matches();
    }

    public void createPlanet(Planet planet) {
        if (!isValidId(planet.getId())) {
            throw new IllegalArgumentException("ID планети повинен складатися лише з великих літер і цифр.");
        }

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
        if (!isValidId(planet.getId())) {
            throw new IllegalArgumentException("ID планети повинен складатися лише з великих літер і цифр.");
        }

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
