package TEC.Gui;

import javax.swing.*;

/**
 * CardButton
 * Esta clase se encarga de establecer los parametros que poseerá el boton carta que se encontrará en el campo de juego
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class CardButton extends JButton {
    /**
     * CardButton
     * Este es el metodo constructor que le pone un nombre al boton.
     * @param name Un string que será el nombre del botón
     */
    public CardButton(String name){
        super(name);
    }

    /**
     * Este metodo constructor genera al boton con los parametros de su super clase
     */
    public CardButton() {
        super();
    }

}
