package com.spittr.model;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class SpittleService {

    public List<Spittle> getSpittles(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Spittle> spittles = null;
        try {
            spittles = session.createQuery("from Spittle").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return spittles;
        /*return Arrays.asList(new Spittle(1,"Good night people!!!", Timestamp.valueOf("2007-09-23 10:10:10.0"),
                    new Spitter(1, "geo", "****",  "George Smith", null)),
                    new Spittle(2,"Good morning people!!!", Timestamp.valueOf("2008-09-23 10:10:10.0"),
                            new Spitter(1, "geo", "****",  "George Smith", null)));*/
    }

}
