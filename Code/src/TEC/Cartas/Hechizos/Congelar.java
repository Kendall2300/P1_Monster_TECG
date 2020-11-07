package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class Congelar extends Hechizos{

    public Congelar(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) { //Falta
        getBoard().getOpponentPlayer().endTurn();
    }
}
