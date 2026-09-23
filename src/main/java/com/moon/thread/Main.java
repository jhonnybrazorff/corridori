/**
 * Classe principale dell'applicazione.
 *
 * Crea e avvia i due corridori, quindi attende
 * il completamento di entrambi prima di terminare la gara.
 */
public class Main {

    /**
     * Punto di ingresso del programma.
     *
     * @param args argomenti passati da riga di comando
     */
    public static void main(String[] args) {

        /*
         * Creazione dei due corridori.
         * Ogni oggetto rappresenta un thread indipendente.
         */
        Corridore corridoreA = new Corridore("Corridore A");
        Corridore corridoreB = new Corridore("Corridore B");

        /*
         * Avvio dei thread.
         *
         * È importante utilizzare start() e non run():
         * start() crea un nuovo thread ed esegue run() al suo interno.
         */
        corridoreA.start();
        corridoreB.start();

        try {
            /*
             * Il thread principale attende che il Corridore A
             * termini la propria esecuzione.
             */
            corridoreA.join();

            /*
             * Il thread principale attende che anche il Corridore B
             * termini la propria esecuzione.
             */
            corridoreB.join();

        } catch (InterruptedException e) {
            /*
             * Gestisce l'eventuale interruzione del thread principale.
             */
            System.out.println(
                    "Il thread principale è stato interrotto."
            );

            // Ripristina lo stato di interruzione del thread
            Thread.currentThread().interrupt();
        }

        /*
         * Questo messaggio viene stampato solo dopo che entrambi
         * i corridori hanno terminato la loro gara.
         */
        System.out.println("Gara terminata!");
    }
}
