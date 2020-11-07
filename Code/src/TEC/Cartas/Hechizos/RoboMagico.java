package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * RoboMagico
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo RoboMagico
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class RoboMagico extends Hechizos{

    /**
     * RoboMagico
     * El metodo constructor que coloca los valores para el hechizo RoboMagico que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public RoboMagico(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta RoboMagico
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {
        getBoard().getPlayer().addCardToHand();
    }
}
