//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws SQLException {

        SpittrServiceImpl spittrService = new SpittrServiceImpl();

        // insert a Spitter
        Spitter george = new Spitter("geo", "geo123", "George Smith");
        spittrService.createSpitter(george);

        // search for a Spitter by username
        Spitter newSpitter = spittrService.findSpitterByUsername("geo");
        logger.info(newSpitter.getUsername() + " " + newSpitter.getPassword() + " " + newSpitter.getFullName());

        // return all Spitter objects
        Map<Integer, Spitter> spitters = spittrService.findAllSpitters();
        for (Map.Entry<Integer, Spitter> entry : spitters.entrySet()) {
            logger.info(entry.getValue().getUsername() + " " + entry.getValue().getPassword() + " " + entry.getValue().getFullName());
        }

        // update a the password of Spitter
        Spitter updatedGeorge = new Spitter("geo", "geo789", "George Smith");
        spittrService.updateSpitter(updatedGeorge);

        // delete the Spitter
        spittrService.deleteSpitter("geo");

        // insert a new spittle
        Spittle spittle = new Spittle("Good morning people!!!", LocalDateTime.of(2024, 5, 9, 10, 30), george);
        spittrService.createSpittle(spittle);

        /*Spittle post = new Spittle("Good morning people!!!", LocalDateTime.of(2024, 5, 9, 10, 30), george);
        spittrService.createSpittle(post);

        Spittle post2 = new Spittle("Good night people!!!", LocalDateTime.of(2024, 5, 9, 23, 23), george);
        spittrService.createSpittle(post2);

        for (Map.Entry<Integer, Spittle> entry : spittrService.findSpittlesBySpitter(george.getUsername()).entrySet()) {
            logger.info(entry.getValue().getSpitter().getUsername() + " posted: " + entry.getValue().getMessage() + " Time posted: " + entry.getValue().getTimeSubmitted());
        }

        logger.info("------------------------------------------------------");
        logger.info(george.getUsername() + " edited a post.");

        Spittle post3 = new Spittle("Good night. Sweat dreams!!!", LocalDateTime.of(2024, 5, 9, 23, 40), george);
        spittrService.updateSpittle(2, post3);

        for (Map.Entry<Integer, Spittle> entry : spittrService.findSpittlesBySpitter(george.getUsername()).entrySet()) {
            logger.info(entry.getValue().getSpitter().getUsername() + " posted: " + entry.getValue().getMessage() + " Time posted: " + entry.getValue().getTimeSubmitted());
        }*/


    }
}