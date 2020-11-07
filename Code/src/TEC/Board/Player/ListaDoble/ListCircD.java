package TEC.Board.Player.ListaDoble;
/**
 Lista cicular, no hay que añadir más de dos veces un elemento como inicio ya que el código no contempla esta acción,
 la lista fue creada esperando solo un insertarInicio y todo lo demás como insertarfinal
 */
public class ListCircD {
    int tamanio=0;
    Nodo inicio;
    Nodo fin;
    /**
     * Este metodo revisa si la lista se encuentra o no vacia.
     * @return
     */
    public boolean isVacia(){return (tamanio==0);}

    /**
     * Este metodo inserta un dato como inicio de la lista
     * @param dato String
     */

    public void insertarInicio(String dato){
        Nodo nuevo=new Nodo(dato);
        if (isVacia()){
            inicio=nuevo;
            fin=inicio;

            inicio.nodoSig=fin;
            inicio.nodoAnt=fin;
            fin.nodoSig=inicio;
            fin.nodoAnt=inicio;
            tamanio++;
        }else{
            Nodo aux=inicio;
            nuevo.nodoSig=aux;
            aux.nodoSig=nuevo;

            inicio=nuevo;

            tamanio++;
        }
    }
    /**
     * Este metodo inserta un dato al final de la lista
     * @param dato String
     */
    public void insertarFinal(String dato){
        Nodo nuevo=new Nodo(dato);
        if(isVacia()){
            inicio=nuevo;
            fin=nuevo;

            inicio.nodoSig=fin;
            inicio.nodoAnt=fin;
            fin.nodoSig=inicio;
            fin.nodoAnt=inicio;

            tamanio++;
        }else{
            Nodo aux=fin;

            aux.nodoSig=nuevo;
            nuevo.nodoAnt=aux;

            fin=nuevo;

            tamanio++;
        }
    }

    /**
     * Muestra el tamanio de la lista
     */
    public void tamanio(){
        System.out.println(tamanio);
    }

    /**
     * Muestra los elementos de la lista
     * @param  i Integer
     */
    public void mostrarElemntos(int i){
        if (!isVacia()){
            Nodo aux=inicio;
            for(i=i;i<tamanio;i++){
                System.out.println(aux.dato+"\n");
                aux=aux.nodoSig;
            }
        }else{
            System.out.println("Lista Vacia");
        }
    }

}
