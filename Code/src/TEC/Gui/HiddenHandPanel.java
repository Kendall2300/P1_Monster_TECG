package TEC.Gui;

import TEC.Board.Player.Player;
import TEC.Cartas.Carta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HiddenHandPanel extends JPanel {
    private ArrayList<CardButton> handButtons;
    public HiddenHandPanel(Player p){
        super();
        update(p);
    }
    public ArrayList<CardButton>getHandButtons(){
        return this.handButtons;
    }
    public void setHandButtons(ArrayList<CardButton>hb){
        this.handButtons=hb;
    }
    public void update(Player p){
        this.removeAll();
        this.revalidate();
        handButtons=new ArrayList<CardButton>(20);
        this.setOpaque(false);
        ArrayList<Carta> hand=p.getField().getHand();
        this.setLayout(new FlowLayout());

        ImageIcon img=new ImageIcon("");
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
