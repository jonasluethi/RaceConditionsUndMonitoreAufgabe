package ch.fhnw;
// Variante 2 mit Erben ->

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Person extends Thread {

    private Lock schlüssel = new ReentrantLock();

    Konto konto;

    String name;


    public Person(String name, Konto konto) {
        this.name = name;
        this.konto = konto;
    }


    public void run(){


        int lokalerKontostand = konto.stand();
        System.out.println(" " + name + " hat " + lokalerKontostand + " gelsen");

        try {

            switch (name) {
                case "Franz" -> {
                    TimeUnit.MILLISECONDS.sleep(800);
                    System.out.println(" " + name + " will 200 einzahlen");
                    lokalerKontostand += 200;

                    //int zahl = finanzTransaktion(200, lokalerKontostand);

                    System.out.println(lokalerKontostand + " bei plus 200");

                }
                case "Fritz" -> {
                    TimeUnit.MILLISECONDS.sleep(800);
                    System.out.println(" " + name + " will 100 abheben");
                    lokalerKontostand -= 100;
                    //int zahl = finanzTransaktion(-100 , lokalerKontostand);
                    System.out.println(lokalerKontostand + " bei minus 100");
                }
            }

            finanzTransaktion(lokalerKontostand);

        } catch (InterruptedException e) {

        }

    }

    private void finanzTransaktion( int lokalerKontostand) {

        schlüssel.lock();
        try {

            konto.anpassen(lokalerKontostand);

        } finally {
            schlüssel.unlock();
        }


    }
}
