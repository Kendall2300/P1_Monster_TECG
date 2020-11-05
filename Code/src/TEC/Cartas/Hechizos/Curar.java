package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Curar extends Hechizos{

    public Curar(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        int lp=getBoard().getPlayer().getLifePoints();
        int lp_to_gain= (int) Math.floor(Math.random()*(1-1000+1)+1000);
        if((lp+lp_to_gain)>1000){
            getBoard().getPlayer().setLifePoints(1000);
        }else{
            getBoard().getPlayer().setLifePoints(lp+lp_to_gain);
        }
    }
}
