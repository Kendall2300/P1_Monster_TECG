package TEC.Cartas;

public class Esbirros extends Carta{
    private Integer attack;
    private Boolean attacked;

    public Esbirros(String name, int mana_cost, Integer attack, Boolean attacked) {
        super(name, mana_cost);
        this.attack = attack;
        this.attacked=attacked;
    }
    public void action() {
        //attackLifePoints(esbirro);
        this.setAttacked(true);
    }

    @Override
    public void action(Esbirros esbirro) {
        if(esbirro!=null){
            attackLifePoints(esbirro);
        }
        this.setAttacked(true);
    }

    public void attackLifePoints(Esbirros esbirro){
        //int lp=getBoard().getOpponetPlayer().getlifePoints();
        //getBoard().getOpponentPlayer().setLifePoints(lp-this.getAttack());
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Boolean getAttacked() {
        return attacked;
    }

    public void setAttacked(Boolean attacked) {
        this.attacked = attacked;
    }
}
