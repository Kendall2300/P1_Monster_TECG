package TEC.Gui;

import TEC.Board.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * EsbirrosPanel
 * Esta clase se encarga de generar el panel donde se colocarán los botones de esbirros en el campo o tablero de juego
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class EsbirrosPanel extends JPanel {
    private ArrayList<EsbirrosButton> esbirros;

    /**
     * EsbirrosPanel
     * Este metodo constructor se encarga de genera el Panel de Esbirros para el jugador que sea introducido como parametro
     * @param p Un objeto tipo Player
     */
    public EsbirrosPanel(Player p){
        super();
        setPreferredSize(new Dimension(500,100));
        esbirros=new ArrayList<EsbirrosButton>();
        this.setLayout(new GridLayout(1,5));
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

    /**
     * getEsbirros
     * Este metodo obtiene un array de botones esbirro que están contenidos en el panel
     * @return Un array de EsbirrosButton
     */
    public ArrayList<EsbirrosButton> getEsbirros() {
        return esbirros;
    }

    /**
     * setEsbirros
     * Este metodo coloca los botones de esbirro en el panel de Esbirros
     * @param esbirros Un array de EsbirrosButton
     */
    public void setEsbirros(ArrayList<EsbirrosButton> esbirros) {
        this.esbirros = esbirros;
    }
}
