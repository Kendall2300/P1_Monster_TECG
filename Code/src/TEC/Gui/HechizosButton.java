package TEC.Gui;

import TEC.Cartas.Hechizos.Hechizos;

import javax.swing.*;

/**
 * HechizosButton
 * Esta clase se encarga de construir los botones de hechizo y secreto que estrán en la mano del jugador
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class HechizosButton extends JButton {
    private Hechizos hechizo;

    /**
     * getHechizo
     * Este metodo obtiene el hechizo o secreto que será colocado en un botón
     * @return Un objeto de tipo Hechizos
     */
    public Hechizos getHechizo(){
        return hechizo;
    }
    public void setHechizo(Hechizos hechizo) {
        this.hechizo = hechizo;
    }

    /**
     * HechizosButton
     * Este metodo constructor se encarga de construir los botrones de hechizos y secretos,
     * así como de ponerlos visibles o invisibles
     */
    public HechizosButton(){
        super();
        this.setVisible(true);
    }

    /**
     * HechizosButton
     * Este metodo constructor se encarga de construir los botrones de hechizos y secretos,
     * así como de ponerlos visibles o invisibles y colocarle un nombre especifico al botón
     * @param hechizo Un objeto de tipo Hechizos
     */
    public HechizosButton(Hechizos hechizo){
        this.setVisible(true);
        this.setName(hechizo.getName());
        this.setOpaque(false);
    }

    /**
     * HechizosButton
     * Este metodo constructor se encarga de construir los botrones de hechizos y secretos,
     * así como de ponerle un nombre especifico al botón
     * @param name Un string que será el nombre del botón
     */
    public HechizosButton(String name){
        super(name);
    }
}
