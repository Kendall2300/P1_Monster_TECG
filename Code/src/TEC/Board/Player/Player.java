package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Exceptions.*;

import java.io.IOException;

public class Player implements Duelist{
    private final String Name;
    private int LifePoints;
    private Field field;
    private int Mana;

    public Player(String name) throws IOException, UnexpectedFormatException {
        this.Name = name;
        this.LifePoints = 1000;
        this.Mana=200;
        this.field= new Field();
    }

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

    @Override
    public void addCardToHand() {
        this.field.addCardToHand();
    }
    @Override
    public void addNCardToHand(int n) {
        this.field.addNCardToHand(n);
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

    public Field getField() {
        return field;
    }

    public int getMana() {
        return Mana;
    }

    public void setMana(int mana) {
        Mana = mana;
    }

}
