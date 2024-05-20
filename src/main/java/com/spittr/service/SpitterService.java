package com.spittr.service;

import com.spittr.model.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpitterService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Spitter> getSpitters() {
        Session session = sessionFactory.openSession();
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
}

    //main.java.com.spittr.model.Spitter george = new Spitter(4, "geo", "geo7777777777",  "George Smith", null);
//Spittle newSpittle = new Spittle(1,"Good night people!!!", Timestamp.valueOf("2007-09-23 10:10:10.0"), george);
//main.java.com.spittr.model.SpittrServiceImpl spittrService = new main.java.com.spittr.model.SpittrServiceImpl();

// insert a Spitter
//spittrService.createSpitter(george);

// search for a Spitter by username
//Spitter newSpitter = spittrService.findSpitterByUsername("geo");
//logger.info(newSpitter.getUsername() + " " + newSpitter.getPassword() + " " + newSpitter.getFullName());

// return all Spitter objects
/*List<Spitter> spitters = spittrService.findAllSpitters();
for (Spitter entry : spitters) {
    logger.info(entry.getUsername() + " " + entry.getPassword() + " " + entry.getFullName());
}*/

// update a the password of Spitter
//Spitter updatedGeorge = new Spitter(4,"geo", "geo77777ngfngn77777", "George Smith", null);
//spittrService.updateSpitter(updatedGeorge);

// delete the Spitter
//spittrService.deleteSpitter(4);

// insert a new spittle
//Spittle spittle = new Spittle(1,"Good morning people!!!", Timestamp.valueOf("2008-09-23 10:10:10.0"), george);
//spittrService.createSpittle(spittle);

// retrieve the Spittle
//Spittle spittle2 = spittrService.findSpittleByMessage("Good Morning people!!!");
//logger.info(spittle2.getId() + " " + spittle2.getMessage() + " " + spittle2.getTimeSubmitted());

// search and retrieve the Spittle objects by a certain Spitter
/*List<Spittle> spittles = spittrService.findSpittlesBySpitter(4);
for (Spittle entry : spittles) {
    logger.info(entry.getMessage() + " " + entry.getTimeSubmitted());
}*/

// update the Spittle
//Spittle spittle3 = new Spittle(10, "How you doin?", Timestamp.valueOf("2007-09-23 10:10:10.0"), george);
//spittrService.updateSpittle(spittle3);

// delete the Spittle
//spittrService.deleteSpittle(10);


