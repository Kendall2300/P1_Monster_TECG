package TEC.Cartas.Secretos;

import TEC.Cartas.Carta;

public abstract class Secretos extends Carta {
    private String Efecto;

    public Secretos(String name, int mana_cost,String efecto) {
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
