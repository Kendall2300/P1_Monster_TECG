package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * Joker
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo Joker
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class Joker extends Hechizos {

    /**
     * Joker
     * El metodo constructor que coloca los valores para el hechizo Joker que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public Joker(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta Joker
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {
        int lp_to_gain=50;
        int lpy=getBoard().getPlayer().getLifePoints();
        int lpo=getBoard().getOpponentPlayer().getLifePoints();
        if((lpy+lp_to_gain)>1000){
            getBoard().getPlayer().setLifePoints(1000);
        }else{
            getBoard().getPlayer().setLifePoints(lpy+lp_to_gain);
        }

    }
}
