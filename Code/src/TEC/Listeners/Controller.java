package TEC.Listeners;

import TEC.Board.Board;
import TEC.Board.Player.Phase;
import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Location;
import TEC.Exceptions.EsbirrosMultipleAttackException;
import TEC.Exceptions.NoEsbirrosSpaceException;
import TEC.Exceptions.UnexpectedFormatException;
import TEC.Exceptions.WrongPhaseException;
import TEC.Gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements ActionListener, MouseListener {
    private JButton fc;
    private JButton sc;
    private JButton tc;
    private Board board;
    private Gui gui;
    private int summonset;

    public Controller(Board board, Gui gui) {
        this.board = board;
        this.gui = gui;
        addActionListeners();
        gui.getEndturn().addActionListener(this);
        gui.getNextphase().addActionListener(this);
    }

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

    private void updatefield() {
        if (board.isGameOver()) {
            Object[] options = {"End Game!", "Start New Game"};
            int choice = JOptionPane.showOptionDialog(gui, "GAME Over!,The winner is " + board.getWinner().getName() + "", null, JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == 0) {


                System.exit(0);
            } else {
                try {
                    Gui.main(null);
                    gui.setVisible(false);
                } catch (IOException | UnexpectedFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        gui.getDeckp1().setText("" + gui.getP1().getField().getDeck().getDeck().size());
        gui.getDeckp2().setText("" + gui.getP2().getField().getDeck().getDeck().size());
        gui.getLifep1().setText("Life Points: " + gui.getP1().getLifePoints());
        gui.getLifep2().setText("Life Points: " + gui.getP2().getLifePoints());
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
                url = "Cards Images Database/Monsters/" + gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1).getName() + ".png";
            } else {
                url = "Cards Images Database/Spells/" + gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1).getName() + ".png";
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
                url = "Cards Images Database/Monsters/" + gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1).getName() + ".png";
            } else {
                url = "Cards Images Database/Spells/" + gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1).getName() + ".png";
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

    public void seticons() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof EsbirrosButton) {

            EsbirrosButton b = (EsbirrosButton) e.getSource();
            Esbirros c = b.getEsbirro();
            if (c != null) {
                String url = "Cards Images Database/Monsters/" + c.getName() + ".png";

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
                String url = "Cards Images Database/Spells/" + c.getName() + ".png";
                ImageIcon img = new ImageIcon(url);
                gui.getDescription().setIcon(img);
                gui.getDescription().revalidate();
                gui.revalidate();
            }
        }
        if (e.getSource() instanceof CardButton) {

            ImageIcon img = new ImageIcon("Cards Images Database/Card Back.png");
            gui.getDescription().setIcon(img);
            gui.getDescription().revalidate();
            gui.revalidate();
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() instanceof NextPhaseButton){
            board.getPlayer().endPhase();
            gui.getCurrphase().setText("Current Phase: " + Carta.getBoard().getPlayer().getField().getPhase());
            updatefield();
        }
        if(arg0.getSource() instanceof EndTurnButton){
            board.getPlayer().endTurn();
            updatefield();
        }
        if(arg0.getSource() instanceof EsbirrosButton){
            try {
                if (fc == null) {
                    Esbirros monster = ((EsbirrosButton) arg0.getSource()).getEsbirro();
                    if (monster.getLocation() == Location.Hand) {
                        fc = (EsbirrosButton) arg0.getSource();
                        monster = ((EsbirrosButton) fc).getEsbirro();
                        Object[] options = {"Summon", "Cancel"};
                        summonset = JOptionPane.showOptionDialog(
                                gui, "What is your action?", null,
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, options, options[1]);
                        if (summonset == 1) {
                            fc = null;
                            return;
                        }
                        if (monster.getMana_cost() <= Carta.getBoard().getPlayer().getMana()) {
                            if (summonset == 0) {
                                Carta.getBoard().getPlayer().summonEsbirro(monster);
                                int mana_to_lose = monster.getMana_cost();
                                int mana_actual = Carta.getBoard().getPlayer().getMana();
                                Carta.getBoard().getPlayer().setMana(mana_actual - mana_to_lose);
                            }
                            fc = null;
                            updatefield();
                            return;
                        } else {
                            fc = null;
                            return;
                        }
                        if (board.getPlayer().getField().getPhase() == Phase.Battle)
                            fc = (EsbirrosButton) arg0.getSource();
                        monster = ((EsbirrosButton) fc).getEsbirro();
                        Object[] options2 = {"OK", "Cancel"};
                        int y = JOptionPane.showOptionDialog(gui, "Attack ?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[1]);
                        if (y == 1) {
                            fc = null;
                            sc = null;
                            tc = null;
                            return;
                        } else if (board.getOpponentPlayer().getField().getEsbirrosArea().size() == 0) {
                            board.getPlayer().declareAttack(((EsbirrosButton) fc).getEsbirro());
                            fc = null;
                            updatefield();
                            return;
                        }
                        JOptionPane.showMessageDialog(gui, "Choose the monster you wish to attack");
                        return;

                    }
                }
            }
        }


            }
            catch(WrongPhaseException e){
                fc = null;
                sc = null;
                tc = null;
                JOptionPane.showMessageDialog(gui, "you can't set or summon a monster in this phase");
            }
            catch(NoEsbirrosSpaceException e){
                fc = null;
                sc = null;
                tc = null;
                JOptionPane.showMessageDialog(gui, "There is no avaialble space in monster Area");
            }
            catch(EsbirrosMultipleAttackException e){
                fc = null;
                sc = null;
                tc = null;
                JOptionPane.showMessageDialog(gui, "You Can Attack Only Once");
            }
        }

        if(arg0.getSource() instanceof SpellButton){
            if(fc instanceof MonsterButton){
                fc = null;
                sc=null;
                JOptionPane.showMessageDialog(gui, "you must sacrifice a monster card");
                return;
            }
            if(fc!=null &&((SpellButton)fc).getName().equalsIgnoreCase("Change Of Heart")){
                JOptionPane.showMessageDialog(gui, "you must choose a monster card");
                fc = null;
                sc=null;
                return;
            }

            if(fc==null){
                if(board.getActivePlayer().getField().getSpellArea().contains(((SpellButton)arg0.getSource()).getSpell())
                        || board.getActivePlayer().getField().getHand().contains(((SpellButton)arg0.getSource()).getSpell())){
                    if(((SpellButton)arg0.getSource()).getSpell().getLocation()==Location.HAND){
                        String[] buttons = { "Activate", "Set", "cancel"};

                        int rc = JOptionPane.showOptionDialog(null, "Activate or set spell ?", "SpellCard",
                                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);
                        SpellButton button = (SpellButton) arg0.getSource();
                        SpellCard card = button.getSpell();
                        fc=button;
                        if(rc==1){
                            Card.getBoard().getActivePlayer().setSpell(card);
                            fc=null;
                            updatefield();
                            return;

                        }
                        if(rc==2){
                            fc=null;
                            return;
                        }
                        else{
                            switch (card.getName()) {

                                case "Card Destruction":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Change Of Heart":
                                    String[] options = { "ok", "cancel"};

                                    int x = JOptionPane.showOptionDialog(null, "Choose the monster you wish to control", "SpellCard",
                                            JOptionPane.WARNING_MESSAGE, 0, null, options, options[1]);
                                    if(x==0){
                                        fc = button;
                                        return;
                                    }
                                    fc=null;
                                    return;
                                case "Dark Hole":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Graceful Dice":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Harpie's Feather Duster":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Heavy Storm":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Mage Power":
                                    String[] options1 = { "ok", "cancel"};

                                    int x1 = JOptionPane.showOptionDialog(null, "Choose the monster you wish to enhance", "SpellCard",
                                            JOptionPane.WARNING_MESSAGE, 0, null, options1, options1[1]);
                                    if(x1==0){
                                        fc = button;
                                        return;
                                    }
                                    fc=null;
                                    return;
                                case "Monster Reborn":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Pot of Greed":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Raigeki":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                default:
                                    board.getActivePlayer().activateSpell(((SpellButton)fc).getSpell(), null);
                                    updatefield();

                            }
                        }
                    }
                    else{
                        String[] buttons = { "ok", "cancel"};

                        int rc = JOptionPane.showOptionDialog(null, "Activate spell card ?", "SpellCard",
                                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
                        SpellButton button = (SpellButton) arg0.getSource();
                        SpellCard card = button.getSpell();
                        fc=button;
                        if(rc==1){
                            Card.getBoard().getActivePlayer().setSpell(card);
                            fc=null;
                            updatefield();
                            return;
                        }
                        else{
                            switch (card.getName()) {

                                case "Card Destruction":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Change Of Heart":
                                    String[] options = { "ok", "cancel"};

                                    int x = JOptionPane.showOptionDialog(null, "Choose the monster you wish to control", "SpellCard",
                                            JOptionPane.WARNING_MESSAGE, 0, null, options, options[1]);
                                    if(x==0){
                                        fc = button;
                                        return;
                                    }
                                    fc=null;
                                    return;
                                case "Dark Hole":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Graceful Dice":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Harpie's Feather Duster":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Heavy Storm":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Mage Power":
                                    String[] options1 = { "ok", "cancel"};

                                    int x1 = JOptionPane.showOptionDialog(null, "Choose the monster you wish to enhance", "SpellCard",
                                            JOptionPane.WARNING_MESSAGE, 0, null, options1, options1[1]);
                                    if(x1==0){
                                        fc = button;
                                        return;
                                    }
                                    fc=null;
                                    return;
                                case "Monster Reborn":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Pot of Greed":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                case "Raigeki":
                                    board.getActivePlayer().activateSpell(card, null);
                                    updatefield();
                                    fc = null;
                                    return;
                                default:
                                    board.getActivePlayer().activateSpell(((SpellButton)fc).getSpell(), null);
                                    updatefield();
}
