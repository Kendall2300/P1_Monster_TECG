package TEC.Cartas.Secretos;

import TEC.Cartas.Esbirros;

public class Aguante extends Secretos{
    public Aguante(String name, int mana_cost, String efecto) {
        super(name, mana_cost, efecto);
    }

    @Override
    public void action(Esbirros esbirro) {
        //int lp=getBoard().getPlayer().getLifePoints()
        /*
        if((lp-x)<0)){
            return getBoard().getPlayer().setLifePoints(1)
        }else{
            continue
        }
         */
    }
}
