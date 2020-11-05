package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class ElVendado extends Hechizos {
    public ElVendado(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        //int mana_to_lose=25
        //int mana=getBoard().getPlayer().getMana()
        //getBoard().getPlayer().setMana(mana-mana_to_lose)
    }
}
