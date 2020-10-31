package TEC.Cartas.Secretos;

import TEC.Cartas.Esbirros;

public class HerramientasBrayan extends Secretos{
    public HerramientasBrayan(String name, int mana_cost, String efecto) {
        super(name, mana_cost, efecto);
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
