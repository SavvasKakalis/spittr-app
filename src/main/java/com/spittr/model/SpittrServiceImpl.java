package com.spittr.model;

import com.spittr.model.SpittrServiceDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpittrServiceImpl implements SpittrServiceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void createSpitter(Spitter spitter) {
        Session session = sessionFactory.openSession();        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(spitter);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Spitter findSpitterByUsername(String username) {
        Session session = sessionFactory.openSession();        Spitter spitter = null;
        try {
            Query query = session.createQuery("from Spitter where username = :username");
            query.setParameter("username", username);
            List<Spitter> results = query.list();
            if (!results.isEmpty()) {
                spitter = results.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return spitter;
    }

    public List<Spitter> findAllSpitters() {
        Session session = sessionFactory.openSession();        List<Spitter> spitters = null;
        try {
            spitters = session.createQuery("from Spitter").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return spitters;
    }

    public void updateSpitter(Spitter spitter) {
        Session session = sessionFactory.openSession();        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(spitter);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteSpitter(int spitterId) {
        Session session = sessionFactory.openSession();        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Spitter spitter = (Spitter) session.load(Spitter.class, spitterId);
            session.delete(spitter);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void createSpittle(Spittle spittle) {
        Session session = sessionFactory.openSession();        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(spittle);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Spittle findSpittleByMessage(String message) {
        Session session = sessionFactory.openSession();        Spittle spittle = null;
        try {
            Query query = session.createQuery("from Spittle where message = :message");
            query.setParameter("message", message);
            List<Spittle> results = query.list();
            if (!results.isEmpty()) {
                spittle = results.get(0);
            }
        } finally {
            session.close();
        }
        return spittle;
    }

    public List<Spittle> findSpittlesBySpitter(int spitter_id) {
        Session session = sessionFactory.openSession();        List<Spittle> spittles = null;
        try {
            Query query = session.createQuery("from Spittle where spitter_id = :spitter_id");
            query.setParameter("spitter_id", spitter_id);
            spittles = query.list();
        } finally {
            session.close();
        }
        return spittles;
    }

    public void updateSpittle(Spittle spittle) {
        Session session = sessionFactory.openSession();        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(spittle);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteSpittle(int spittleId) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Spittle spittle = (Spittle) session.load(Spittle.class, spittleId);
            session.delete(spittle);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
