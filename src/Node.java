public class Node {
    // stored value
    private int value;

    // reference to the next node in the structure  
    private Node next;
    public Node(int newValue) {

        this.value = newValue;
        this.next = null; // default

    }

    public int getValue(){
        return value;
    }

    public Node getNext(){
        return next;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setNext(Node next){
        this.next = next;
    }

    @Override
    public String toString(){
        return "{" + value + "}";
    }
    
    // I can specify how the equals() method works
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj == null) return false;

        if(getClass() != obj.getClass()) return false;

        Node node = (Node)obj;

        return this.value == node.getValue();


    }
}
