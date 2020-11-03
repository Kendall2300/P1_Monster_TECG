package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Secretos.Secretos;

public interface Duelist {
    boolean declareAttack(Esbirros esbirro);

    boolean declareAttack(Esbirros activeEsbirro, Esbirros opponentEsbirro);

    public boolean summonEsbirro(Esbirros esbirro);
    public boolean activateHechizo(Hechizos hechizo);
    public boolean activateSecreto(Secretos secreto);
    public boolean attackLP(Esbirros esbirro);
    public void addCardToHand();
    public void addNCardToHand(int n);
    public void endPhase();
    public boolean endTurn();
}
