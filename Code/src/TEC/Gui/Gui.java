package TEC.Gui;

import TEC.Board.Board;
import TEC.Board.Player.Player;
import TEC.Cartas.Carta;
import TEC.Exceptions.UnexpectedFormatException;
import TEC.Listeners.Controller1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Gui
 * Esta clase se encarga de controlar la interfáz gráfica que será lo que aparece a la hora de inicializar el juego
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class Gui extends JFrame {
    private JPanel panel2;
    private HSPanel spellAreap1;
    private HSPanel spellAreap2;
    private EsbirrosPanel monsterareap1;
    private EsbirrosPanel monsterareap2;
    public JLabel deckp1;
    public JLabel deckp2;
    public JLabel lifep1;
    public JLabel lifep2;
    private JButton gravep1;
    private JButton gravep2;
    private NextPhaseButton nextphase;
    private JLabel p1name;
    private JLabel p2name;
    public JLabel currphase;
    private EndTurnButton endturn;
    private JPanel panel1;
    private HandPanel handp1;
    private HandPanel handp2;
    private JScrollPane pan;
    private HiddenHandPanel p1hid;
    private HiddenHandPanel p2hid;
    private Player p1;
    private Player p2;
    private ImageIcon imgThisImg;
    private JLabel description;
    private JScrollPane sp1;
    private JScrollPane sp2;

    /**
     * getSp1
     * Este metodo obtiene el valor del ScrollPanel que saldrá si la cantidad de cartas es mayor al tamaño del panel normal
     * @return Un JScrollPane del jugador 1
     */
    public JScrollPane getSp1() {
        return sp1;
    }

    /**
     * setSp1
     * Este metodo coloca el valor del ScrollPanel que saldrá si la cantidad de cartas es mayor al tamaño del panel normal
     * @param sp1 Un objeto de tipo JScrollPanel
     */
    public void setSp1(JScrollPane sp1) {
        this.sp1 = sp1;
    }

    /**
     * getSp2
     * Este metodo obtiene el valor del ScrollPanel que saldrá si la cantidad de cartas es mayor al tamaño del panel normal
     * @return Un JScrollPane del jugador 2
     */
    public JScrollPane getSp2() {
        return sp2;
    }

    /**
     * setSp2
     * Este metodo coloca el valor del ScrollPanel que saldrá si la cantidad de cartas es mayor al tamaño del panel normal
     * @param sp2 Un objeto de tipo JScrollPanel
     */
    public void setSp2(JScrollPane sp2) {
        this.sp2 = sp2;
    }

    /**
     * getP1hid
     * Este metodo obtiene le valor del panel escondido del primer jugador
     * @return Un objeto tipo HiddenHandPanel
     */
    public HiddenHandPanel getP1hid() {
        return p1hid;
    }

    /**
     * setP1hid
     * Este metodo coloca el valor del HiddenHandPanel del jugador 1
     * @param p1hid Un objeto tipo HiddenHandPanel
     */
    public void setP1hid(HiddenHandPanel p1hid) {
        this.p1hid = p1hid;
    }

    /**
     * getP2hid
     * Este metodo obtiene el valor del HiddenHandPanel del jugador 2
     * @return Un objeto tipo HiddenHandPanel
     */
    public HiddenHandPanel getP2hid() {
        return p2hid;
    }

    /**
     * setP2hid
     * Este metodo coloca el valor del HiddenHandPanel del jugador 2
     * @param p2hid Un objeto tipo HiddenHandPanel
     */
    public void setP2hid(HiddenHandPanel p2hid) {
        this.p2hid = p2hid;
    }

    /**
     * getP1
     * Este metodo obtiene quien es el jugador 1
     * @return Un objeto de tipo Player
     */
    public Player getP1() {
        return p1;
    }

    /**
     * setP1
     * Este metodo coloca quien es el jugador 1
     * @param p1 Un objeto de tipo Player
     */
    public void setP1(Player p1) {
        this.p1 = p1;
    }

    /**
     * getP2
     * Este metodo obtiene quien es el jugador 2
     * @return Un objeto de tipo Player
     */
    public Player getP2() {
        return p2;
    }

    /**
     * setP2
     * Este metodo coloca a un jugador como el 2
     * @param p2 Un objeto de tipo Player
     */
    public void setP2(Player p2) {
        this.p2 = p2;
    }

    /**
     * getPanel2
     * Este metodo obtine cual es el panel de Jugador 2
     * @return Un objeto tipo JPanel
     */
    public JPanel getPanel2() {
        return panel2;
    }

    /**
     * setPanel2
     * Este metodo define cual es el panel del Jugador 2
     * @param panel2 Un objeto tipo JPanel
     */
    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    /**
     * getSpellAreap1
     * Este metodo obtiene el area de hechizos y secretos del jugador 1
     * @return Un objeto tipo HSPanel
     */
    public HSPanel getSpellAreap1() {
        return spellAreap1;
    }

    /**
     * setSpellAreap1
     * Este metodo define el área de hechizos y secretos del jugador 1
     * @param spellAreap1 Un objeto tipo HSPanel
     */
    public void setSpellAreap1(HSPanel spellAreap1) {
        this.spellAreap1 = spellAreap1;
    }

    /**
     * getMonsterareap1
     * Este metodo obtiene el area de Esbirros del jugador 1
     * @return Un objeto tipo EsbirrosPanel
     */
    public EsbirrosPanel getMonsterareap1() {
        return monsterareap1;
    }

    /**
     * setMonsterareap1
     * Este metodo define el area de Esbirros del jugador 1
     * @param monsterareap1 Un objeto tipo EsbirrosPanel
     */
    public void setMonsterareap1(EsbirrosPanel monsterareap1) {
        this.monsterareap1 = monsterareap1;
    }

    /**
     * getMonsterAreap2
     * Este metodo obtiene el area de Esbirros del jugador 2
     * @return Un objeto tipo EsbirrosPanel
     */
    public EsbirrosPanel getMonsterAreap2() {
        return monsterareap2;
    }

    /**
     * setMonsterAreap2
     * Este metodo define el area de Esbirros del jugador 2
     * @param monsterAreap2 Un objeto tipo EsbirrosPanel
     */
    public void setMonsterAreap2(EsbirrosPanel monsterAreap2) {
        this.monsterareap2 = monsterAreap2;
    }

    /**
     * getSpellAreap2
     * Este metodo obtiene el area de hechizos y secretos del jugador 2
     * @return Un objeto tipo HSPanel
     */
    public HSPanel getSpellAreap2() {
        return spellAreap2;
    }

    /**
     * setSpellAreap2
     * Este metodo define el area de hechizos y secretos del jugador 2
     * @param spellAreap2 Un objeto tipo HSPanel
     */
    public void setSpellAreap2(HSPanel spellAreap2) {
        this.spellAreap2 = spellAreap2;
    }

    /**
     * getDeckp1
     * Este metodo obtiene el Deck designado para el jugador 1
     * @return Un objeto tipo Deck
     */
    public JLabel getDeckp1() {
        return deckp1;
    }

    /**
     * setDeckp1
     * Este metodo coloca el Deck designado para el jugador 1
     * @param deckp1 Un objeto tipo Deck
     */
    public void setDeckp1(JLabel deckp1) {
        this.deckp1 = deckp1;
    }

    /**
     * getDeckp2
     * Este metodo obtiene el Deck designado para el jugador 2
     * @return Un objeto tipo Deck
     */
    public JLabel getDeckp2() {
        return deckp2;
    }

    /**
     * setDeckp2
     * Este metodo coloca el Deck designado para el jugador 2
     * @param deckp2 Un objeto tipo Deck
     */
    public void setDeckp2(JLabel deckp2) {
        this.deckp2 = deckp2;
    }

    /**
     * getLifep1
     * Este metodo obtine el valor de los puntos de vida del jugador 1
     * @return Un entero que es la vida del jugador
     */
    public JLabel getLifep1() {
        return lifep1;
    }

    /**
     * setLifep1
     * Este metodo coloca el valor de los puntos de vida del jugador 1
     * @param lifep1 Un entero que sería la vida del jugador
     */
    public void setLifep1(JLabel lifep1) {
        this.lifep1 = lifep1;
    }

    /**
     * getLifep2
     * Este metodo obtine el valor de los puntos de vida del jugador 2
     * @return Un entero que es la vida del jugador
     */
    public JLabel getLifep2() {
        return lifep2;
    }

    /**
     * setLifep2
     * Este metodo coloca el valor de los puntos de vida del jugador 2
     * @param lifep2 Un entero que es la vida del jugador
     */
    public void setLifep2(JLabel lifep2) {
        this.lifep2 = lifep2;
    }

    /**
     * getGravep1
     * Este metodo obtiene los esbirros en el cementerio dej jugador 1
     * @return Un objeto tipo JButton
     */
    public JButton getGravep1() {
        return gravep1;
    }

    /**
     * setGravep1
     * Este metodo coloca los esbirros en el cementerio del jugador 1
     * @param gravep1 Un objteo de tipo JButton
     */
    public void setGravep1(JButton gravep1) {
        this.gravep1 = gravep1;
    }

    /**
     * getGravep2
     * Este metodo obtiene los esbirros en el cementerio del jugador 2
     * @return Un objeto de tipo JButton
     */
    public JButton getGravep2() {
        return gravep2;
    }

    /**
     * setGravep2
     * Este metodo coloca los esbirro en el cementerio del jugador 2
     * @param gravep2 Un objeto de tipo JButton
     */
    public void setGravep2(JButton gravep2) {
        this.gravep2 = gravep2;
    }

    /**
     * getNextphase
     * Este metodo obtiene el valor de la siguiente fase
     * @return Un valor de tipo Phase
     */
    public NextPhaseButton getNextphase() {
        return nextphase;
    }

    /**
     * setNextphase
     * Este metodo coloca el valor de la siguiente fase
     * @param nextphase Un valor de tipo Phase
     */
    public void setNextphase(NextPhaseButton nextphase) {
        this.nextphase = nextphase;
    }

    /**
     * getP1name
     * Este metodo obtiene el nombre del jugador 1
     * @return Un objeto de tipo JLabel que será para el nombre del jugador
     */
    public JLabel getP1name() {
        return p1name;
    }

    /**
     * setP1name
     * Este metodo define el nombre del jugador 1
     * @param p1name Un objeto de tipo JLabel que será para el nombre del jugador
     */
    public void setP1name(JLabel p1name) {
        this.p1name = p1name;
    }

    /**
     * getP2name
     * Este metodo obtiene el nombre del jugador 2
     * @return Un objeto de tipo JLabel que será para el nombre del jugador
     */
    public JLabel getP2name() {
        return p2name;
    }

    /**
     * setP2name
     * Este metodo define el nombre que tendrá el jugador 2
     * @param p2name Un objeto de tipo JLabel que será para el nombre del jugador
     */
    public void setP2name(JLabel p2name) {
        this.p2name = p2name;
    }

    /**
     * getCurrphase
     * Este metodo te devolverá el valor de la fase actual
     * @return Un valor de tipo Phase
     */
    public JLabel getCurrphase() {
        return currphase;
    }

    /**
     * setCurrphase
     * Este metodo definirá el valor de la fase actual
     * @param currphase Un valor de tipo Phase
     */
    public void setCurrphase(JLabel currphase) {
        this.currphase = currphase;
    }

    /**
     * getEndturn
     * Este metodo obtendrá el la accion de terminar el turno
     * @return Un valor de tipo Phase
     */
    public EndTurnButton getEndturn() {
        return endturn;
    }

    /**
     * setEndTurn
     * Este metodo colocará la acción de su uso en el boton
     * @param endturn Un valor de tipo Phase
     */
    public void setEndturn(EndTurnButton endturn) {
        this.endturn = endturn;
    }

    /**
     * getPanel1
     * Este metodo obtendrá el panel del jugador 1
     * @return Un objeto de tipo JPanel
     */
    public JPanel getPanel1() {
        return panel1;
    }

    /**
     * setPanel1
     * Este metodo colocará al panel del jugador 1
     * @param panel1 Un objeto tipo JPanel
     */
    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    /**
     * getHanp1
     * Este metodo obtendrá el valor del panel de la mano del jugador 1
     * @return Un objeto tipo HandPanel
     */
    public HandPanel getHandp1() {
        return handp1;
    }

    /**
     * setHanp1
     * Este metodo colocará el valor del panel de la mano del jugador 1
     * @param handp1 Un objeto tipo HandPanel
     */
    public void setHandp1(HandPanel handp1) {
        this.handp1 = handp1;
    }

    /**
     * getHandp2
     * Este metodo obtendrá el valor del panel de la mano del jugador 2
     * @return Un objeto tipo HandPanel
     */
    public HandPanel getHandp2() {
        return handp2;
    }

    /**
     * setHandp2
     * Este metodo colocará el valor del panel de la mano del jugador 2
     * @param handp2 Un objeto tipo HandPanel
     */
    public void setHandp2(HandPanel handp2) {
        this.handp2 = handp2;
    }

    /**
     * getPan
     * Este metodo obtendra el valor del paneo del scroll pane
     * @return Un objeto tipo JScrollPane
     */
    public JScrollPane getPan() {
        return pan;
    }

    /**
     * setPan
     * Este metodo colocará el valor del paneo del scroll pane
     * @param pan Un objeto tipo JScrollPane
     */
    public void setPan(JScrollPane pan) {
        this.pan = pan;
    }

    /**
     * Gui
     * Este es el metodo constructor de la clase que se encargará de establecer los parámetros y construir el objeto.
     * @param p1 Un objeto de tipo Player que será el jugador 1
     * @param p2 Un objeto de tipo Player que será el jugador 2
     * @throws IOException
     * @throws UnexpectedFormatException
     */
    public Gui(Player p1, Player p2) throws IOException, UnexpectedFormatException {
        super("P1_MonsterTECG!");
        Board b = new Board();
        b.startGame(p1, p2);
        setP1(p1);
        setP2(p2);
        ImageIcon bg = new ImageIcon("src/Imagenes/bg.png");
        JLabel g = new JLabel(bg);
        g.setVisible(true);
        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("src/Imagenes/bg2.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.add(g);
        setResizable(false);
        setSize(1366, 768);
        this.getContentPane().setLayout(null);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        monsterareap1 = new EsbirrosPanel(p1);
        monsterareap2 = new EsbirrosPanel(p2);
        spellAreap1 = new HSPanel(p1);
        spellAreap2 = new HSPanel(p2);
        nextphase = new NextPhaseButton("Next Phase");
        endturn = new EndTurnButton("End Turn");
        p1name = new JLabel(p1.getName());
        p2name = new JLabel(p2.getName());
        gravep1 = new JButton();
        gravep2 = new JButton();
        lifep1 = new JLabel("Life Points:" + p1.getLifePoints()+"\nMana:"+p1.getMana());
        lifep2 = new JLabel("Life Points:" + p2.getLifePoints()+"\nMana:"+p2.getMana());
        deckp1 = new JLabel(p1.getField().getDeck().getDeck().size()+"");
        deckp2 = new JLabel("" + p2.getField().getDeck().getDeck().size());
        handp1 = new HandPanel(p1);
        handp2 = new HandPanel(p2);
        currphase = new JLabel(Carta.getBoard().getPlayer().getField().getPhase().name());

        deckp1.setFont(new Font("Ariel", Font.BOLD, 15));
        deckp1.setForeground(Color.WHITE);
        deckp2.setFont(new Font("Ariel", Font.BOLD, 15));
        deckp2.setForeground(Color.WHITE);
        ImageIcon grave = new ImageIcon("src/Imagenes/Graveyard.png");
        gravep1.setIcon(grave);
        gravep2.setIcon(grave);

        description = new JLabel();
        p1hid = new HiddenHandPanel(p1);
        p2hid = new HiddenHandPanel(p2);

        p2name.setFont(new Font("Century Gothic", Font.BOLD, 19));
        p2name.setForeground(Color.BLACK);

        lifep2.setFont(new Font("Century Gothic", Font.BOLD, 14));
        lifep2.setForeground(Color.BLACK);

        lifep1.setFont(new Font("Century Gothic", Font.BOLD, 14));
        lifep1.setForeground(Color.BLACK);

        p1name.setFont(new Font("Century Gothic", Font.BOLD, 19));
        p1name.setForeground(Color.BLACK);

        currphase.setFont(new Font("Century Gothic", Font.BOLD, 20));
        currphase.setForeground(Color.BLACK);


        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(monsterareap1, BorderLayout.NORTH);
        panel1.add(spellAreap1, BorderLayout.CENTER);
        panel1.setOpaque(false);


        if (p1 == Carta.getBoard().getPlayer()) {
            sp1 = new JScrollPane(handp1);
            sp1.setBorder(null);
            sp1.getViewport().setOpaque(false);
            sp1.setPreferredSize(new Dimension(500, 150));
            sp1.setOpaque(false);
            sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            panel1.add(sp1, BorderLayout.SOUTH);
        this.revalidate();
        }else{
            sp1 = new JScrollPane(p1hid);
            sp1.setBorder(null);
            sp1.getViewport().setOpaque(false);
            sp1.setPreferredSize(new Dimension(500, 150));
            sp1.setOpaque(false);
            sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            panel1.add(sp1, BorderLayout.SOUTH);
            this.revalidate();
        }


        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(monsterareap2, BorderLayout.SOUTH);
        panel2.add(spellAreap2, BorderLayout.CENTER);
        panel2.setOpaque(false);

        if (p2 == Carta.getBoard().getPlayer()) {
            sp2 = new JScrollPane(handp2);
            sp2.setBorder(null);
            sp2.getViewport().setOpaque(false);
            sp2.setPreferredSize(new Dimension(500, 150));
            sp2.setOpaque(false);
            sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            panel2.add(sp2, BorderLayout.NORTH);
        this.revalidate();
        } else {
            sp2 = new JScrollPane(p2hid);
            sp2.setBorder(null);
            sp2.getViewport().setOpaque(false);
            sp2.setPreferredSize(new Dimension(500, 150));
            sp2.setOpaque(false);
            sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            panel2.add(sp2, BorderLayout.NORTH);
            this.revalidate();
        }


        JPanel panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setLayout(null);
        panel3.add(p2name);
        panel3.add(lifep2);
        panel3.add(endturn);
        panel3.add(nextphase);
        panel3.add(lifep1);
        panel3.add(p1name);
        this.add(panel3);
        panel3.setBounds(0, 0, 200, 700);
        p2name.setBounds(2, 150, 311, 57);
        lifep2.setBounds(2, 200, 311, 57);
        endturn.setBounds(5, 300, 157, 39);
        nextphase.setBounds(5, 400, 157, 39);
        p1name.setBounds(2, 500, 311, 57);
        lifep1.setBounds(2, 550, 311, 57);


        imgThisImg = new ImageIcon("src/Imagenes/Card Back.png");
        description.setIcon(imgThisImg);


        this.add(panel1);
        panel1.setBounds(280, 380, 700, 350);
        this.add(panel2);
        panel2.setBounds(280, 0, 700, 350);
        this.add(deckp1);
        deckp1.setBounds(1277, 645, 100, 100);
        this.add(deckp2);
        deckp2.setBounds(1277, 25, 100, 100);
        this.add(gravep1);
        gravep1.setBounds(1150, 645, 62, 91);
        this.add(gravep2);
        gravep2.setBounds(1150, 25, 62, 91);
        this.add(description);
        description.setBounds(1050, 140, 300, 438);
        this.add(currphase);
        currphase.setBounds(583, 315, 300, 100);

        this.validate();
        new Controller1(b,this);
    }

    /**
     * getImgThisImg
     * Esta clase obtiene el camino o ruta de una imagen
     * @return Un objeto tipo ImageIcon
     */
    public ImageIcon getImgThisImg() {
        return imgThisImg;
    }

    /**
     * setImgThisImg
     * Esta clase se encarga de definir la ruta de una imagen
     * @param imgThisImg Un objeto de tipo ImageIcon
     */
    public void setImgThisImg(ImageIcon imgThisImg) {
        this.imgThisImg = imgThisImg;
    }

    /**
     * getDescription
     * Esta clase se encarga de obtener la descripción de la carta
     * @return Un objeto de tipo JLabel
     */
    public JLabel getDescription() {
        return description;
    }

    /**
     * setDescription
     * Esta clase se encarga de colocar la descripción de la carta
     * @param description Un objeto tipo JLabel
     */
    public void setDescription(JLabel description) {
        this.description = description;
    }

    /**
     * main
     * Este es el metodo main de la clase este metodo construye y llama a todos los metodos que ocupa para iniciar
     * @param args
     * @throws IOException
     * @throws UnexpectedFormatException
     */
    public static void main(String[] args) throws IOException, UnexpectedFormatException {

        JFrame start = new JFrame();
        start.setSize(1366, 768);
        start.setVisible(true);

        start.setContentPane(new JLabel(new ImageIcon("src/Imagenes/Start Game.png")));

        start.revalidate();
        start.setLayout(null);
        JTextField p1 = new JTextField();
        start.add(p1);
        p1.setBounds(475, 350, 400, 50);

        JTextField p2 = new JTextField();
        start.add(p2);
        p2.setBounds(475, 520, 400, 50);

        JButton startbut = new JButton(new ImageIcon("src/Imagenes/Start Button.png"));
        startbut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (p1.getText().length() == 0 || p2.getText().length() == 0) {
                    JOptionPane.showMessageDialog(start, "All Fields Are Required");
                } else if (p1.getText().length() >= 14 || p2.getText().length() >= 14) {
                    JOptionPane.showMessageDialog(start, "Maximum Length for name is 14 digits");
                } else {
                    start.setVisible(false);
                    try {
                        Gui gui = new Gui(new Player(p1.getText()), new Player(p2.getText()));
                    } catch (IOException | UnexpectedFormatException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        startbut.setBounds(510, 637, 311, 57);
        startbut.setVisible(true);
        startbut.setOpaque(true);
        startbut.revalidate();
        startbut.repaint();
        start.add(startbut);
        start.validate();
        System.out.println(p1.getText());
    }
}
