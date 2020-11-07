package TEC.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * NextPhaseButton
 * Esta clase se encarga de definir los parametros y la forma del botón para terminar la fase actual de un jugador
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class NextPhaseButton extends JButton {
    /**
     * NextPhaseButton
     * Este metodo constructor genera y define los parámetros que tendrá el boton para terminar la fase
     * @param string Un string que sera el nombre que saldrá en el Botón
     */
    public NextPhaseButton(String string) {
        super(string);
        this.setPreferredSize(new Dimension(214,53));
        ImageIcon ic=new ImageIcon("src/Imagenes/Np.png");
        this.setIcon(ic);
        this.setOpaque(false);
    }
}
