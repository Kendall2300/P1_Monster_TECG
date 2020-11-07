package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * Desmadre
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo Desmadre
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */

public class Desmadre extends Hechizos{
    /**
     * Desmadre
     * El metodo constructor que coloca los valores para el hechizo Desmadre que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public Desmadre(String name, int mana_cost) {
        super(name, mana_cost);
    }
    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta Desmadre
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) { //Completo
        int lp=getBoard().getOpponentPlayer().getLifePoints();
        int lp_to_lose = (int) Math.floor(Math.random()*(1-1000+1)+1000);
        getBoard().getOpponentPlayer().setLifePoints(lp-lp_to_lose);
    }
}
