package TEC.Cartas;

import TEC.Board.Board;

/**
 * Carta
 * Esta clase abstracta genera una base para todos los demás tipos de cartas que posee el juego
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public abstract class Carta {
    private String name;
    private int mana_cost;
    private static Location location;
    private static Board board;
    private boolean isHidden;

    /**
     * getBoard
     * Este metodo consigue el Board
     * @return Un objeto de tipo Board
     */
    public static Board getBoard() {
        return board;
    }

    /**
     * setBoard
     * Este metodo establece un valor al parametro Board
     * @param board Un objeto tipo Board
     */
    public static void setBoard(Board board) {
        Carta.board = board;
    }

    /**
     * Carta
     * Este es el metodo constructor de la clase carta
     * @param name Un string con el nombre de la carta
     * @param mana_cost Un entero con el costo de mana para jugar la carta
     */
    public Carta(String name, int mana_cost) {
        this.name = name;
        this.mana_cost = mana_cost;
    }

    /**
     * Carta
     * Este es el segundo metodo constructor de la clase carta, construye al aobejto carta
     * @param name Un string con el nombre de la carta
     * @param mana_cost Un entero con el costo de mana para jugar la carta
     * @param loc Un valor de tipo Location
     * @param hidden Un boolean
     */
    public Carta(String name, int mana_cost, Location loc, boolean hidden) {
        this.name = name;
        this.mana_cost = mana_cost;
        this.location=loc;
        this.isHidden=hidden;
    }

    /**
     * action
     * Este metodo toma las acciones de las carta por medio de un esbirro
     * @param esbirro Un objeto de tipo Esbirros
     */
    public abstract void action(Esbirros esbirro);

    /**
     * getName
     * Este metodo obtiene el nombre de la carta
     * @return Un string que va a ser el nombre de la carta
     */
    public String getName() {
        return name;
    }

    /**
     * getMana_Cost
     * Este metodo obtiene el valor de costo para jugar la carta
     * @return Un integer con el costo de la carta
     */
    public int getMana_cost() {
        return mana_cost;
    }

    /**
     * getLocation
     * Este metodo obtiene la ubicación de la carta
     * @return Un valor de tipo Location
     */
    public static Location getLocation() {
        return location;
    }

    /**
     * setLocation
     * Este metodo coloca la ubicacion de la carta
     * @param location Un valor de tipo Location
     */
    public static void setLocation(Location location) {
        Carta.location = location;
    }

    /**
     * isHidden
     * Este metodo comprueba si la carta se encuentra oculta o no
      * @return Un boolean
     */
    public boolean isHidden() {
        return isHidden;
    }

    /**
     * setHidden
     * Esete metodo coloca el valor para saber si la carta se encuentra oculta
     * @param hidden Un boolean
     */
    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }
}

