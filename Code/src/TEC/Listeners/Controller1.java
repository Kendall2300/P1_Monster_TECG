package TEC.Listeners;

import TEC.Board.Board;
import TEC.Board.Player.Phase;
import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Location;
import TEC.Cartas.Secretos.Secretos;
import TEC.Exceptions.NoEsbirrosSpaceException;
import TEC.Exceptions.UnexpectedFormatException;
import TEC.Exceptions.WrongPhaseException;
import TEC.Gui.*;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class Controller1 implements ActionListener, MouseListener {
    private JButton fc;
    private JButton sc;
    private JButton tc;
    private Board board;
    private Gui gui;
    private int summon;

    public Controller1(Board board, Gui gui) {
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

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
        if (e.getSource() instanceof SecretosButton) {
            SecretosButton b = (SecretosButton) e.getSource();
            Secretos c = b.getSecreto();
            if (c != null) {
                String url = "src/Imagenes/Secretos/" + c.getName() + ".png";

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

    @Override
    public void mouseExited(MouseEvent e) {

    }

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
                } catch (IIOException | UnexpectedFormatException e) {
                    e.printStackTrace();
                } catch (IOException e) {
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
                url = "src/Imagenes/Esbirros/" + gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1).getName() + ".png";
            } else if (gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1) instanceof Hechizos) {
                url = "src/Imagenes/Hechizos/" + gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1).getName() + ".png";
            } else {
                url = "src/Imagenes/Secretos/" + gui.getP1().getField().getGraveyard().get(gui.getP1().getField().getGraveyard().size() - 1).getName() + ".png";
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
            } else if (gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1) instanceof Hechizos) {
                url = "src/Imagenes/Hechizos/" + gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1).getName() + ".png";
            } else {
                url = "src/Imagenes/Secretos/" + gui.getP2().getField().getGraveyard().get(gui.getP2().getField().getGraveyard().size() - 1).getName() + ".png";
            }
            ImageIcon img = new ImageIcon(url);
            Image img2 = img.getImage();
            Image newimg = img2.getScaledInstance(62, 91, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            gui.getGravep2().setIcon(newIcon);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof NextPhaseButton) {
            board.getPlayer().endPhase();
            gui.getCurrphase().setText("Current Phase: " + Carta.getBoard().getPlayer().getField().getPhase());
            updatefield();
        }
        if (e.getSource() instanceof EndTurnButton) {
            int actual_mana=board.getPlayer().getMana();
            int mana_to_win=250;
            board.getPlayer().endTurn();
            board.getPlayer().setMana(actual_mana+mana_to_win);
            updatefield();
        }
        if (e.getSource() instanceof EsbirrosButton) {
            try {
                if (fc == null) {
                    Esbirros monster = ((EsbirrosButton) e.getSource()).getEsbirro();
                    //fc=button

                    if (monster.getLocation() == Location.Hand) {
                        fc = (EsbirrosButton) e.getSource();
                        monster = ((EsbirrosButton) fc).getEsbirro();
                        //fc=button
                        Object[] options = {"Summon", "Cancel"};
                        summon = JOptionPane.showOptionDialog(gui, "Summon?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                        if (summon == 1) {
                            fc = null;
                            return;
                        }
                        if (monster.getMana_cost() <= Carta.getBoard().getPlayer().getMana()) {
                            int mana_to_lose = monster.getMana_cost();
                            int actual_mana = Carta.getBoard().getPlayer().getMana();
                            Carta.getBoard().getPlayer().setMana(actual_mana - mana_to_lose);
                            Carta.getBoard().getPlayer().summonEsbirro(monster);
                        }
                    } else {
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
                                board.getPlayer().declareAttack(monster);
                                fc = null;
                                updatefield();
                                return;
                            }
                            JOptionPane.showMessageDialog(gui, "Escoge al esbirro a atacar");
                            return;
                        }
                    }

                }
            } catch (HeadlessException headlessException) {
                headlessException.printStackTrace();
            } catch (NoEsbirrosSpaceException noEsbirrosSpaceException) {
                noEsbirrosSpaceException.printStackTrace();
            } catch (WrongPhaseException wrongPhaseException) {
                wrongPhaseException.printStackTrace();
            }
        }
    }
}