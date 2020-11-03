package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Secretos.Secretos;

public class Player implements Duelist{
    private final String Name;
    private int LifePoints;
    private int Mana;
    private Field field;

    public Player(String name) {
        Name = name;
        LifePoints = 1000;
        Mana=200;

    }

    @Override
    public boolean summonEsbirro(Esbirros esbirro) {
        if(Carta.getBoard().isGameOver())
            return false;
        if(this!=Carta.getBoard().getPlayer())
            return false;

        return true;
    }

    @Override
    public boolean activateHechizo(Hechizos hechizo) {
        if (Carta.getBoard().isGameOver())
            return false;
        if (this!=Carta.getBoard().getPlayer())
            return false;

        boolean spellActivated;
        return false;
    }

    @Override
    public boolean activateSecreto(Secretos secreto) {
        return false;
    }

    @Override
    public boolean attackLP(Esbirros esbirro) {
        return false;
    }

    @Override
    public void addCardToHand() {

    }

    @Override
    public void addNCardToHand(int n) {

    }

    @Override
    public void endPhase() {
        if (Carta.getBoard().isGameOver())
            return;
        if (this!=Carta.getBoard().getPlayer())
            return;
        this.endPhase();
    }

    @Override
    public boolean endTurn() {
        if (Carta.getBoard().isGameOver())
            return false;
        if (this!=Carta.getBoard().getPlayer())
            return false;
        return false;
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
