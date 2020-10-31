package TEC.Cartas.Secretos;

import TEC.Cartas.Esbirros;

public class Joker extends Secretos{
    public Joker(String name, int mana_cost, String efecto) {
        super(name, mana_cost, efecto);
    }

    @Override
    public void action(Esbirros esbirro) {
        /*int lp_to_gain=50;
        int lpy=getBoard().getPlayer().getLifePoints()
        int lpo=getBoard().getOpponentPlayer().getLifePoints()
        if((lpy+lp_to_gain)>1000){
            return getBoard().getPlayer().setLifePoints(1000)
        }else{
            return getBoard().getPlayer().setLifePoints(lpy+lp_to_gain)
        }
         */
    }
}
