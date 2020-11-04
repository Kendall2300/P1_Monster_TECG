package TEC.Gui;

import TEC.Board.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EsbirrosPanel extends JPanel {
    private ArrayList<EsbirrosButton> esbirros;

    public EsbirrosPanel(Player p){
        super();
        setPreferredSize(new Dimension(500,100));
        esbirros=new ArrayList<EsbirrosButton>();
        this.setLayout(new GridLayout(1,3));
        this.setOpaque(true);
        this.setVisible(true);
        for (int i=0;i<5;i++){
            EsbirrosButton esbirrosButton=new EsbirrosButton();
            esbirros.add(esbirrosButton);
            esbirrosButton.setBackground(Color.GRAY);
            esbirrosButton.setOpaque(false);
            this.add(esbirrosButton);
        }
        for (int i=0;i<p.getField().getEsbirrosArea().size();i++){
            esbirros.get(i).setEsbirro(p.getField().getEsbirrosArea().get(i));
            esbirros.get(i).setVisible(true);
            ImageIcon newIcon;
            ImageIcon img=new ImageIcon("src/Imagenes/Esbirros/"+p.getField().getEsbirrosArea().get(i).getName()+".png");
            Image img2= img.getImage();
            Image newimg=img2.getScaledInstance(62,91, Image.SCALE_SMOOTH);
            newIcon=new ImageIcon(newimg);

            esbirros.get(i).setIcon(newIcon);
            esbirros.get(i).setPreferredSize(new Dimension(62,91));
            esbirros.get(i).revalidate();
            esbirros.get(i).setOpaque(false);
            esbirros.get(i).repaint();
        }
    }

    public ArrayList<EsbirrosButton> getEsbirros() {
        return esbirros;
    }

    public void setEsbirros(ArrayList<EsbirrosButton> esbirros) {
        this.esbirros = esbirros;
    }
}
