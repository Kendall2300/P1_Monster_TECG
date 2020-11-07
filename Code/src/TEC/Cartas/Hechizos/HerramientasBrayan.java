package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class HerramientasBrayan extends Hechizos {
    public HerramientasBrayan(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        int lp = getBoard().getPlayer().getLifePoints();
        int lp_to_lose = 150;
        if ((lp - lp_to_lose) < 0) {
            getBoard().getPlayer().setLifePoints(0);

        } else {
            getBoard().getPlayer().setLifePoints(lp - lp_to_lose);

        }
    }
}
