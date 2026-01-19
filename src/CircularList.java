
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

    /*
    - checkRing( ), che controlla che non esistano riferimenti null all'interno della lista circolare
     */
    public boolean checkRing() {
        Node cursor = head;

        while (cursor.getNext() != head) {
            if (cursor.getNext() == null) {
                return false;
            }
        }
        return true;
    }

    /*
    - removeRange(int start, int end), che rimuove tutti i nodi con indice compreso tra "start" e "end".
     Motivare nei commenti eventuali scelte applicate in caso di input imperfetti.
     */
    public int removeRange(int start, int end) {
        if (head == null || start >= end) {
            return 0;
        }

        Node cursor = head;
        Node cursor1;
        int fine = 0;
        int inizio = 0;

        while (cursor.getNext() != head) {
            if (inizio == start) {
                cursor1 = cursor;
                while (cursor1.getNext() != head) {
                    if (fine == (end - start)) {
                        cursor.setNext(cursor1.getNext());
                        return end - start;
                    }
                    cursor1 = cursor1.getNext();
                    fine++;
                }
            }
            inizio++;
            cursor = cursor.getNext();
        }
        return 0;
    }

    /*
    - cut(int last), che rimuove dalla coda tutti i nodi successivi al nodo con indice "last"
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

    /*
    - getPrev(Node n), che restituisce il riferimento precedente del nodo corrente
     */
    public void getPrev(Node n) {
        Node cursor = head;

        if (n == head) {
            while (cursor.getNext() != head) {
                cursor = cursor.getNext();
            }
        }

        while (cursor.getNext().getNext() != n) {
            cursor = cursor.getNext();
        }

        System.out.println(cursor);

    }


    /*
    - newRing(Node n1, Node n2), che specifica i nuovi nodi
     di inizio e fine della lista circolare, a patto che essi appartengano già alla coda. Se non sono presenti vanno aggiunti, 
     con n1 da aggiungere in testa e n2 da aggiungere in coda.
     */
    public void newRing(Node n1, Node n2) {
        if (!Presente(n1)) {
            n1.setNext(head);
            head = n1;
        }

        Node cursor = head;
        while (cursor.getNext() != head) {
            cursor = cursor.getNext();
        }

        if (!Presente(n2)) {
            cursor.setNext(n2);
            n2.setNext(head);
        } else {
            Node temp = head;
            while (temp.getNext() != n2) {
                temp = temp.getNext();
            }
            temp.setNext(head);
        }
    }
}
