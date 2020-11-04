package TEC.Gui;

import javax.swing.*;
import java.awt.*;

public class NextPhaseButton extends JButton {
    public NextPhaseButton(String string) {
        super(string);
        this.setPreferredSize(new Dimension(214,53));
        ImageIcon ic=new ImageIcon("Imagenes/Np.png");
        this.setIcon(ic);
        this.setOpaque(false);
    }
}
