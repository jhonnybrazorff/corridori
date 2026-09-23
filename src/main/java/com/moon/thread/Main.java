package com.moon.thread;

public class Main {
    public static void main(String[] args) {
        Corridore corridoreA = new Corridore("Corridore A");
        Corridore corridoreB = new Corridore("Corridore B");

        // Avvio dei due thread
        corridoreA.start();
        corridoreB.start();

        try {
            // Il main attende la conclusione di entrambi i corridori
            corridoreA.join();
            corridoreB.join();
        } catch (InterruptedException e) {
            System.out.println("Il thread principale è stato interrotto.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Gara terminata!");
    }
}
