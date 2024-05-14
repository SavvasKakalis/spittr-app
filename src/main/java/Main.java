package main.java;

import java.net.URL;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        URL persistenceXmlUrl = Main.class.getClassLoader().getResource("META-INF/persistence.xml");
        if (persistenceXmlUrl != null) {
            System.out.println("Found persistence.xml at: " + persistenceXmlUrl);
        } else {
            System.out.println("Unable to find persistence.xml");
        }

        SpittrServiceImpl spittrService = new SpittrServiceImpl();
        Spitter george = new Spitter("geo", "geo123", "George Smith");

        // insert a Spitter
        spittrService.createSpitter(george);

        // search for a Spitter by username
        //Spitter newSpitter = spittrService.findSpitterByUsername("geo");
        //logger.info(newSpitter.getUsername() + " " + newSpitter.getPassword() + " " + newSpitter.getFullName());

        // return all Spitter objects
        /*Map<Integer, Spitter> spitters = spittrService.findAllSpitters();
        for (Map.Entry<Integer, Spitter> entry : spitters.entrySet()) {
            logger.info(entry.getValue().getUsername() + " " + entry.getValue().getPassword() + " " + entry.getValue().getFullName());
        }*/

        // update a the password of Spitter
        //Spitter updatedGeorge = new Spitter("geo", "geo789", "George Smith");
        //spittrService.updateSpitter(updatedGeorge);

        // delete the Spitter
        //spittrService.deleteSpitter("geo");

        // insert a new spittle
        //Spittle spittle = new Spittle("Good morning people!!!", LocalDateTime.of(2024, 5, 9, 10, 30), george);
        //spittrService.createSpittle(spittle);

        // retrieve the Spittle
        //Spittle spittle2 = spittrService.findSpittleByMessage("Good Morning people!!!");
        //logger.info(spittle2.getMessage() + " " + spittle2.getTimeSubmitted() + " " + spittle2.getSpitter());

        // search and retrieve the Spittle objects by a certain Spitter
        /*Map<Integer, Spittle> spittles = spittrService.findSpittlesBySpitter("geo");
        for (Map.Entry<Integer, Spittle> entry : spittles.entrySet()) {
            logger.info(entry.getValue().getMessage() + " " + entry.getValue().getTimeSubmitted() + " " + entry.getValue().getSpitter().getUsername());
        }*/

        // update the Spittle
        //Spittle spittle3 = new Spittle("How you doin?", LocalDateTime.of(2024, 5, 9, 11, 23), george);
        //spittrService.updateSpittle("Good morning people!!!", spittle3);

        // delete the Spittle
        //spittrService.deleteSpittle("How you doin?");

    }
}