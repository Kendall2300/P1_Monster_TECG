package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;


public class SoloPostres extends Hechizos {
    public SoloPostres(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        int lp=getBoard().getOpponentPlayer().getLifePoints();
        int lp_to_lose=500;
        if((lp-lp_to_lose)<0){
            getBoard().getOpponentPlayer().setLifePoints(0);
        }else{
            getBoard().getOpponentPlayer().setLifePoints(lp-lp_to_lose);
         }
    }
}
