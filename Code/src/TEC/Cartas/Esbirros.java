package TEC.Cartas;

import TEC.Board.Player.Player;

/**
 * Esbirros
 * Esta clase herada los metodos de Carta y será la encargada de construir a todos los Esbirros
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class Esbirros extends Carta{
    private Integer attack;
    private Boolean attacked;

    /**
     * Esbirros
     * El metodo constructor que coloca los valores para los Esbirros que se construirán
     * @param name Un string que será el nombre del Esbirro
     * @param mana_cost Un entro que será el costo de jugar la carta
     * @param attack Un entero que será el attaque o daño que podrá ocasionar el Esbirro
     */
    public Esbirros(String name, int mana_cost, int attack) {
        super(name, mana_cost);
        this.attack = attack;
        this.attacked=false;
    }

    /**
     * action
     * Este metodo define si el esbirro atacó o no e intentará dañar al oponente.
     */
    public void action() {
        attackLifePoints();
        this.setAttacked(true);
    }

    /**
     * action
     * Este metodo comprueba si el esbirro existe para atacar con el mismo
     * @param esbirro Un objeto de tipo Esbirros
     */
    @Override
    public void action(Esbirros esbirro) {
        if(esbirro!=null){
            attackEsbirro(esbirro);
        }
        this.setAttacked(true);
    }

    /**
     * attackLifePoints
     * Este metodo permite influir puntos de daño a la vida del oponente
     */
    public void attackLifePoints(){
        int lp=getBoard().getOpponentPlayer().getLifePoints();
        getBoard().getOpponentPlayer().setLifePoints(lp-this.getAttack());
    }

    /**
     * attackEsbirro
     * Este metodo permite atacar a uno de los ebirros del oponente
     * @param target Un objeto de tipo esbirro que será el objetivo a atacar
     */
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

    /**
     * isAttacked
     * Este metodo comprueba si el esbirro ha atacado este turno
     * @return Un boolean
     */
    public boolean isAttacked(){
        return attacked;
    }

    /**
     * getAttack
     * Este metodo obtiene el valor de ataque de un esbirro
     * @return Un entero con el ataque del esbirro correspondiente
     */
    public Integer getAttack() {
        return attack;
    }

    /**
     * setAttack
     * Este metodo coloca un nuevo valor del ataque de un esbirro
     * @param attack Un entero con el nuevo ataque del esbirro
     */
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    /**
     * getAttacked
     * Este metetodo obtiene si un esbirro ya ha atacado
     * @return Un boolean
     */
    public Boolean getAttacked() {
        return attacked;
    }

    /**
     * setAttacked
     * Este metodo coloca si un esbirro ya ha atacado este turno
      * @param attacked Un boolean
     */
    public void setAttacked(Boolean attacked) {
        this.attacked = attacked;
    }

}
