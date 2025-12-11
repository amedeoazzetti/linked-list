
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
}
