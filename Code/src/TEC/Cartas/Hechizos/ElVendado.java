package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

/**
 * ElVendado
 * Esta clase herada los metodos de Hechizos y será la encargada de establecer el efecto que tendrá el hechizo ElVendado
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class ElVendado extends Hechizos {

    /**
     * ElVendado
     * El metodo constructor que coloca los valores para el hechizo ElVendado que será construido
     * @param name Un string que será el nombre del Hechizo
     * @param mana_cost Un valor entro que será el coste de mana al jugar la carta
     */
    public ElVendado(String name, int mana_cost) {
        super(name, mana_cost);
    }

    /**
     * action
     * El método se encarga de realizar el efecto que tiene la carta El Vendado
     * @param esbirro un objeto de tipo Esbirro
     */
    @Override
    public void action(Esbirros esbirro) {//Completo
        int mana_to_lose=25;
        int mana=getBoard().getPlayer().getMana();
        getBoard().getPlayer().setMana(mana-mana_to_lose);
    }
}
