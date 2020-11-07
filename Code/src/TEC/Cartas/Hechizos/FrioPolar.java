package TEC.Cartas.Hechizos;

import TEC.Board.Player.Phase;
import TEC.Cartas.Esbirros;

/**
 * FrioPolar
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo FrioPolar
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class FrioPolar extends Hechizos{

    /**
     * FrioPolar
     * El metodo constructor que coloca los valores para el hechizo FrioPolar que será construido
     * @param name Un string que será el nombre del FrioPolar
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public FrioPolar(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta Frio Polar
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {
        if (getBoard().getOpponentPlayer().getField().getPhase() == Phase.Battle){
            getBoard().getOpponentPlayer().endPhase();
        }

    }
}
