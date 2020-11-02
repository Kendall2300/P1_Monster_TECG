package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Secretos.Secretos;

public interface Duelist {
    public boolean summonEsbirro(Esbirros esbirro, Carta mana_cost);
    public boolean activateHechizo(Hechizos hechizo, Carta mana_cost);
    public boolean activateSecreto(Secretos secreto, Carta mana_cost);
    public boolean attackLP(Esbirros esbirro);
    public void addCardToHand();
    public void addNCardToHand(int n);
    public void endPhase();
    public boolean endTurn();
}
