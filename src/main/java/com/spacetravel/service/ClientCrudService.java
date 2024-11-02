package com.spacetravel.service;

import com.spacetravel.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {

    private final Session session;

    public ClientCrudService(Session session) {
        this.session = session;
    }

    public void createClient(Client client) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Client getClientById(Long id) {
        return session.get(Client.class, id);
    }

    public List<Client> getAllClients() {
        return session.createQuery("from Client", Client.class).list();
    }

    public void updateClient(Client client) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteClient(Client client) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
