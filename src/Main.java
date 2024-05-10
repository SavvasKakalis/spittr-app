//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SpittrService spittrService = new SpittrService();
        Spitter george = new Spitter(null, "geo", "geo123", "George Smith");
        spittrService.createSpitter(george);

        Date now = new Date();
        long millis = System.currentTimeMillis();
        Date dateFromMillis = new Date(millis);
        Spittle post = new Spittle(0L, "Good morning people!!!", now, george);
        spittrService.createSpittle(post);

        Spittle post2 = new Spittle(0L, "Good night people!!!", now, george);
        spittrService.createSpittle(post2);

        for (Spittle spittle : spittrService.findSpittlesBySpitter(george)) {
            System.out.println(spittle);
        }

        System.out.println("------------------------------------------------------");

        /*for (Spittle spittle : spittrService.getSpittles()) {
            System.out.println(spittle);
        }*/
        Spittle post3 = new Spittle(2L, "How are you doin all !!!", now, george);
        spittrService.updateSpittle(post3);

        for (Spittle spittle : spittrService.findSpittlesBySpitter(george)) {
            System.out.println(spittle);
        }


    }
}