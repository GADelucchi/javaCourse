package edu.coderhouse.postman.daos;

import edu.coderhouse.postman.models.Cliente;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DaoFactory {

    private final SessionFactory sessionFactory;
    @Autowired
    public DaoFactory(EntityManagerFactory factory) {
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public void create(Object obj) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }

    public Cliente getClienteById(int idCliente) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Cliente clienteGuardado = session.get(Cliente.class, idCliente);
        session.getTransaction().commit();
        return clienteGuardado;
    }

    public List<Cliente> getClientes() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Cliente> clientesGuardados = session.createQuery("FROM Cliente", Cliente.class).getResultList();
        session.getTransaction().commit();
        return clientesGuardados;
    }
}
