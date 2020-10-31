package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Curar extends Hechizos{

    public Curar(String name, int mana_cost, String efecto) {
        super(name, mana_cost, efecto);
    }

    @Override
    public void action(Esbirros esbirro) {
        /*int lp=getBoard().getPlayer().getlifePoints();
        int lp_to_gain=Math.floor(Math.random()*(1-1000+1)+1000);
        if((lp+lp_to_gain)>1000){
            return getBoard().getPlayer().setLifePoints(1000);

        }else{
            return getBoard().getPlayer().setLifePoints(lp+lp_to_gain);
        }*/
    }
}
