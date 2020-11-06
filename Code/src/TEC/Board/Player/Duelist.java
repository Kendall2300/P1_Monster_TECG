package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Exceptions.EsbirrosMultipleAttackException;
import TEC.Exceptions.NoEsbirrosSpaceException;
import TEC.Exceptions.NoHechizosSpaceException;
import TEC.Exceptions.WrongPhaseException;

/**
 *Duelist
 * Esta interfaz contiene todos los métodos que puede utilizar el player.
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public interface Duelist {
    /**
     * summonEsbirro
     * Este metodo revisa si se ha invocado un esbirro
     * @param esbirro Un objeto de tipo esbirro
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws NoEsbirrosSpaceException
     */
    public boolean summonEsbirro(Esbirros esbirro) throws WrongPhaseException, NoEsbirrosSpaceException;

    /**
     * setHechizo
     * Este método coloca un hechizo en el campo para seractivado luego
     * @param hechizo Un objeto de tipo Hechizo
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws NoHechizosSpaceException
     */
    public boolean setHechizo(Hechizos hechizo) throws WrongPhaseException, NoHechizosSpaceException;

    /**
     * activateHechizo
     * Este metodo activa un hechizo
     * @param hechizo Un objeto de tipo Hechizo
     * @param esbirro Un objeto de tipo esbirro
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws NoHechizosSpaceException
     */
    public boolean activateHechizo(Hechizos hechizo,Esbirros esbirro) throws WrongPhaseException, NoHechizosSpaceException;

    /**
     * declareAttack
     * Este metodo declara un ataque
     * @param esbirro Un objeto de tipo esbirro
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws EsbirrosMultipleAttackException
     */
    boolean declareAttack(Esbirros esbirro) throws WrongPhaseException, EsbirrosMultipleAttackException;

    /**
     * declareAttack
     * Este metodo declara un ataque contra un esbirro oponente
     * @param activeEsbirro Un objeto tipo esbirro del jugador activo o atacante
     * @param opponentEsbirro Un objeto tipo esbirro del jugadotr oponente
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws EsbirrosMultipleAttackException
     */
    boolean declareAttack(Esbirros activeEsbirro, Esbirros opponentEsbirro) throws WrongPhaseException, EsbirrosMultipleAttackException;

    /**
     * addCardToHand
     * Este metodo añade una carta a la mano
     */
    public void addCardToHand();

    /**
     * addNCardToHand
     * Este metodo añade una cantidad de cartas especifica
     * @param n Un entero mayor que 0
     */
    public void addNCardToHand(int n);

    /**
     * endPhase
     * Este metodo se encarga de terminar la fase actual
     */
    public void endPhase();

    /**
     * endTurn
     * Este metodo finaliza el turno sin necesidad de pasar por cada una de las fases
     * @return
     */
    public boolean endTurn();
}
