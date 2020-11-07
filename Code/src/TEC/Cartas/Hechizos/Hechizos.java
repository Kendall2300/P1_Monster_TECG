package TEC.Cartas.Hechizos;

import TEC.Cartas.Carta;


/**
 * Hechizos
 * Esta clase herada los metodos de Carta y será la encargada de construir a todos los Hechizos y Secretos
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public abstract class Hechizos extends Carta {

    /**
     * Hechizos
     * El metodo constructor que coloca los valores para los Hechizos y Secretos que se construirán
     * @param name Un string que será el nombre del Esbirro
     * @param mana_Cost Un entro que será el costo de jugar la carta
     */
    public Hechizos(String name, int mana_Cost) {
        super(name, mana_Cost);
    }
}
