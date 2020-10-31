package TEC.Cartas;

public abstract class Carta {
    private String name;
    private int mana_cost;
    private static Location location;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(int mana_cost) {
        this.mana_cost = mana_cost;
    }

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location location) {
        Carta.location = location;
    }
}

