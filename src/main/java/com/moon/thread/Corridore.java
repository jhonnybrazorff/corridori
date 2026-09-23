package com.moon.thread;

import java.util.concurrent.ThreadLocalRandom;

public class Corridore extends Thread {
    private String nome;

    public Corridore(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int passo = 1; passo <= 5; passo++) {
            System.out.println(nome + " ha fatto il passo " + passo);

            try {
        
                int pausa = ThreadLocalRandom.current().nextInt(200, 801);
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                System.out.println(nome + " è stato interrotto.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(nome + " ha raggiunto il traguardo!");
    }
}
