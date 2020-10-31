package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class El_gran_Keto extends Hechizos{
    public El_gran_Keto(String name,int mana_cost,String efecto){
        super(name,mana_cost,efecto);
    }
    @Override
    public void action(Esbirros esbirro) {
        /*int lp=getBoard().getPlayer().getlifePoints();
        int lp_to_gain=500;
        if((lp+lp_to_gain)>1000){
            return getBoard().getPlayer().setLifePoints(1000);

        }else{
            return getBoard().getPlayer().setLifePoints(lp+lp_to_gain);
        }*/

    }
}
