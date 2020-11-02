package TEC.Gui;

import TEC.Cartas.Esbirros;

import javax.swing.*;

public class EsbirrosButton extends JButton {
    private Esbirros esbirro;
    public Esbirros getEsbirro(){
        return esbirro;
    }

    public void setEsbirro(Esbirros esbirro) {
        this.esbirro = esbirro;
    }
    public EsbirrosButton(){
        this.setVisible(true);
    }
    public EsbirrosButton(Esbirros esbirro){
        this.setVisible(true);
        this.setName(esbirro.getName());
    }
    public EsbirrosButton(String name){
        super(name);
    }
}
