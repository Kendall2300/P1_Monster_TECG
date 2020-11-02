package TEC.Cartas;

import TEC.Board.Player.Player;

public class Esbirros extends Carta{
    private Integer attack;
    private Boolean attacked;

    public Esbirros(String name, int mana_cost, int attack) {
        super(name, mana_cost);
        this.attack = attack;
        this.attacked=false;
    }
    public void action() {
        attackLifePoints();
        this.setAttacked(true);
    }

    @Override
    public void action(Esbirros esbirro) {
        if(esbirro!=null){
            attackEsbirro(esbirro);
        }
        this.setAttacked(true);
    }

    public void attackLifePoints(){
        int lp=getBoard().getOpponentPlayer().getLifePoints();
        getBoard().getOpponentPlayer().setLifePoints(lp-this.getAttack());
    }
    public void attackEsbirro(Esbirros target){
        Player active=getBoard().getPlayer();
        Player opponent=getBoard().getOpponentPlayer();
        if (this.getAttack()>target.getAttack()){
            int damage=this.getAttack()-target.getAttack();
            opponent.getField().removeEsbirroToGraveyard(this);
            int lp = opponent.getLifePoints();
            opponent.setLifePoints(lp-damage);
        }else if(this.getAttack()==target.getAttack()){
            active.getField().removeEsbirroToGraveyard(this);
            opponent.getField().removeEsbirroToGraveyard(target);
            this.setAttacked(true);
        }else{
            int damage= target.getAttack()-this.getAttack();
            active.getField().removeEsbirroToGraveyard(this);
            int lp=active.getLifePoints();
            active.setLifePoints(lp-damage);
        }
    }
    public boolean isAttacked(){
        return attacked;
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
