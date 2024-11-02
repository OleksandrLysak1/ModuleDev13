package com.spacetravel;

import com.spacetravel.entity.Client;
import com.spacetravel.entity.Planet;
import com.spacetravel.service.ClientCrudService;
import com.spacetravel.service.PlanetCrudService;
import com.spacetravel.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            ClientCrudService clientService = new ClientCrudService(session);
            PlanetCrudService planetService = new PlanetCrudService(session);

            Client client1 = new Client("John Doe");
            Client client2 = new Client("Jane Smith");
            clientService.createClient(client1);
            clientService.createClient(client2);

            Planet planet1 = new Planet("MARS", "Mars");
            Planet planet2 = new Planet("VEN", "Venus");
            planetService.createPlanet(planet1);
            planetService.createPlanet(planet2);

            System.out.println("All Clients: " + clientService.getAllClients());
            System.out.println("All Planets: " + planetService.getAllPlanets());

            client1.setName("John Updated");
            clientService.updateClient(client1);

            planetService.deletePlanet(planet2);

            System.out.println("All Planets after deletion: " + planetService.getAllPlanets());

        } finally {

            session.close();

            HibernateUtil.shutdown();
        }
    }
}
