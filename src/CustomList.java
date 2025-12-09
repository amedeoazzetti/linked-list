public class CustomList {
    // startin node of the structure
    private Node head;

    // empty list
    public CustomList(){
        this.head = null;
    }

    // list starting from a node
    public CustomList(Node newHead){
        this.head = newHead;
    }

    public void addLast(int value){
        Node newNode = new Node(value);

        // Controllo se la lista è vuota, in tal caso l'head è il nuovo nodo
        if(head == null){
            head = newNode;
        }

        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newNode);


    }
}
