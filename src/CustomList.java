
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

    public void append(Node newNode){

        // se la lista e' vuota settiamo la nuova head
        if(isEmpty()){
            this.head = newNode;
            return;

        }
        Node cursor = head;
        while(cursor.getNext() != null){
            cursor = cursor.getNext();
        }
        cursor.setNext(newNode);
    }

    private void appendRec(Node cursor, Node newNode) {
        // exit clause
        if (cursor.getNext() == null) {
            cursor.setNext(newNode);
            return;
        }

        // recursive call
        appendRec(cursor.getNext(), newNode);
    }
    
    // wrapper version
    public void appendRec(Node newNode) {
        if (isEmpty()) {
            this.head = newNode;
            return;
        }
        appendRec(head, newNode);
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
        System.out.print("[ ");
        printRec(head);
        System.out.println("]");
    }

    // versione iterativa
    public void printIter() {
        System.out.print("[ ");
        Node cursor = head;
        
        while (cursor != null) {
            System.out.print(cursor.getValue() + " ");
            cursor = cursor.getNext();
        }
        
        System.out.println("]");
    }

    /**
     * Metodo per inserire un nodo in una determinata posizione
     * @param position posizione in cui voglio inserire il nodo
     * @param newNode nodo nuovo che vogliamo inserire
     */
    public void insertAt(int position, Node newNode) {
        // Insert at position 0 (new head)
        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        // Find the node before the insertion point
        Node cursor = head;
        int currentPos = 0;

        while (cursor != null && currentPos < position - 1) {
            cursor = cursor.getNext();
            currentPos++;
        }

        // If position is out of bounds, append at the end
        if (cursor == null) {
            append(newNode);
            return;
        }

        // Insert the node
        newNode.setNext(cursor.getNext());
        cursor.setNext(newNode);
    }

    /**
     * Metodo per rimuovore il nodo nelle posizione data
     * @param index posizione in cui rimuovere nodo
     */
    public void remove(int index) {
        if (isEmpty() || index < 0) {
            return;
        }

        // Remove head
        if (index == 0) {
            head = head.getNext();
            return;
        }

        // Find the node before the one to remove
        Node cursor = head;
        int currentPos = 0;

        while (cursor != null && currentPos < index - 1) {
            cursor = cursor.getNext();
            currentPos++;
        }

        // If position is out of bounds or next node is null, do nothing
        if (cursor == null || cursor.getNext() == null) {
            return;
        }

        // Remove the node
        Node nodeToRemove = cursor.getNext();
        Node nodeAfterRemoval = nodeToRemove.getNext();
        cursor.setNext(nodeAfterRemoval);
    }
    public boolean remove (Node n){
        if(n == null) return false;
        int index = indexOf(n);
        if(index<0) return false;
        remove(index);
        return true;
    }

    public int indexOf(Node n){
        Node cursor = head;
        int index =0;
        while(cursor!=null){
            if(cursor.equals(n)){
                cursor = cursor.getNext();
                index++;
            }
        }
        return -1;
    }

    /**
     * Riscivere un nodo data la sua posizione
     * @param index posizione del vecchio nodo
     * @param n nuovo nodo da settare
     */
    public void set(int index, Node n){
        Node cursor = head;
        while(cursor!=null){
            if (indexOf(cursor)==index) {
                cursor = n;
            }
            cursor = cursor.getNext();
        }
    }

    /**
     * Controlla se il nodo e' contenuto della lista
     * @param n nodo da trovare
     * @return true se il nodo e' presente senno' falso
     */
    public boolean contains(Node n){
        if (isEmpty()) {
            return false;
        }
        
        Node cursor = head;
        while (cursor != null) {
            if (cursor == n) {
                return true;
            }
            cursor = cursor.getNext();
        }
        return false;
    }

}
