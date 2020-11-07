package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class ChocoMilk extends Hechizos{
    public ChocoMilk(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) { // Completo
        getBoard().getOpponentPlayer().setLifePoints(getBoard().getOpponentPlayer().getLifePoints() - 50);

    }
}
