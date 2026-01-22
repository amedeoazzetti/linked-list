
public class CircularList {

    private Node head;

    public CircularList() {
        this.head = null;
    }

    // list starting from a node
    public CircularList(Node newHead) {
        this.head = newHead;
    }

    public boolean Presente(Node n) {
        if (head == null) {
            return false;
        }

        Node cursor = head;
        do {
            if (cursor.equals(n)) {
                return true;
            }
            cursor = cursor.getNext();
        } while (cursor != head);

        return false;
    }


    /*
    - print( ), che stampa tutti gli elementi della lista a partire da head
     */
    public void print() {
        Node cursor = head;

        while (cursor.getNext() != null) {
            System.out.println(cursor);
            cursor = cursor.getNext();
        }
    }

    /**
    * Controlla che non esistano riferimenti null all'interno della lista circolare.
    * Verifica che ogni nodo abbia un riferimento next valido e che la lista sia circolare.
    * @return true se la lista è valida e circolare senza null, false altrimenti
    */
    public boolean checkRing() {
        // Lista vuota è considerata valida
        if (head == null) {
            return true;
        }
        Node cursor = head;
        // Scorre tutti i nodi fino a tornare a head
        do {
            // Se trova un riferimento null, la lista non è valida
            if (cursor.getNext() == null) {
            return false;
            }
            cursor = cursor.getNext();  // IMPORTANTE: avanza il cursore
        } while (cursor != head);
    
        return true;  // Nessun null trovato, lista circolare valida
    }

    /**
     * che rimuove tutti i nodi con indice compreso tra "start" e "end"
     * @param start indice del inizio
     * @param end indice della fine
     * @return
     */
    public int removeRange(int start, int end) {
        // Controllo preliminare: lista vuota o intervallo non valido
        if (head == null || start >= end) {
            return 0;
        }

        Node cursor = head;      // Puntatore per scorrere la lista
        Node cursor1;            // Puntatore per trovare la fine dell'intervallo
        int fine = 0;            // Contatore per la lunghezza dell'intervallo
        int inizio = 0;          // Contatore per la posizione corrente

        // Scorre la lista fino a tornare al nodo head
        while (cursor.getNext() != head) {
            // Quando raggiungiamo l'indice start
            if (inizio == start) {
                cursor1 = cursor;  // Salva il nodo all'inizio dell'intervallo

                // Cerca il nodo alla fine dell'intervallo
                while (cursor1.getNext() != head) {
                    // Quando abbiamo percorso (end - start) nodi
                    if (fine == (end - start)) {
                        // Collega il nodo start al nodo successivo a end
                        // Questo rimuove tutti i nodi nell'intervallo [start, end)
                        cursor.setNext(cursor1.getNext());
                        return end - start;  // Restituisce il numero di nodi rimossi
                    }
                    cursor1 = cursor1.getNext();  // Avanza nel conteggio
                    fine++;
                }
            }
            inizio++;
            cursor = cursor.getNext();  // Passa al nodo successivo
        }

        return 0;  // Intervallo non trovato o fuori range
    }

    /**
     * rimuove dalla coda tutti i nodi successivi al nodo con indice "last"
     * @param last indece del ultimo nodo nella lista
     */
    public void cut(int last) {
        Node cursor = head;
        int index = 0;

        while (cursor.getNext() != head) {
            if (index == last) {
                cursor.setNext(head);
            }
            index++;
            cursor = cursor.getNext();
        }
    }

    /**
     * restituisce il riferimento precedente del nodo corrente
     *
     * @param n il nodo di cui trovare il precedente
     * @return il nodo precedente a n, oppure null se n non è presente nella
     * lista
     */
    public Node getPrev(Node n) {
        Node cursor = head;

        if (n == head) {
            while (cursor.getNext() != head) {
                cursor = cursor.getNext();
            }
            return cursor;
        }

        while (cursor.getNext() != n) {
            cursor = cursor.getNext();
            if (cursor.getNext() == head) {
                return null; // Nodo non trovato
            }
        }

        return cursor;
    }

    /**
     * che specifica i nuovi nodi di inizio e fine della lista circolare, a
     * patto che essi appartengano già alla coda. Se non sono presenti vanno
     * aggiunti.
     *
     * @param n1 Nodo da aggiungere in testa
     * @param n2 Nodo da aggiungere in coda
     */
    public void newRing(Node n1, Node n2) {
        // Controlla se n1 è già presente nella lista
        if (!Presente(n1)) {
            // n1 non è presente, quindi lo aggiungiamo in testa
            n1.setNext(head);  // Il next di n1 punta all'attuale head
            head = n1;         // n1 diventa il nuovo head (inizio della lista)
        }

        // Trova l'ultimo nodo della lista circolare
        Node cursor = head;
        while (cursor.getNext() != head) {  // Scorre fino a trovare il nodo che punta a head
            cursor = cursor.getNext();
        }

        // Controlla se n2 è già presente nella lista
        if (!Presente(n2)) {
            // n2 non è presente, quindi lo aggiungiamo in coda
            cursor.setNext(n2);    // L'ultimo nodo ora punta a n2
            n2.setNext(head);      // n2 punta a head, chiudendo il cerchio
        } else {
            // n2 è già presente, quindi dobbiamo trovarlo e chiudere il cerchio lì
            Node temp = head;
            while (temp.getNext() != n2) {  // Scorre fino a trovare il nodo che precede n2
                temp = temp.getNext();
            }
            temp.setNext(head);  // Il nodo che precede n2 punta a head, rendendo n2 l'ultimo nodo
        }
    }
}
