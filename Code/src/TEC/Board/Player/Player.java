package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Secretos.Secretos;
import TEC.Exceptions.NoEsbirrosSpaceException;
import TEC.Exceptions.NoHechizosSpaceException;
import TEC.Exceptions.UnexpectedFormatException;
import TEC.Exceptions.WrongPhaseException;

import java.io.IOException;

public class Player implements Duelist{
    private final String Name;
    private int LifePoints;
    private int Mana;
    private Field field;

    public Player(String name) throws IOException, UnexpectedFormatException {
        Name = name;
        LifePoints = 1000;
        Mana=200;
        this.field= new Field();

    }
    @Override
    public boolean declareAttack(Esbirros esbirro) throws WrongPhaseException {
        if(Carta.getBoard().isGameOver())
            return false;
        if(this!=Carta.getBoard().getPlayer())
            return false;
        boolean esbirroAttacked=this.field.declareAttack(esbirro,null);
        return esbirroAttacked;
    }
    @Override
    public boolean declareAttack(Esbirros activeEsbirro, Esbirros opponentEsbirro) throws WrongPhaseException {
        if(Carta.getBoard().isGameOver())
            return false;
        if (this!=Carta.getBoard().getPlayer())
            return false;
        boolean esbirroAttacked=this.field.declareAttack(activeEsbirro,opponentEsbirro);
        return esbirroAttacked;
    }
    @Override
    public boolean summonEsbirro(Esbirros esbirro) throws WrongPhaseException, NoEsbirrosSpaceException {
        if(Carta.getBoard().isGameOver())
            return false;
        if(this!=Carta.getBoard().getPlayer())
            return false;
        boolean monsteradded = this.field.addEsbirroToField(esbirro,false);
        if(!monsteradded)
            return false;
        return true;
    }
    @Override
    public boolean activateHechizo(Hechizos hechizo, Esbirros esbirro) throws WrongPhaseException, NoHechizosSpaceException {
        if (Carta.getBoard().isGameOver())
            return false;
        if (this!=Carta.getBoard().getPlayer())
            return false;
        boolean spellActivated;
        if(this.field.getHechizosArea().contains(hechizo))
            spellActivated=this.field.activateHechizo(hechizo,esbirro);
        else
         spellActivated=this.field.addHechizoToField(hechizo,null,false);
        return spellActivated;
    }
    @Override
    public boolean attackLP(Esbirros esbirro) {
        return false;
    }
    @Override
    public void addCardToHand() {
        this.field.addCardToHand();
    }
    @Override
    public void addNCardToHand(int n) {
        this.field.addNCardToHand(n);
    }
    @Override
    public void endPhase() {
        if (Carta.getBoard().isGameOver())
            return;
        if (this!=Carta.getBoard().getPlayer())
            return;
        this.getField().endPhase();
    }
    @Override
    public boolean endTurn() {
        if (Carta.getBoard().isGameOver())
            return false;
        if (this!=Carta.getBoard().getPlayer())
            return false;
        this.getField().endTurn();
        return true;
    }
    public Field getField() {
        return field;
    }
    public int getLifePoints() {
        return LifePoints;
    }
    public void setLifePoints(int lifePoints) {
        LifePoints = lifePoints;
    }
    public String getName() {
        return Name;
    }
    public int getMana() {
        return Mana;
    }
    public void setMana(int mana) {
        Mana = mana;
    }
}
