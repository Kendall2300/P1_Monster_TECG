package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * NegarAtaque
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo NegarAtaque
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class NegarAtaque extends Hechizos {

    /**
     * NegarAtaque
     * El metodo constructor que coloca los valores para el hechizo NegarAtaque que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public NegarAtaque(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta NegarAtaque
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {

    }
}
