package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * El_gran_Keto
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo El_gran_Keto
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class El_gran_Keto extends Hechizos{//Completo

    /**
     * El_gran_Keto
     * El metodo constructor que coloca los valores para el hechizo El_gran_Keto que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public El_gran_Keto(String name, int mana_cost){
        super(name,mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta El gran Keto
     * @param esbirro un objeto de tipo Esbirro
     */
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
