package TEC.Cartas.Secretos;

import TEC.Cartas.Esbirros;

public class ElVendado extends Secretos{
    public ElVendado(String name, int mana_cost, String efecto) {
        super(name, mana_cost, efecto);
    }

    @Override
    public void action(Esbirros esbirro) {
        //int mana_to_lose=25
        //int mana=getBoard().getPlayer().getMana()
        //getBoard().getPlayer().setMana(mana-mana_to_lose)
    }
}
