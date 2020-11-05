package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Desmadre extends Hechizos{
    public Desmadre(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        int lp=getBoard().getPlayer().getLifePoints();
        int lp_to_lose = (int) Math.floor(Math.random()*(1-1000+1)+1000);
        getBoard().getPlayer().setLifePoints(lp-lp_to_lose);
    }
}
