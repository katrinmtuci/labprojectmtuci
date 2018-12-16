package com.plotnikova.oracle;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseManager {

    private Configuration configuration = new Configuration();
    private SessionFactory factory;

    private void setupFactory() {
        factory = configuration.configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        if (factory == null) {
            setupFactory();
        }
        return factory;
    }

    public <T> List<T> loadEntities(Class<T> entityClass) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            query.select(root);
            return session.createQuery(query).getResultList();
        } catch (HibernateException ex) {
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
            return new ArrayList<T>();
        } finally {
            session.close();
        }
    }

    void saveEntity(Object entity) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }


    void updateEntity(Object entity) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
    }

    void deleteEntity(Object entity) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

}
