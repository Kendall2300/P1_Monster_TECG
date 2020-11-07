package TEC.Gui;

import TEC.Board.Player.Player;
import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * HandPanel
 * Esta clase se encarga de construir el panel donde
 * serán colocados los botones de las cartas que un jugador posee en mano
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class HandPanel extends JPanel {
    private ArrayList<EsbirrosButton> esbirrosButtons;
    private ArrayList<HechizosButton> hechizosButttons;

    /**
     * HandPanel
     * Este metodo se encarga de construir el panel de la mano para un jugador que es pasado como parametro
     * @param p Un objeto de tipo Player
     */
    public HandPanel(Player p){
        super();
        update(p);
    }

    /**
     * getHandButtons
     * Este metodo se encarga de obtener el array de botones de esbirro que el jugador posee en la mano
     * @return  Un array de EsbirrosButton
     */
    public ArrayList<EsbirrosButton> getHandButtons(){
        return this.esbirrosButtons;
    }

    /**
     * setHandButtons
     * Este metodo se encarga de colocar el array de botones de esbirros en el panel de la mano del jugador
     * @param hb Un array de EsbirrosButton
     */
    public void setHandButtons(ArrayList<EsbirrosButton> hb){
        this.esbirrosButtons=hb;
    }

    /**
     * update
     * Este metodo se encarga de actualizar la mano del jugador que es pasado como parámetro
     * @param p Un objeto de tipo Player
     */
    public void update(Player p){
        this.removeAll();
        this.revalidate();
        esbirrosButtons=new ArrayList<EsbirrosButton>(20);
        hechizosButttons=new ArrayList<HechizosButton>(20);

        ArrayList<Carta> hand=p.getField().getHand();
        this.setLayout(new FlowLayout());
        this.setOpaque(false);

        for (int i=0;i<20;i++){
            EsbirrosButton b=new EsbirrosButton();
            b.setVisible(false);
            this.add(b);
            esbirrosButtons.add(b);
        }
        for(int i=0;i<20;i++){
            HechizosButton h=new HechizosButton();
            h.setVisible(false);
            this.add(h);
            hechizosButttons.add(h);
        }
        for(int i=0;i<hand.size();i++){
            if(hand.get(i) instanceof Esbirros){
                esbirrosButtons.get(i).setEsbirro((Esbirros) hand.get(i));
                esbirrosButtons.get(i).setVisible(true);
                ImageIcon img=new ImageIcon("src/Imagenes/Esbirros/"+hand.get(i).getName()+".png");
                Image img2=img.getImage();
                Image newimg=img2.getScaledInstance(100,146, Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(newimg);
                esbirrosButtons.get(i).setIcon(newIcon);
                esbirrosButtons.get(i).setPreferredSize(new Dimension(100,146));
                esbirrosButtons.get(i).revalidate();
                esbirrosButtons.get(i).setOpaque(false);
                esbirrosButtons.get(i).repaint();
            }else{
                hechizosButttons.get(i).setHechizo((Hechizos) hand.get(i));
                hechizosButttons.get(i).setVisible(true);
                ImageIcon img=new ImageIcon("src/Imagenes/Hechizos/"+hand.get(i).getName()+".png");
                Image img2=img.getImage();
                Image newimg=img2.getScaledInstance(100,146, Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(newimg);
                hechizosButttons.get(i).setIcon(newIcon);
                hechizosButttons.get(i).setPreferredSize(new Dimension(100,146));
                hechizosButttons.get(i).revalidate();
                hechizosButttons.get(i).setOpaque(false);
                hechizosButttons.get(i).repaint();
            }
        }
    }

    /**
     * getEsbirrosButtons
     * Este metodo se encarga de obtner los botones esbirros que están en el panel de la mano del jugador
     * @return Un array de EsbirrosButtons
     */
    public ArrayList<EsbirrosButton> getEsbirrosButtons() {
        return esbirrosButtons;
    }

    /**
     * setEsbirrosButtons
     * Este metodo se encarga de colocar o definir los botones esbirros que estarán en el panel de la mano del jugador
     * @param esbirrosButtons Un array de EsbirrosButton
     */
    public void setEsbirrosButtons(ArrayList<EsbirrosButton> esbirrosButtons) {
        this.esbirrosButtons = esbirrosButtons;
    }

    /**
     * getHechizosButtons
     * Este metodo se encarga de obtner los botones de hechizos y secretos que están en el panel de la mano del jugador
     * @return Un array de tipo HechizosButton
     */
    public ArrayList<HechizosButton> getHechizosButttons() {
        return hechizosButttons;
    }

    /**
     * setHechizosButtons
     * Este metodo se encarga de colocar o definir los valores de los botones hechizos y secretos que están
     * en el panel de la mano del jugador
     * @param hechizosButttons Un array de HechizosButton
     */
    public void setHechizosButttons(ArrayList<HechizosButton> hechizosButttons) {
        this.hechizosButttons = hechizosButttons;
    }
}
