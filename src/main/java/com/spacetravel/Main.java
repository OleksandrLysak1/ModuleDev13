package com.spacetravel;

import com.spacetravel.entity.Client;
import com.spacetravel.entity.Planet;
import com.spacetravel.entity.Ticket;
import com.spacetravel.service.ClientCrudService;
import com.spacetravel.service.PlanetCrudService;
import com.spacetravel.service.TicketCrudService;
import com.spacetravel.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            ClientCrudService clientService = new ClientCrudService(session);
            PlanetCrudService planetService = new PlanetCrudService(session);
            TicketCrudService ticketService = new TicketCrudService(session);

            Client client1 = clientService.getClientById(1L);
            Planet planetFrom = planetService.getPlanetById("EARTH");
            Planet planetTo = planetService.getPlanetById("MARS");

            Ticket ticket = new Ticket(client1, planetFrom, planetTo);
            ticketService.createTicket(ticket);

            System.out.println("All Tickets: " + ticketService.getAllTickets());
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
