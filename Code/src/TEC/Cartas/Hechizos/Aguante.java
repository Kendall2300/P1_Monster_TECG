package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Aguante extends Hechizos {
    public Aguante(String name, int manaCost) {
        super(name, manaCost);
    }

    @Override
    public void action(Esbirros esbirro) { //Completo
        int lp=getBoard().getPlayer().getLifePoints();

        if(lp <= 0){
            getBoard().getPlayer().setLifePoints(1);
            return;
        }else{
            return;
        }

    }
}
