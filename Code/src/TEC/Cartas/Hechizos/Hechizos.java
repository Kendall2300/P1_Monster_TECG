package TEC.Cartas.Hechizos;

import TEC.Cartas.Carta;

public abstract class Hechizos extends Carta {
    private String Efecto;

    public Hechizos(String name, int mana_cost,String efecto) {
        super(name, mana_cost);
        this.Efecto = efecto;
    }

    public String getEfecto() {
        return Efecto;
    }

    public void setEfecto(String efecto) {
        Efecto = efecto;
    }
}
