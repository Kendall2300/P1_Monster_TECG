package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Aguante extends Hechizos {
    public Aguante(String name, int manaCost) {
        super(name, manaCost);
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
