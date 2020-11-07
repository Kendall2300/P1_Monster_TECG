package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * SoloPostres
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo SoloPostres
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class SoloPostres extends Hechizos {

    /**
     * SoloPostres
     * El metodo constructor que coloca los valores para el hechizo SoloPostres que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public SoloPostres(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta SoloPostres
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {
        int lp=getBoard().getOpponentPlayer().getLifePoints();
        int lp_to_lose=500;
        if((lp-lp_to_lose)<0){
            getBoard().getOpponentPlayer().setLifePoints(0);
        }else{
            getBoard().getOpponentPlayer().setLifePoints(lp-lp_to_lose);
         }
    }
}
