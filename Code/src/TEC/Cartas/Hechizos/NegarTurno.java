package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * NegarTurno
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo NegarTurno
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class NegarTurno extends Hechizos {

    /**
     * NegarTurno
     * El metodo constructor que coloca los valores para el hechizo NegarTurno que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public NegarTurno(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta NegarTurno
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {
        getBoard().getOpponentPlayer().addCardToHand();
        getBoard().getOpponentPlayer().endTurn();


    }
}
