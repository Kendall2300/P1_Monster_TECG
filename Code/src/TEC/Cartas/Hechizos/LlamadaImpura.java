package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class LlamadaImpura extends Hechizos{
    public LlamadaImpura(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        /*int lp=getBoard().getOpponetPlayer().getlifePoints();
        int lp_to_lose = (int) Math.floor(Math.random()*(1-1000+1)+1000);
        getBoard().getOpponentPlayer().setLifePoints(lp-lp_to_lose);*/
    }
}
