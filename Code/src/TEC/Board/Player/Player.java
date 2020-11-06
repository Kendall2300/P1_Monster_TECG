package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Exceptions.*;

import java.io.IOException;

/**
 * Player
 * Esta clase implementa los metodos de Duelista ya que genera a los jugadores y
 * los define como un objeto que puede interactuar con otros
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class Player implements Duelist{
    private final String Name;
    private int LifePoints;
    private Field field;
    private int Mana;

    /**
     * Player
     * Este es el metodo constructor de la clase que se encarga de crear a los jugadores e instanciar partes importantes de ellos
     * @param name String que será el nombre del jugador
     * @throws IOException
     * @throws UnexpectedFormatException
     */
    public Player(String name) throws IOException, UnexpectedFormatException {
        this.Name = name;
        this.LifePoints = 1000;
        this.Mana=200;
        this.field= new Field();
    }

    /**
     * summonEsbirro
     * Este metodo se encarga de invocar a los esbirros al campo del jugador
     * @param esbirro Un objeto de tipo Esbirros
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws NoEsbirrosSpaceException
     */
    @Override
    public boolean summonEsbirro(Esbirros esbirro) throws WrongPhaseException, NoEsbirrosSpaceException {
        if(Carta.getBoard().isGameOver()){
            return false;
        }

        if(this!=Carta.getBoard().getPlayer()){
            return false;
        }

        boolean monsteradded = this.field.addEsbirroToField(esbirro,false);

        if(!monsteradded)
            return false;

        return true;
    }

    /**
     * setHechizo
     * Este metodo se encarga de colocar un hechizo o secreto en el campo de hechizos de jugador
     * @param hechizo Un objeto de tipo Hechizos
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws NoHechizosSpaceException
     */
    @Override
    public boolean setHechizo(Hechizos hechizo) throws WrongPhaseException, NoHechizosSpaceException {

        if(Carta.getBoard().isGameOver()){
            return false;
        }

        if (this!=Carta.getBoard().getPlayer()){
            return false;
        }

        boolean hechizoAdded=this.field.addHechizoToField(hechizo,null,true);

        return hechizoAdded;
    }

    /**
     * activateHechizo
     * Este metodo se encarga de activar un Hechizo o Secreto
     * @param hechizo Un objeto de tipo Hechizo
     * @param esbirro Un objeto de tipo esbirro
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws NoHechizosSpaceException
     */
    @Override
    public boolean activateHechizo(Hechizos hechizo, Esbirros esbirro) throws WrongPhaseException, NoHechizosSpaceException {
        if (Carta.getBoard().isGameOver()){
            return false;
        }

        if (this!=Carta.getBoard().getPlayer()){
            return false;
        }

        boolean hechizoActivated;

        if(this.field.getHechizosArea().contains(hechizo)){
            hechizoActivated=this.field.activateSetHechizo(hechizo,esbirro);
        } else {
            hechizoActivated=this.field.addHechizoToField(hechizo,null,false);
        }

        return hechizoActivated;
    }

    /**
     * declareAttack
     * Este metodo se encarga de atacr directamente al oponente si no posee esbirros en el campo
     * @param esbirro Un objeto de tipo esbirro
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws EsbirrosMultipleAttackException
     */
    @Override
    public boolean declareAttack(Esbirros esbirro) throws WrongPhaseException, EsbirrosMultipleAttackException {
        if(Carta.getBoard().isGameOver()){
            return false;
        }

        if(this!=Carta.getBoard().getPlayer()){
            return false;
        }

        boolean esbirroAttacked=this.field.declareAttack(esbirro,null);

        return esbirroAttacked;
    }

    /**
     * declareAttack
     * Este metodo se encarga de atacar a los esbirros del oponente
     * @param activeEsbirro Un objeto tipo esbirro del jugador activo o atacante
     * @param opponentEsbirro Un objeto tipo esbirro del jugadotr oponente
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws EsbirrosMultipleAttackException
     */
    @Override
    public boolean declareAttack(Esbirros activeEsbirro, Esbirros opponentEsbirro) throws WrongPhaseException, EsbirrosMultipleAttackException {
        if(Carta.getBoard().isGameOver()){
            return false;
        }

        if (this!=Carta.getBoard().getPlayer()){
            return false;
        }

        boolean esbirroAttacked=this.field.declareAttack(activeEsbirro,opponentEsbirro);

        return esbirroAttacked;
    }

    /**
     * endPhase
     * Este metodo se encarga de terminar cada fase del jugador
     */
    @Override
    public void endPhase() {
        if (Carta.getBoard().isGameOver())
            return;
        if (this!=Carta.getBoard().getPlayer())
            return;
        this.getField().endPhase();
    }

    /**
     * endTurn
     * Este metodo termina inmediatamente el turno del jugador
     * @return Un boolean
     */
    @Override
    public boolean endTurn() {
        if (Carta.getBoard().isGameOver())
            return false;
        if (this!=Carta.getBoard().getPlayer())
            return false;
        this.getField().endTurn();
        return true;
    }

    /**
     * addCardToHand
     * Este metodo añade una carta a la mano del jugador actual
     */
    @Override
    public void addCardToHand() {
        this.field.addCardToHand();
    }

    /**
     * addNCardToHand
     * Este metodo añade una cantidad de cartas especificas a la mano del jugador actual
     * @param n Un entero mayor que 0
     */
    @Override
    public void addNCardToHand(int n) {
        this.field.addNCardToHand(n);
    }

    /**
     * getLifePoints
     * Este metodo consigue los LifePoints del jugador
     * @return Un entero
     */
    public int getLifePoints() {
        return LifePoints;
    }

    /**
     * setLifePoints
     * Este metodo coloca los LifePoints del jugador en un valor especifico
     * @param lifePoints Un entero
     */
    public void setLifePoints(int lifePoints) {
        LifePoints = lifePoints;
    }

    /**
     * getName
     * Este metodo obtiene el nombre del jugador
     * @return Un string con el nombre del jugador
     */
    public String getName() {
        return Name;
    }

    /**
     * getField
     * Este metodo obtiene el campo del jugador
     * @return Un objeto de tipo Field
     */
    public Field getField() {
        return field;
    }

    /**
     * getMana
     * Este metodo obtiene el mana del jugador
     * @return Un entero
     */
    public int getMana() {
        return Mana;
    }

    /**
     * setMana
     * Este metodo coloca el mana del jugador en una cantidad especifica
     * @param mana Un entero
     */
    public void setMana(int mana) {
        Mana = mana;
    }

}
