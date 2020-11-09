package TEC.Board.Player.ListaDoble;
/**
 Lista cicular, no hay que añadir más de dos veces un elemento como inicio ya que el código no contempla esta acción,
 la lista fue creada esperando solo un insertarInicio y todo lo demás como insertarfinal
 */
public class LinkedList {
    private Node head;
    private int size;
    private Node last;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Este metodo revisa si la lista se encuentra o no vacia.
     * @return
     */
    public boolean isEmpty() {

        Boolean x = this.head == null;
        Boolean y = this.last == null;
        return x == y;
    }



    /**
     * Este metodo inserta un dato como inicio de la lista
     * @param dato String
     */

    public void insertFirst(Object data){
        Node newNode = new Node(data);
        if(this.isEmpty()){
            this.head = this.last = newNode;
        }else{
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }
    /**
     * Este metodo inserta un dato al final de la lista
     * @param dato String
     */
    public void insertLast(Object data){
        Node newNode = new Node(data);

        if(this.isEmpty()){
            this.head = this.last = newNode;
        }else{
            this.last.setNext(newNode);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Muestra el tamanio de la lista
     */
    public int size() {
        return this.size;
    }

    /**
     * Muestra los elementos de la lista
     * @param  i Integer
     */
    public String displayList() {
        Node current = this.head;
        String x = " ";
        while (current != null) {
            x = x + current.getData() + " \n ";
            System.out.println(current.getData());
            current = current.getNext();

        }
        return x;
    }

}
