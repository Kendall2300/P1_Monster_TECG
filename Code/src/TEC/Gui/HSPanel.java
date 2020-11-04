package TEC.Gui;

import TEC.Board.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HSPanel extends JPanel {
    private ArrayList<JButton> spells;
    private Player p;

    public HSPanel(Player p){
        super();
        setPreferredSize(new Dimension(500,100));
        update(p);
    }
    public void setSpells(ArrayList<JButton>spells){
        this.spells=spells;
    }
    public ArrayList<JButton> getSpells(){
        return spells;
    }
    private void update(Player p) {
        spells=new ArrayList<JButton>();
        this.setLayout(new GridLayout(1,2));
        this.setOpaque(false);
        this.setVisible(true);
        for (int i=0;i<p.getField().getHechizosArea().size();i++){
            if(p.getField().getHechizosArea().get(i)!=null){
                HechizosButton hechizosButton=new HechizosButton();
                ImageIcon img = new ImageIcon("src/Imagenes/Card Back.png");
                Image img2=img.getImage();
                Image newimg=img2.getScaledInstance(91,62, Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(newimg);
                hechizosButton.setIcon(newIcon);
                hechizosButton.setHechizo(p.getField().getHechizosArea().get(i));
                hechizosButton.setOpaque(false);
                spells.add(hechizosButton);
                this.add(hechizosButton);
            }
        }
        for (int i=0;i<2-p.getField().getHechizosArea().size();i++){
            JButton but=new JButton();
            but.setOpaque(false);
            but.setOpaque(false);
            spells.add(but);
            this.add(but);
        }
    }
}
