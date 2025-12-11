public class App {
    public static void main(String[] args) throws Exception {
        // strutture dinamiche
        Node n = new Node(10);
        Node n1 = new Node(29);
        Node n2 = new Node(3);

        CustomList list = new CustomList(new Node(5));
        list.append(n);
        list.append(n1);
        list.append(n2);

        // Stampa con metodo ricorsivo
        System.out.println("Metodo ricorsivo:");
        list.printRec();
        
        // Stampa con metodo iterativo
        System.out.println("Metodo iterativo:");
        list.printIter();
    }
}
