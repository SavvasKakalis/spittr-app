package main.java;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Spitter george = new Spitter(2,"nick", "nik123", "Nick Bowie");

        SpittrServiceImpl spittrService = new SpittrServiceImpl();

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
        //Spitter updatedGeorge = new Spitter(1,"geo", "geo789", "George Smith");
        //spittrService.updateSpitter(updatedGeorge);

        // delete the Spitter
        //spittrService.deleteSpitter(1);

        // insert a new spittle
        //Spittle spittle = new Spittle(2,"Good night people!!!", Timestamp.valueOf("2007-09-23 10:10:10.0"), "geo");
        //spittrService.createSpittle(spittle);

        // retrieve the Spittle
        //Spittle spittle2 = spittrService.findSpittleByMessage("Good Morning people!!!");
        //logger.info(spittle2.getMessage() + " " + spittle2.getTimeSubmitted() + " " + spittle2.getSpitter());

        // search and retrieve the Spittle objects by a certain Spitter
        /*List<Spittle> spittles = spittrService.findSpittlesBySpitter("geo");
        for (Spittle entry : spittles) {
            logger.info(entry.getMessage() + " " + entry.getTimeSubmitted() + " " + entry.getSpitter());
        }*/

        // update the Spittle
        //Spittle spittle3 = new Spittle(2,"How you doin?", Timestamp.valueOf("2007-09-23 10:10:10.0"), "geo");
        //spittrService.updateSpittle(spittle3);

        // delete the Spittle
        //spittrService.deleteSpittle(2);

    }
}