package TEC.Cartas;

import TEC.Board.Board;

public abstract class Carta {
    private String name;
    private int mana_cost;
    private static Location location;
    private static Board board;

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        Carta.board = board;
    }

    public Carta(String name, int mana_cost) {
        this.name = name;
        this.mana_cost = mana_cost;
    }
    public Carta(String name, int mana_cost, Location loc) {
        this.name = name;
        this.mana_cost = mana_cost;
        this.location=loc;
    }
    public abstract void action(Esbirros esbirro);

    public String getName() {
        return name;
    }

    public int getMana_cost() {
        return mana_cost;
    }

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location location) {
        Carta.location = location;
    }
}

