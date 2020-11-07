package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class El_gran_Keto extends Hechizos{//Completo
    public El_gran_Keto(String name, int mana_cost){
        super(name,mana_cost);
    }
    @Override
    public void action(Esbirros esbirro) {
        int lp=getBoard().getPlayer().getLifePoints();
        int lp_to_gain=500;
        if((lp+lp_to_gain)>1000){
            getBoard().getPlayer().setLifePoints(1000);

        }else{
            getBoard().getPlayer().setLifePoints(lp + lp_to_gain);
        }

    }
}
