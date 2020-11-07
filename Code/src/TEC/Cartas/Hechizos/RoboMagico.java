package TEC.Cartas.Hechizos;

import TEC.Cartas.Esbirros;

public class RoboMagico extends Hechizos{
    public RoboMagico(String name, int mana_cost) {
        super(name, mana_cost);
    }

    @Override
    public void action(Esbirros esbirro) {
        getBoard().getPlayer().addCardToHand();
    }
}
