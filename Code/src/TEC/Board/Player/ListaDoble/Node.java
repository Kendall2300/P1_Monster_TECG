package TEC.Board.Player.ListaDoble;

public class Node {
    private Object data;
    Node next;

    public Node(Object data) {
        this.next = null;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Object getNodo() {
        return this;
    }
}