package TEC.Cartas.Hechizos;

import TEC.Board.Player.Phase;
import TEC.Cartas.Esbirros;

public class FrioPolar extends Hechizos{
    public FrioPolar(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        if (getBoard().getOpponentPlayer().getField().getPhase() == Phase.Battle){
            getBoard().getOpponentPlayer().endPhase();
        }

    }
}
