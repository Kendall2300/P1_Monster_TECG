package TEC.Board;

import TEC.Cartas.Carta;
import TEC.Board.Player.Player;
import java.util.Random;

/**
 * Board
 * Esta clase se encarga de construir el campo de juego
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class Board {
    private Player Player;
    private Player OpponentPlayer;
    private Player winner;

    /**
     * Board
     * Este es el metodo constructor de la clase se encarga de generar el campo de juego.
     */
    public Board(){
        Carta.setBoard(this);
    }

    /**
     * whoStarts
     * Este metodo se encarga de escoger aleatoriamente cual jugador empieza la partida
     * @param player1 Un objeto de tipo Player
     * @param player2 Un objeto de tipo Plater
     */
    public void whoStarts(Player player1, Player player2){
        Random random=new Random();

        if (random.nextInt(2)==0){
            Player=player1;
            OpponentPlayer=player2;
        }else{
            Player=player2;
            OpponentPlayer=player1;
        }
    }

    /**
     * startGame
     * Este metodo se encarga de lanzar o empezar el juego
     * @param player1 Un objeto de tipo Player
     * @param player2 Un objeto de tipo Player
     */
    public void startGame(Player player1,Player player2){
        player1.addNCardToHand(4);
        player2.addNCardToHand(4);

        whoStarts(player1,player2);

        Player.addCardToHand();
    }

    /**
     * nextPlayer
     * Este metodo consigue y define cual es el siguinte en jugar su turno
     */
    public void nextPlayer(){

        Player temp= Player;
        Player=OpponentPlayer;
        OpponentPlayer=temp;
        Player.addCardToHand();
    }

    /**
     * isGameOver
     * Este metodo confirma si el juego ya ha terminado
     * @return Un boolean
     */
    public boolean isGameOver(){
        if (winner!=null){
            return true;
        }
        return false;
    }

    /**
     * getPlayer
     * Este metodo se encarga de conseguir al jugador actual
     * @return Un objeto de tipo Player
     */
    public Player getPlayer() {
        return Player;
    }

    /**
     * setPlayer este metodo se encarga de definir al jugador actual
     * @param player Un objeto de tipo Player
     */
    public void setPlayer(Player player) {
        this.Player = player;
    }

    /**
     * getOpponentPlayer
     * Este metodo se encarga de obtener al jugador Contrario
     * @return Un objeto de tipo Player
     */
    public Player getOpponentPlayer() {
        return OpponentPlayer;
    }

    /**
     * setOpponentPlayer
     * Este metodo se encarga de colocar al jugador contrario
     * @param opponentPlayer Un objeto de tipo Player
     */
    public void setOpponentPlayer(Player opponentPlayer) {
        OpponentPlayer = opponentPlayer;
    }

    /**
     * getWinner
     * Este metodo se encarga de conseguir al jugador que ha ganado la partida
     * @return Un objeto de tipo Player
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * setWinner
     * Este metodo se colocar al jugador ganador de la partida
     * @param winner Un objeto de tipo Player
     */
    public void setWinner(Player winner) {
        if (isGameOver()) return;
        this.winner = winner;
    }
}
