package main.java.com.spittr;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class SpittrServiceImpl implements SpittrServiceDAO {

    public void createSpitter(Spitter spitter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Spitter spitter = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Spitter> spitters = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Spittle spittle = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Spittle> spittles = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
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
