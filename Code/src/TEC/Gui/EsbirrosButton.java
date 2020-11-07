package TEC.Gui;

import TEC.Cartas.Esbirros;

import javax.swing.*;

/**
 * EsbirrosButton
 * Clase que se encargará de definir los paramaetros de los botones de esbirros
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class EsbirrosButton extends JButton {
    private Esbirros esbirro;

    /**
     * getEsbirro
     * Este método obtiene el valor del esbirro asociado al boton
     * @return Un objeto tipo Esbirros
     */
    public Esbirros getEsbirro(){
        return esbirro;
    }

    /**
     * setEsbirro
     * Este método se encarga de colocar el valor Esbirros del botón correspondiente
     * @param esbirro Un objeto tipo Esbirros
     */
    public void setEsbirro(Esbirros esbirro) {
        this.esbirro = esbirro;
    }

    /**
     * EsbirrosButton
     * Este método constructor genera o construye al botón esbirro,
     * tambien se encarga de definir si se va a encontrar visible al otro jugador
     */
    public EsbirrosButton(){
        this.setVisible(true);
    }

    /**
     * EsbirrosButton
     * Este método constructor genera o construye al botón esbirro,
     * lo coloca en visible, obtiene el nombre del esbirro y lo coloca en el botón
     * @param esbirro Un objeto de tipo Esbirros
     */
    public EsbirrosButton(Esbirros esbirro){
        this.setVisible(true);
        this.setName(esbirro.getName());
    }

    /**
     * EsbirrosButton
     * Este método constructor genera o construye al botón esbirro, solo con un nombre especifico
     * @param name Un string que será el nombre del botón.
     */
    public EsbirrosButton(String name){
        super(name);
    }
}
