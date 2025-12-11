
public class CustomList {

    // startin node of the structure
    private Node head;

    // empty list
    public CustomList() {
        this.head = null;
    }

    // list starting from a node
    public CustomList(Node newHead) {
        this.head = newHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * aggiunge un nuovo node alla lista
     *
     * @param valore valore che vogliamo aggiungere alla lista
     */
    public void addLast(int valore) {
        Node newNode = new Node(valore);

        // Controllo se la lista è vuota, in tal caso l'head è il nuovo nodo
        if (head == null) {
            head = newNode;
        }

        Node current = head;

        while (current.getNext() != null) {
            System.out.println(current.getValue()+ " ");
            current = current.getNext();

            current.setNext(newNode);

        }
    }

    public void append(Node newNode){

        // se la lista e' vuota settiamo la nuova head
        if(isEmpty()){
            this.head = newNode;
            return;

        }
        Node cursor = head;
        if(cursor.getNext() == null){
            cursor.setNext(newNode);
        }
    }

    // versione ricursiva
    public void printRec(Node cursor) {
        // exit clause
        if (cursor == null) {
            return;
        }

        System.out.print(cursor.getValue() + " ");

        // recursive call
        printRec(cursor.getNext());
    }

    // wrapper version
    public void printRec() {
        System.out.println("[");
        printRec(head);
        System.out.println("]");
    }
}
