package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * DonDuende
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo DonDuende
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */

public class DonDuende extends Hechizos {
    /**
     * DonDuende
     * El metodo constructor que coloca los valores para el hechizo DonDuende que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public DonDuende(String name, int mana_cost) {
        super(name, mana_cost);
    }
    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta DonDuende
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {//Falta

    }
}
