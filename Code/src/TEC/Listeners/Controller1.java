package TEC.Listeners;

import TEC.Board.Board;
import TEC.Board.Player.ListaDoble.LinkedList;
import TEC.Board.Player.Phase;
import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Location;
import TEC.Exceptions.*;
import TEC.Gui.*;
import TEC.Board.Player.ListaDoble.Node.*;

import javax.imageio.IIOException;
import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller1
 * Esta clase se encarga de generar hilos y escuchar ante cualquier acción que suceda durante la ejecucuón del juego.
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class Controller1 implements ActionListener, MouseListener {
    private JButton fc;
    private JButton sc;
    private JButton tc;
    private Board board;
    private Gui gui;
    private int summon;
    String x = "Historial de Jugadas";


    /**
     * Controller1
     * Este metodo constructor  llama a otros metodos de la misma clase para intentar fucionar como un listener
     * @param board Un objeto tipo Board que será el tablero de juego
     * @param gui Un objeto de tipo Gui que será la gui del juego
     */
    public Controller1(Board board, Gui gui) {
        this.board = board;
        this.gui = gui;
        addActionListeners();
        gui.getEndturn().addActionListener(this);
        gui.getNextphase().addActionListener(this);
    }

    /**
     * addActionListeners
     * Esta clase implementa el action listener que hace o permite que la
     * clase esté al pendiente de todas las acciones durante la ejecución del juego
     */
    public void addActionListeners() {
        ArrayList<EsbirrosButton> handp1 = this.gui.getHandp1().getEsbirrosButtons();
        ArrayList<EsbirrosButton> handp2 = this.gui.getHandp2().getEsbirrosButtons();
        ArrayList<HechizosButton> handp1spells = this.gui.getHandp1().getHechizosButttons();
        ArrayList<HechizosButton> handp2spells = this.gui.getHandp2().getHechizosButttons();
        ArrayList<EsbirrosButton> monstersp1 = this.gui.getMonsterareap1().getEsbirros();
        ArrayList<JButton> spellsp1 = this.gui.getSpellAreap1().getSpells();
        ArrayList<EsbirrosButton> monstersp2 = this.gui.getMonsterAreap2().getEsbirros();
        ArrayList<JButton> spellsp2 = this.gui.getSpellAreap2().getSpells();
        ArrayList<CardButton> hidp1 = this.gui.getP1hid().getHandButtons();
        ArrayList<CardButton> hidp2 = this.gui.getP2hid().getHandButtons();
        for (int i = 0; i < hidp1.size(); i++) {
            hidp1.get(i).addActionListener(this);
            hidp1.get(i).addMouseListener(this);
        }
        for (int i = 0; i < hidp2.size(); i++) {
            hidp2.get(i).addActionListener(this);
            hidp2.get(i).addMouseListener(this);
        }
        for (int i = 0; i < handp1.size(); i++) {
            handp1.get(i).addActionListener(this);
            handp1.get(i).addMouseListener(this);
        }
        for (int i = 0; i < handp2.size(); i++) {
            handp2.get(i).addActionListener(this);
            handp2.get(i).addMouseListener(this);
        }
        for (int i = 0; i < handp1spells.size(); i++) {
            handp1spells.get(i).addActionListener(this);
            handp1spells.get(i).addMouseListener(this);
        }
        for (int i = 0; i < handp2spells.size(); i++) {
            handp2spells.get(i).addActionListener(this);
            handp2spells.get(i).addMouseListener(this);
        }
        for (int i = 0; i < monstersp1.size(); i++) {
            monstersp1.get(i).addActionListener(this);
            monstersp1.get(i).addMouseListener(this);
        }
        for (int i = 0; i < spellsp1.size(); i++) {
            spellsp1.get(i).addActionListener(this);
            spellsp1.get(i).addMouseListener(this);
        }
        for (int i = 0; i < monstersp2.size(); i++) {
            monstersp2.get(i).addActionListener(this);
            monstersp2.get(i).addMouseListener(this);
        }
        for (int i = 0; i < spellsp2.size(); i++) {
            spellsp2.get(i).addActionListener(this);
            spellsp2.get(i).addMouseListener(this);
        }
    }

    /**
     * mouseClicked
     * Este metodo revisa constantemente si el mouse ha clickeado alguna instancia
     * que esté siendo escuchado por esta clase
     * @param e Un objeto de tipo MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * mouseEntered
     * Este metodo revisa constantemente si el mouse entra en contacto con alguna instancia
     * del juego de la cual está pendiente la clase
     * @param e Un objeto de tipo MouseEvenet
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof EsbirrosButton) {
            EsbirrosButton b = (EsbirrosButton) e.getSource();
            Esbirros c = b.getEsbirro();
            if (c != null) {
                String url = "src/Imagenes/Esbirros/" + c.getName() + ".png";

                ImageIcon img = new ImageIcon(url);
                gui.getDescription().setIcon(img);
                gui.getDescription().revalidate();
                gui.revalidate();
            }
        }
        if (e.getSource() instanceof HechizosButton) {
            HechizosButton b = (HechizosButton) e.getSource();
            Hechizos c = b.getHechizo();
            if (c != null) {
                String url = "src/Imagenes/Hechizos/" + c.getName() + ".png";

                ImageIcon img = new ImageIcon(url);
                gui.getDescription().setIcon(img);
                gui.getDescription().revalidate();
                gui.revalidate();
            }
        }
        if (e.getSource() instanceof CardButton) {
            ImageIcon img = new ImageIcon("src/Imagenes/Card Back.png");
            gui.getDescription().setIcon(img);
            gui.getDescription().revalidate();
            gui.revalidate();
        }
    }

    /**
     * mouseExited
     * Este metodo esta atento si el mouse ha dejado de estar en contacto con alguna
     * instancia de la cual la clase está pendiente
     * @param e Un objeto de tipo MouseEvent
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * mousePressed
     * Este metodo esta atento si el mouse ha presionado alguna
     * instancia de la cual la clase está pendiente
     * @param e Un objeto de tipo MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * mouseReleased
     * Este metodo esta atento si el mouse ha liberado alguna
     * instancia de la cual la clase está pendiente
     * @param e Un objeto de tipo MouseEvent
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * updatefield
     * Este metodo se encarga de actualizar el campo de los jugadores despues de cada acción
     * tambien contiene opciones para después de terminar la partida y reiniciar el tablero
     * para jugar otra partida sin cerrar la conección con el servidor.
     */
    private void updatefield() {
        if (board.isGameOver()) {
            Object[] options = {"End Game!", "Start New Game"};
            int choice = JOptionPane.showOptionDialog(gui, "Game Finished, The winner is " + board.getWinner().getName() + "", null, JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                System.exit(0);
            } else {
                try {
                    Gui.main(null);
                    gui.setVisible(false);
                } catch (UnexpectedFormatException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
        gui.getDeckp1().setText("" + gui.getP1().getField().getDeck().getDeck().size());
        gui.getDeckp2().setText("" + gui.getP2().getField().getDeck().getDeck().size());
        gui.getLifep1().setText("Life Points: " + gui.getP1().getLifePoints()+"\nMana:"+gui.getP1().getMana());
        gui.getLifep2().setText("Life Points: " + gui.getP2().getLifePoints()+"\nMana:"+gui.getP2().getMana());
        gui.getCurrphase().setText(Carta.getBoard().getPlayer().getField().getPhase().name());
        if (gui.getP1() == board.getPlayer()) {
            gui.getSp1().remove(gui.getP1hid());
            gui.getSp1().remove(gui.getHandp1());
            gui.getPanel1().remove(gui.getSp1());
            gui.setHandp1(new HandPanel(gui.getP1()));
            JScrollPane sp1 = new JScrollPane(gui.getHandp1());
            sp1.setPreferredSize(new Dimension(500, 150));
            sp1.setBorder(null);
            sp1.getViewport().setOpaque(false);
            sp1.setOpaque(false);
            sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            gui.setSp1(sp1);
            gui.getPanel1().add(gui.getSp1(), BorderLayout.SOUTH);
            gui.revalidate();
        } else {
            gui.getSp1().remove(gui.getP1hid());
            gui.getSp1().remove(gui.getHandp1());
            gui.getPanel1().remove(gui.getSp1());
            gui.setP1hid(new HiddenHandPanel(gui.getP1()));
            JScrollPane sp1 = new JScrollPane(gui.getP1hid());
            sp1.setBorder(null);
            sp1.getViewport().setOpaque(false);
            sp1.setPreferredSize(new Dimension(500, 150));
            sp1.setOpaque(false);
            sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            gui.setSp1(sp1);
            gui.getPanel1().add(gui.getSp1(), BorderLayout.SOUTH);
            gui.revalidate();
        }
        if (gui.getP2() == board.getPlayer()) {
            gui.getSp2().remove(gui.getP2hid());
            gui.getSp2().remove(gui.getHandp2());
            gui.getPanel2().remove(gui.getSp2());
            gui.setHandp2(new HandPanel(gui.getP2()));
            JScrollPane sp2 = new JScrollPane(gui.getHandp2());
            sp2.setBorder(null);
            sp2.getViewport().setOpaque(false);
            sp2.setPreferredSize(new Dimension(500, 150));
            sp2.setOpaque(false);
            sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            gui.setSp2(sp2);
            gui.getPanel2().add(gui.getSp2(), BorderLayout.NORTH);
            gui.revalidate();
        } else {
            gui.getSp2().remove(gui.getP2hid());
            gui.getSp2().remove(gui.getHandp2());
            gui.getPanel2().remove(gui.getSp2());
            gui.setP2hid(new HiddenHandPanel(gui.getP2()));
            JScrollPane sp2 = new JScrollPane(gui.getP2hid());
            sp2.setBorder(null);
            sp2.getViewport().setOpaque(false);
            sp2.setPreferredSize(new Dimension(500, 150));
            sp2.setOpaque(false);
            sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            gui.setSp2(sp2);
            gui.getPanel2().add(gui.getSp2(), BorderLayout.NORTH);
            gui.revalidate();
        }
        gui.getPanel1().remove(gui.getMonsterareap1());
        gui.setMonsterareap1(new EsbirrosPanel(gui.getP1()));
        gui.getPanel1().add(gui.getMonsterareap1(), BorderLayout.NORTH);

        gui.getPanel2().remove(gui.getMonsterAreap2());
        gui.setMonsterAreap2(new EsbirrosPanel(gui.getP2()));
        gui.getPanel2().add(gui.getMonsterAreap2(), BorderLayout.SOUTH);

        gui.getPanel1().remove(gui.getSpellAreap1());
        gui.setSpellAreap1(new HSPanel(gui.getP1()));
        gui.getPanel1().add(gui.getSpellAreap1(), BorderLayout.CENTER);

        gui.getPanel2().remove(gui.getSpellAreap2());
        gui.setSpellAreap2(new HSPanel(gui.getP2()));
        gui.getPanel2().add(gui.getSpellAreap2(), BorderLayout.CENTER);

        if (gui.getP1().getField().getGraveyard().size() > 0) {
            String url;
            if (gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1) instanceof Esbirros) {
                url = "src/Imagenes/Esbirros/" + gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1).getName() + ".png";
            } else {
                url = "src/Imagenes/Hechizos/" + gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1).getName() + ".png";
            }
            ImageIcon img = new ImageIcon(url);
            Image img2 = img.getImage();
            Image newimg = img2.getScaledInstance(62, 91, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            gui.getGravep1().setIcon(newIcon);
        }
        if (gui.getP2().getField().getGraveyard().size() > 0) {
            String url;
            if (gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1) instanceof Esbirros) {
                url = "src/Imagenes/Esbirros/" + gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1).getName() + ".png";
            } else {
                url = "src/Imagenes/Hechizos/" + gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1).getName() + ".png";
            }
            ImageIcon img = new ImageIcon(url);
            Image img2 = img.getImage();
            Image newimg = img2.getScaledInstance(62, 91, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            gui.getGravep2().setIcon(newIcon);
        }
        addActionListeners();
        gui.revalidate();
    }

    /**
     * actionPerformed
     * Esta clase revisa si alguno de todos los eventos ocurridos tiene que seguir de
     * algún tipo de lógica para realizar acciones. De ser así esta clase aplica la accion
     * que sea necesaria según su definiciones
     * @param e Un objeto de tipo MouseEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof NextPhaseButton) {
            board.getPlayer().endPhase();
            gui.getCurrphase().setText("Current Phase: " + Carta.getBoard().getPlayer().getField().getPhase());
            updatefield();
        }
        if (e.getSource() instanceof EndTurnButton) {
            int actual_mana=board.getPlayer().getMana();
            //int mana_to_win=250;

            if (actual_mana+250 >= 1000){
                board.getPlayer().setMana(1000);
            }else{
                board.getPlayer().setMana(actual_mana+250);
            }
            board.getPlayer().endTurn();
            updatefield();

        }
        if (e.getSource() instanceof EsbirrosButton) {
            try {
                if (fc == null) {

                    Esbirros monster = ((EsbirrosButton) e.getSource()).getEsbirro();
                    //fc=button;

                    if (monster.getLocation() == Location.Hand) {
                        fc = (EsbirrosButton) e.getSource();
                        monster = ((EsbirrosButton) fc).getEsbirro();
                        //fc=button;
                        Object[] options = {"Summon", "Cancel"};
                        summon = JOptionPane.showOptionDialog(gui, "Summon?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                        if (summon == 1) {
                            fc = null;
                            return;
                        }
                        if(monster.getMana_cost() <= Carta.getBoard().getPlayer().getMana()){
                            if (summon==0){

                                gui.getHistorial().setText("<html>"+ board.getPlayer().getName() + "<br>" + " ha jugado: " + monster.getName()+"<html>");


                                int mana_to_lose = monster.getMana_cost();
                                int actual_mana = Carta.getBoard().getPlayer().getMana();
                                Carta.getBoard().getPlayer().summonEsbirro(monster);
                                Carta.getBoard().getPlayer().setMana(actual_mana - mana_to_lose);
                                fc=null;
                                updatefield();
                                return;
                            }
                        }
                    }else{
                        if (board.getPlayer().getField().getPhase()!=Phase.Battle){
                            fc=null;
                            sc=null;
                            tc=null;
                            updatefield();
                        }else{
                            if (board.getPlayer().getField().getPhase() == Phase.Battle) {
                                fc = (EsbirrosButton) e.getSource();
                                monster = ((EsbirrosButton) fc).getEsbirro();
                                Object[] options2 = {"Ok", "Cancel"};
                                int y = JOptionPane.showOptionDialog(gui, "Atacar?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[1]);
                                if (y == 1) {
                                    fc = null;
                                    sc = null;
                                    tc = null;


                                    return;
                                }
                                if (board.getOpponentPlayer().getField().getEsbirrosArea().size() == 0) {
                                    gui.getHistorial().setText("<html>"+ board.getPlayer().getName() + "<br>" + " atacó con: " + monster.getName()+"<html>");
                                    board.getPlayer().declareAttack(((EsbirrosButton)fc).getEsbirro());
                                    fc = null;

                                    updatefield();
                                    return;
                                }
                                JOptionPane.showMessageDialog(gui, "Escoge al esbirro a atacar");
                                return;
                            }
                        }
                    }
                }else{
                    if(sc==null){
                        if (fc instanceof EsbirrosButton){
                            Esbirros monster=((EsbirrosButton)e.getSource()).getEsbirro();
                            if (board.getPlayer().getField().getPhase()!= Phase.Battle && !board.getPlayer().getField().getEsbirrosArea().contains(monster)){
                                JOptionPane.showMessageDialog(gui,"Debes escoger cartas de esbirros en tu campo");
                                fc=null;
                                sc=null;
                                return;
                            }
                            if(board.getPlayer().getField().getPhase()==Phase.Battle){
                                sc=(EsbirrosButton)e.getSource();
                                monster = ((EsbirrosButton)sc).getEsbirro();
                                board.getPlayer().declareAttack(((EsbirrosButton)fc).getEsbirro(),((EsbirrosButton)sc).getEsbirro());
                                fc=null;
                                sc=null;
                                tc=null;
                                gui.getHistorial().setText("<html>"+ board.getPlayer().getName() + "<br>" + " Atacó con: " + monster.getName()+"<html>");
                                updatefield();
                                return;
                            }
                        }
                    }

                }
            } catch (HeadlessException headlessException) {
                fc=null;
                sc=null;
                tc=null;
                headlessException.printStackTrace();
                System.out.println("Error head");
            } catch (NoEsbirrosSpaceException noEsbirrosSpaceException) {
                fc=null;
                sc=null;
                tc=null;
                noEsbirrosSpaceException.printStackTrace();
                System.out.println("Error space");
            } catch (WrongPhaseException | EsbirrosMultipleAttackException wrongPhaseException) {
                fc=null;
                sc=null;
                tc=null;
                wrongPhaseException.printStackTrace();
                System.out.println("Error mal fase");
            }
        }
        if(e.getSource() instanceof HechizosButton){
            //fc is spellbutton
            if(fc instanceof EsbirrosButton){
                fc=null;
                sc=null;
                return;
            }
            if(fc==null){
                if(board.getPlayer().getField().getHechizosArea().contains(((HechizosButton)e.getSource()).getHechizo())
                        || board.getPlayer().getField().getHand().contains(((HechizosButton)e.getSource()).getHechizo())){
                    if(((HechizosButton)e.getSource()).getHechizo().getLocation()==Location.Hand) {
                        int mana_actual=board.getPlayer().getMana();
                        String[] buttons = {"Activate", "Set", "Cancel"};
                        int rc = JOptionPane.showOptionDialog(null, "Activate or set spell ?", "SpellCard",
                                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);
                        HechizosButton button = (HechizosButton) e.getSource();
                        Hechizos card = button.getHechizo();
                        fc = button;
                        if (rc == 1 && (mana_actual>= card.getMana_cost())) {
                            gui.getHistorial().setText("<html>"+ board.getPlayer().getName() + "<br>" + " colocó: " + card.getName()+"<html>");
                            try {
                                Carta.getBoard().getPlayer().setHechizo(card);
                            } catch (WrongPhaseException wrongPhaseException) {
                                wrongPhaseException.printStackTrace();
                            } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                noHechizosSpaceException.printStackTrace();
                            }
                            fc = null;
                            updatefield();
                            return;
                        }
                        if (rc==2){
                            fc=null;
                            return;
                        }else {
                            gui.getHistorial().setText("<html>"+ board.getPlayer().getName() + "<br>" + " activó: " + card.getName()+"<html>");
                            int mana_to_loose= card.getMana_cost();
                            board.getPlayer().setMana(mana_actual-mana_to_loose);
                            switch (card.getName()){
                                case "Aguante":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "ChocoMilk":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "CilindrosMagicos":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Congelar":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Curar":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Desmadre":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "DonDuende":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "El_Gran_Keto":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "ElLoco":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "ElVendado":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "FrioPolar":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "HerramientasBrayan":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Joker":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "LlamadaImpura":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "NegarTurno":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "PoderSupremo":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "RobarOponente":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "RoboMagico":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "SoloPostres":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                            }
                        }
                    }
                    else {
                        int mana_actual=board.getPlayer().getMana();
                        String[] buttons={"ok","cancel"};
                        int rc=JOptionPane.showOptionDialog(null, "Activate spell card ?", "SpellCard",
                                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
                        HechizosButton button=(HechizosButton)e.getSource();
                        Hechizos card=button.getHechizo();
                        if (rc==1&& mana_actual>= card.getMana_cost()){
                            gui.getHistorial().setText("<html>"+ board.getPlayer().getName() + "<br>" + " ha activado: " + card.getName()+"<html>");
                            try {
                                Carta.getBoard().getPlayer().setHechizo(card);
                            } catch (WrongPhaseException wrongPhaseException) {
                                wrongPhaseException.printStackTrace();
                            } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                noHechizosSpaceException.printStackTrace();
                            }
                            int mana_to_loose= card.getMana_cost();
                            board.getPlayer().setMana(mana_actual-mana_to_loose);
                            fc=null;
                            updatefield();
                            return;
                        }else if(mana_actual >= card.getMana_cost()){
                            int mana_to_loose= card.getMana_cost();
                            board.getPlayer().setMana(mana_actual-mana_to_loose);
                            switch (card.getName()){
                                case "Aguante":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "ChocoMilk":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    board.getPlayer().setMana(mana_actual-mana_to_loose);
                                    updatefield();
                                    fc=null;
                                    return;
                                case "CilindrosMagicos":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Congelar":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Curar":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Desmadre":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "DonDuende":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "El_Gran_Keto":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "ElLoco":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "ElVendado":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "FrioPolar":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "HerramientasBrayan":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "Joker":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "LlamadaImpura":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "NegarAtaque":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "NegarTurno":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "PoderSupremo":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "RoboMagico":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                                case "SoloPostres":
                                    try {
                                        board.getPlayer().activateHechizo(card,null);
                                    } catch (WrongPhaseException wrongPhaseException) {
                                        wrongPhaseException.printStackTrace();
                                    } catch (NoHechizosSpaceException noHechizosSpaceException) {
                                        noHechizosSpaceException.printStackTrace();
                                    }
                                    updatefield();
                                    fc=null;
                                    return;
                            }
                        }
                    }
                }
            }
        }
    }
}