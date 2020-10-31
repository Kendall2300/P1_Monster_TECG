package TEC.Cartas.Secretos;

import TEC.Cartas.Esbirros;

public class SoloPostres extends Secretos{
    public SoloPostres(String name, int mana_cost, String efecto) {
        super(name, mana_cost, efecto);
    }

    @Override
    public void action(Esbirros esbirro) {
        /*int lp=getBoard().getOpponetPlayer().getlifePoints();
        int lp_to_lose=500;
        if((lp-lp_to_lose)<0){
            return getBoard().getOpponentPlayer().setLifePoints(0);

        }else{
            return getBoard().getOpponentPlayer().setLifePoints(lp-lp_to_lose);
         */
    }
}
