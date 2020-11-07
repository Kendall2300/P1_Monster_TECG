package TEC.Gui;

import TEC.Board.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * HSPanel
 * Esta clase se encarga de generar el panel que será utilizado por los hechizos
 * y secretos en caso de querer colocarlos en el campo
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class HSPanel extends JPanel {
    private ArrayList<JButton> spells;
    private Player p;

    /**
     * HSPanel
     * Este metodo se encarga de construir o definir los parametros del panel de hechizos y secretos
     * en el campo de cada jugador que sea pasado como parametro
     * @param p Un objeto tipo Player
     */
    public HSPanel(Player p){
        super();
        setPreferredSize(new Dimension(500,100));
        update(p);
    }

    /**
     * setSpells
     * Este metodo se encarga de colocar un valor para el array de botones en la mano
     * @param spells Un array de tipo JButton
     */
    public void setSpells(ArrayList<JButton>spells){
        this.spells=spells;
    }

    /**
     * setSpells
     * Este metodo se encarga de obtener el valor del array de botones en el campo de hechizos
     * @return Un array de tipo JButton
     */
    public ArrayList<JButton> getSpells(){
        return spells;
    }

    /**
     * update
     * Este metodo se encarga de actualizar la el panel de hechizos del jugador que es pasado como parámetro
     * @param p Un objeto de tipo Player
     */
    private void update(Player p) {
        spells=new ArrayList<JButton>();
        this.setLayout(new GridLayout(1,5));
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
        for (int i=0;i<5-p.getField().getHechizosArea().size();i++){
            JButton but=new JButton();
            but.setOpaque(false);
            but.setOpaque(false);
            spells.add(but);
            this.add(but);
        }
    }
}
