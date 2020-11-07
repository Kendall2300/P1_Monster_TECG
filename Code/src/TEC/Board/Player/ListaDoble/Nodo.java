package TEC.Board.Player.ListaDoble;

public class Nodo {
    String dato;
    Nodo nodoSig;
    Nodo nodoAnt;

    public Nodo(String dato) {
        this.dato = dato;
        this.nodoSig = null;
        this.nodoAnt = null;
    }
}
