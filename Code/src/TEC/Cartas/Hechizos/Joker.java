package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Joker extends Hechizos {
    public Joker(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        int lp_to_gain=50;
        int lpy=getBoard().getPlayer().getLifePoints();
        int lpo=getBoard().getOpponentPlayer().getLifePoints();
        if((lpy+lp_to_gain)>1000){
            getBoard().getPlayer().setLifePoints(1000);
        }else{
            getBoard().getPlayer().setLifePoints(lpy+lp_to_gain);
        }

    }
}
