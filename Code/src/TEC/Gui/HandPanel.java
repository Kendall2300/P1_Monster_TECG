package TEC.Gui;

import TEC.Board.Player.Player;
import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Secretos.Secretos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HandPanel extends JPanel {
    private ArrayList<EsbirrosButton> esbirrosButtons;
    private ArrayList<HechizosButton> hechizosButttons;
    private ArrayList<SecretosButton> secretosButtons;
    public HandPanel(Player p){
        super();
        update(p);
    }
    public ArrayList<EsbirrosButton> getHandButtons(){
        return this.esbirrosButtons;
    }
    public void setHandButtons(ArrayList<EsbirrosButton> hb){
        this.esbirrosButtons=hb;
    }
    public void update(Player p){
        this.removeAll();
        this.revalidate();
        esbirrosButtons=new ArrayList<EsbirrosButton>(20);
        hechizosButttons=new ArrayList<HechizosButton>(20);
        secretosButtons=new ArrayList<SecretosButton>(20);
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
        for(int i=0;i<20;i++){
            SecretosButton s=new SecretosButton();
            s.setVisible(false);
            this.add(s);
            secretosButtons.add(s);
        }
        for(int i=0;i<hand.size();i++){
            if(hand.get(i) instanceof Esbirros){
                esbirrosButtons.get(i).setEsbirro((Esbirros) hand.get(i));
                esbirrosButtons.get(i).setVisible(true);
                ImageIcon img=new ImageIcon("Imagenes/Esbirros"+hand.get(i).getName()+".png");
                Image img2=img.getImage();
                Image newimg=img2.getScaledInstance(100,146, Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(newimg);
                esbirrosButtons.get(i).setIcon(newIcon);
                esbirrosButtons.get(i).setPreferredSize(new Dimension(100,146));
                esbirrosButtons.get(i).revalidate();
                esbirrosButtons.get(i).setOpaque(false);
                esbirrosButtons.get(i).repaint();
            }else if(hand.get(i) instanceof Hechizos){
                hechizosButttons.get(i).setHechizo((Hechizos) hand.get(i));
                hechizosButttons.get(i).setVisible(true);
                ImageIcon img=new ImageIcon("Imagenes/Hechizos"+hand.get(i).getName()+".png");
                Image img2=img.getImage();
                Image newimg=img2.getScaledInstance(100,146, Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(newimg);
                hechizosButttons.get(i).setIcon(newIcon);
                hechizosButttons.get(i).setPreferredSize(new Dimension(100,146));
                hechizosButttons.get(i).revalidate();
                hechizosButttons.get(i).setOpaque(false);
                hechizosButttons.get(i).repaint();
            }else{
                secretosButtons.get(i).setSecreto((Secretos)hand.get(i));
                secretosButtons.get(i).setVisible(true);
                ImageIcon img=new ImageIcon("Imagenes/Secretos"+hand.get(i).getName()+".png");
                Image img2=img.getImage();
                Image newimg=img2.getScaledInstance(100,146, Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(newimg);
                secretosButtons.get(i).setIcon(newIcon);
                secretosButtons.get(i).setPreferredSize(new Dimension(100,146));
                secretosButtons.get(i).revalidate();
                secretosButtons.get(i).setOpaque(false);
                secretosButtons.get(i).repaint();
            }
        }
    }

    public ArrayList<EsbirrosButton> getEsbirrosButtons() {
        return esbirrosButtons;
    }

    public void setEsbirrosButtons(ArrayList<EsbirrosButton> esbirrosButtons) {
        this.esbirrosButtons = esbirrosButtons;
    }

    public ArrayList<HechizosButton> getHechizosButttons() {
        return hechizosButttons;
    }

    public void setHechizosButttons(ArrayList<HechizosButton> hechizosButttons) {
        this.hechizosButttons = hechizosButttons;
    }

    public ArrayList<SecretosButton> getSecretosButtons() {
        return secretosButtons;
    }

    public void setSecretosButtons(ArrayList<SecretosButton> secretosButtons) {
        this.secretosButtons = secretosButtons;
    }
}
