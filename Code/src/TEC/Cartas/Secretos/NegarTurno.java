package TEC.Cartas.Secretos;

import TEC.Cartas.Esbirros;

public class NegarTurno extends Secretos{
    public NegarTurno(String name, int mana_cost, String efecto) {
        super(name, mana_cost, efecto);
    }

    @Override
    public void action(Esbirros esbirro) {

    }
}
