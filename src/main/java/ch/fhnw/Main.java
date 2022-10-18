package ch.fhnw;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Konto gemeinsamesKonto = new Konto();
        Person p1;
        Person p2;

        for (int i = 1; i <= 20; i++) {
            p1 = new Person("Franz", gemeinsamesKonto);
            p2 = new Person("Fritz", gemeinsamesKonto);

            System.out.println(i + ".");
            gemeinsamesKonto.initalisiere(400);
            System.out.println("Kontostand vor Bewegung: " + gemeinsamesKonto.stand());

            p1.start();
            p2.start();

            try {

                p1.join();
                p2.join();
            } catch (InterruptedException e) {

            }
            System.out.println("Kontostand nach Bewegungen: " + gemeinsamesKonto.stand() + "\n");

        }
    }
}