package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;
import TEC.Cartas.Secretos.Secretos;

public class Aguante extends Hechizos {
    public Aguante(String name, int mana_cost) {
        super(name, mana_cost);
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
