package TEC.Gui;

import TEC.Board.Player.Player;
import TEC.Cartas.Carta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * HiddenHandPanel
 * Este metodo se encarga de controlar el panel del jugador que se encontrará en oculto ante el jugador contrario
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class HiddenHandPanel extends JPanel {
    private ArrayList<CardButton> handButtons;

    /**
     * HiddenHandPanel
     * Este metodo constructor definirá y actualizará el panel del jugador que se encuentra oculto
     * @param p Un objeto tipo Player
     */
    public HiddenHandPanel(Player p){
        super();
        update(p);
    }

    /**
     * getHandButtons
     * Este metodo se encarga de obtener los valores de los botones que se encuentran en la mano
     * @return Un array de tipo CardButton
     */
    public ArrayList<CardButton>getHandButtons(){
        return this.handButtons;
    }

    /**
     * setHandButtons
     * Este metodo se encarga de definir los valores de los botones que se encuentran en la mano
     * @param hb Un array de tipo CardButton
     */
    public void setHandButtons(ArrayList<CardButton>hb){
        this.handButtons=hb;
    }

    /**
     * update
     * Este metodo se encarga de actualizar la mano del jugador que es pasado como parámetro para ponerla en invisible
     * @param p Un objeto de tipo Player
     */
    public void update(Player p){
        this.removeAll();
        this.revalidate();
        handButtons=new ArrayList<CardButton>(20);
        this.setOpaque(false);
        ArrayList<Carta> hand = p.getField().getHand();
        this.setLayout(new FlowLayout());

        ImageIcon img=new ImageIcon("src/Imagenes/Card Back.png");
        Image img2=img.getImage();
        Image newimg=img2.getScaledInstance(100,146, Image.SCALE_SMOOTH);
        ImageIcon newIcon= new ImageIcon(newimg);

        for(int i=0;i<20;i++){
            CardButton b=new CardButton();
            b.setIcon(newIcon);
            b.setPreferredSize(new Dimension(100,146));
            handButtons.add(b);
            this.add(b);
            b.setVisible(false);
        }
        for(int i=0; i<hand.size();i++){
            handButtons.get(i).setVisible(true);
        }
    }
}
