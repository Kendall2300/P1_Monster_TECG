package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Secretos.Secretos;
import TEC.Exceptions.NoEsbirrosSpaceException;
import TEC.Exceptions.NoHechizosSpaceException;
import TEC.Exceptions.WrongPhaseException;

public interface Duelist {
    boolean declareAttack(Esbirros esbirro) throws WrongPhaseException;
    boolean declareAttack(Esbirros activeEsbirro, Esbirros opponentEsbirro) throws WrongPhaseException;
    public boolean summonEsbirro(Esbirros esbirro) throws WrongPhaseException, NoEsbirrosSpaceException;
    public boolean activateHechizo(Hechizos hechizo,Esbirros esbirro) throws WrongPhaseException, NoHechizosSpaceException;
    public boolean attackLP(Esbirros esbirro);
    public void addCardToHand();
    public void addNCardToHand(int n);
    public void endPhase();
    public boolean endTurn();
}
