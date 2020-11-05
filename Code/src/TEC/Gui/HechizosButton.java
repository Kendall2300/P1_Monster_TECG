package TEC.Gui;

import TEC.Cartas.Hechizos.Hechizos;

import javax.swing.*;

public class HechizosButton extends JButton {
    private Hechizos hechizo;

    public Hechizos getHechizo(){
        return hechizo;
    }
    public void setHechizo(Hechizos hechizo) {
        this.hechizo = hechizo;
    }

    public HechizosButton(){
        super();
        this.setVisible(true);
    }
    public HechizosButton(Hechizos hechizo){
        this.setVisible(true);
        this.setName(hechizo.getName());
        this.setOpaque(false);
    }
    public HechizosButton(String name){
        super(name);
    }
}
