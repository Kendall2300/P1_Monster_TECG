package TEC.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * EndTurnButton
 * Esta clase se encargará de construir y generar el boton para terminar el turno del jugador
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class EndTurnButton extends JButton {
    /**
     * EndTurnButton
     * Este metodo constructor define los valores y la imagen que poseera el botón para terminar el turno
     * @param string Un string que será el nombre del botón
     */
    public EndTurnButton(String string){
        super(string);
        this.setPreferredSize(new Dimension(214,53));
        ImageIcon ic=new ImageIcon("src/Imagenes/ET.png");
        this.setIcon(ic);
        this.setOpaque(false);
        this.repaint();
        this.revalidate();
    }
}
