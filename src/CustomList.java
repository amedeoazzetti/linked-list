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

    public boolean isEmpty(){
        return head == null;
    }

    /**
     * aggiunge un nuovo node alla lista
     * @param valore valore che vogliamo aggiungere alla lista
     */
    public void addLast(int valore){
        Node newNode = new Node(valore);

        // Controllo se la lista è vuota, in tal caso l'head è il nuovo nodo
        if(head == null){
            head = newNode;
            
        }

        Node current = head;
        while(current != null){
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        
    }

}
