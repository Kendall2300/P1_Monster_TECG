package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;
/**
 * ChocoMilk
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo ChocoMilk
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class ChocoMilk extends Hechizos{

    /**
     * ChocoMilk
     * El metodo constructor que coloca los valores para el hechizo ChocoMilk que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public ChocoMilk(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta ChocoMilk
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) { // Completo
        getBoard().getOpponentPlayer().setLifePoints(getBoard().getOpponentPlayer().getLifePoints() - 50);

    }
}
