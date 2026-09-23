import java.util.concurrent.ThreadLocalRandom;

/**
 * Rappresenta un corridore che partecipa alla gara.
 *
 * La classe estende {@link Thread}, quindi ogni oggetto Corridore
 * viene eseguito all'interno di un thread indipendente.
 */
public class Corridore extends Thread {

    /**
     * Nome del corridore.
     */
    private String nome;

    /**
     * Costruisce un nuovo corridore.
     *
     * @param nome il nome da assegnare al corridore
     */
    public Corridore(String nome) {
        this.nome = nome;
    }

    /**
     * Esegue la gara del corridore.
     *
     * Il corridore compie 5 passi. Dopo ogni passo viene effettuata
     * una pausa casuale compresa tra 200 e 800 millisecondi.
     */
    @Override
    public void run() {

        // Il corridore esegue 5 passi
        for (int passo = 1; passo <= 5; passo++) {

            // Stampa il progresso del corridore
            System.out.println(nome + " ha fatto il passo " + passo);

            try {
                /*
                 * Genera una pausa casuale tra 200 e 800 millisecondi.
                 *
                 * Il limite superiore è 801 perché il metodo nextInt()
                 * esclude il valore massimo indicato.
                 */
                int pausa = ThreadLocalRandom.current()
                        .nextInt(200, 801);

                // Sospende temporaneamente l'esecuzione del thread
                Thread.sleep(pausa);

            } catch (InterruptedException e) {
                /*
                 * Gestisce l'interruzione del thread.
                 * Il flag di interruzione viene ripristinato
                 * per non perdere l'informazione sull'interruzione.
                 */
                System.out.println(nome + " è stato interrotto.");
                Thread.currentThread().interrupt();

                // Interrompe la gara del corridore
                return;
            }
        }

        // Messaggio visualizzato quando il corridore completa tutti i passi
        System.out.println(nome + " ha raggiunto il traguardo!");
    }
}
