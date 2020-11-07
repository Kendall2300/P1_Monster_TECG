package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;


/**
 * HerramientasBrayan
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo Herramientas Brayan
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class HerramientasBrayan extends Hechizos {

    /**
     * HerramientasBrayan
     * El metodo constructor que coloca los valores para el hechizo HerramientasBrayan que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public HerramientasBrayan(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta Herramientas Brayan
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {
        int lp = getBoard().getPlayer().getLifePoints();
        int lp_to_lose = 150;
        if ((lp - lp_to_lose) < 0) {
            getBoard().getPlayer().setLifePoints(0);

        } else {
            getBoard().getPlayer().setLifePoints(lp - lp_to_lose);

        }
    }
}
