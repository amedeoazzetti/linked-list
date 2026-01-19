public class Stack {
    // head of the list
    private Node top;

    public Stack(){
        this.top = null;
    }

    public Stack(Node newNode){
        this.top = newNode;
    }

    public boolean isEmpty(){

        return top == null;

    }

    /**
     *  Legge il primo elemento 
     * @return contenuto del primo nodo
     */
    public int head(){
        return top.getValue();
    }
    

    /**
     * Rimuove il primo elemento dallo stack, aggiornando il riferimento
     * @return nodo rimosso
     */
    public Node pop(){
        Node cursor = top;
        Node rimosso = top.getNext();
        cursor.getNext().getNext();
        return rimosso;
        
    }

    /**
     * Aggiunge un nuovo nodo sopra allo stack
     * @param nowNode nodo aggiunto
     */
    public void push(Node nowNode){
        Node cursor = top;
        
        cursor.setNext(nowNode);   
    }



}
