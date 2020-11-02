package TEC.Board;

import TEC.Cartas.Carta;
import TEC.Board.Player.Player;
import java.util.Random;

public class Board {
    private Player Player;
    private Player OpponentPlayer;
    private Player winner;
    public Board(){
        Carta.setBoard(this);
    }
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
    public void startGame(Player player1,Player player2){
        player1.addNCardToHand(4);
        player2.addNCardToHand(4);

        whoStarts(player1,player2);

        Player.addCardToHand();
    }
    public void nextPlayer(){
        Player temp= Player;
        Player=OpponentPlayer;
        OpponentPlayer=temp;
        Player.addCardToHand();
    }
    public boolean isGameOver(){
        if (winner!=null) return true;
        return false;
    }

    public Player getPlayer() {
        return Player;
    }

    public void setPlayer(Player player) {
        this.Player = player;
    }

    public Player getOpponentPlayer() {
        return OpponentPlayer;
    }

    public void setOpponentPlayer(Player opponentPlayer) {
        OpponentPlayer = opponentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        if (isGameOver()) return;
        this.winner = winner;
    }
}
