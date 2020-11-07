package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Desmadre extends Hechizos{
    public Desmadre(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) { //Completo
        int lp=getBoard().getOpponentPlayer().getLifePoints();
        int lp_to_lose = (int) Math.floor(Math.random()*(1-1000+1)+1000);
        getBoard().getOpponentPlayer().setLifePoints(lp-lp_to_lose);
    }
}
