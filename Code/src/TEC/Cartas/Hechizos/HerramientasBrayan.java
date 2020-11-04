package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;
import TEC.Cartas.Secretos.Secretos;

public class HerramientasBrayan extends Hechizos {
    public HerramientasBrayan(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        /*int lp=getBoard().getPlayer().getlifePoints();
        int lp_to_lose=150;
        if((lp-lp_to_lose)<0){
            return getBoard().getPlayer().setLifePoints(0);

        }else{
            return getBoard().getPlayer().setLifePoints(lp-lp_to_lose);
         */
    }
}
