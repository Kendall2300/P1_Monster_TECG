package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Exceptions.EsbirrosMultipleAttackException;
import TEC.Exceptions.NoEsbirrosSpaceException;
import TEC.Exceptions.NoHechizosSpaceException;
import TEC.Exceptions.WrongPhaseException;

public interface Duelist {
    public boolean summonEsbirro(Esbirros esbirro) throws WrongPhaseException, NoEsbirrosSpaceException;
    public boolean setHechizo(Hechizos hechizo) throws WrongPhaseException, NoHechizosSpaceException;
    public boolean activateHechizo(Hechizos hechizo,Esbirros esbirro) throws WrongPhaseException, NoHechizosSpaceException;
    boolean declareAttack(Esbirros esbirro) throws WrongPhaseException, EsbirrosMultipleAttackException;
    boolean declareAttack(Esbirros activeEsbirro, Esbirros opponentEsbirro) throws WrongPhaseException, EsbirrosMultipleAttackException;
    public void addCardToHand();
    public void addNCardToHand(int n);
    public void endPhase();
    public boolean endTurn();
}
