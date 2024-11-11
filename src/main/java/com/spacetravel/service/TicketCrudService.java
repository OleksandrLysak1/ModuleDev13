package com.spacetravel.service;

import com.spacetravel.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {

    private final Session session;

    public TicketCrudService(Session session) {
        this.session = session;
    }

    public void createTicket(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Клієнт та планети не можуть бути null.");
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Ticket getTicketById(Long id) {
        return session.get(Ticket.class, id);
    }

    public List<Ticket> getAllTickets() {
        return session.createQuery("from Ticket", Ticket.class).list();
    }

    public void updateTicket(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Клієнт та планети не можуть бути null.");
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTicket(Ticket ticket) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
