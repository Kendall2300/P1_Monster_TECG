package TEC.Gui;

import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Secretos.Secretos;

import javax.swing.*;

public class SecretosButton extends JButton {
    private Secretos secreto;

    public Secretos getSecreto(){
        return secreto;
    }

    public void setSecreto(Secretos secreto) {
        this.secreto = secreto;
    }
    public SecretosButton(){
        super();
        this.setVisible(true);
    }
    public SecretosButton(Hechizos secreto){
        this.setVisible(true);
        this.setName(secreto.getName());
        this.setOpaque(false);
    }
    public SecretosButton(String name){
        super(name);
    }
}
