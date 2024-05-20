package com.spittr.service;

import com.spittr.model.Spittle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpittleService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Spittle> getSpittles() {
        Session session = sessionFactory.openSession();
        List<Spittle> spittles = null;
        try {
            spittles = session.createQuery("from Spittle").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return spittles;
    }
}
