package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Location;
import TEC.Exceptions.*;

import java.io.IOException;
import java.util.ArrayList;

import static TEC.Board.Player.Phase.MainPhase;

/**
 * Field
 * Esta clase se encarga de construir o generar el campo para cada jugador
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class Field {
    private Phase phase=MainPhase;
    private final Deck deck;
    private ArrayList<Esbirros> esbirrosArea;
    private ArrayList<Hechizos> hechizosArea;
    private ArrayList<Carta> graveyard;
    private ArrayList<Carta> hand;

    /**
     * Field
     * Este metodo contruye el campo para los jugadores
     * @throws IOException
     * @throws UnexpectedFormatException
     */
    public Field()throws IOException, UnexpectedFormatException {

        esbirrosArea=new ArrayList<Esbirros>();
        hechizosArea=new ArrayList<Hechizos>();
        hand=new ArrayList<Carta>();
        graveyard=new ArrayList<Carta>();
        deck=new Deck();
    }

    /**
     * addEsbirroToField
     * Este metodo se encarga de añadir los esbirros al campo de juego
     * @param esbirro objeto de tipo Esbirros
     * @param isHidden Un boolean
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws NoEsbirrosSpaceException
     */
    public boolean addEsbirroToField(Esbirros esbirro, boolean isHidden) throws WrongPhaseException, NoEsbirrosSpaceException {
        if(!(hand.contains(esbirro))&& Esbirros.getLocation()== Location.Hand){
            return false;
        }
        if(esbirrosArea.size()>=5){
            throw new NoEsbirrosSpaceException();
        }
        if(phase==Phase.Battle) {
            throw new WrongPhaseException();
        }

        hand.remove(esbirro);
        esbirro.setHidden(isHidden);
        esbirro.setLocation(Location.Field);
        esbirrosArea.add(esbirro);
        return true;
    }

    /**
     * removeEsbirroToGraveyard
     * Este metodo se encarga de remover a un esbirro del campo y mandarlo al cementerio
     * @param esbirro Un objeto tipo Esbirros
     */
    public void removeEsbirroToGraveyard(Esbirros esbirro){
        if(esbirrosArea.contains(esbirro)){
            esbirrosArea.remove(esbirro);
            graveyard.add(esbirro);
            esbirro.setLocation(Location.Graveyard);
        }
    }

    /**
     * addHechizoToField
     * Este metodo añade un hechizo al campo de juego
     * @param hechizo Un objeto de tipo Hechizos
     * @param esbirro Un objeto de tipo Esbirros
     * @param hidden
     * @return
     * @throws WrongPhaseException
     * @throws NoHechizosSpaceException
     */
    public boolean addHechizoToField(Hechizos hechizo, Esbirros esbirro,boolean hidden) throws WrongPhaseException, NoHechizosSpaceException {
        if(!hand.contains(hechizo)){
            return false;
        }

        if (hechizosArea.size()>=5){
            throw new NoHechizosSpaceException();
        }

        if (phase==Phase.Battle){
            throw new WrongPhaseException();
        }

        hand.remove(hechizo);
        hechizosArea.add(hechizo);
        hechizo.setLocation(Location.Field);
        if(!hidden){
            return activateSetHechizo(hechizo,esbirro);
        }

        return true;
    }

    /**
     * activateSetHechizo
     * Este metodo activa un Hechizo o Secreto que se haya colocado en el campo
     * @param hechizo Un objeto de tipo Hechizos
     * @param esbirro Un objeto de tipo Esbirros
     * @return Un boolean
     * @throws WrongPhaseException
     */
    public boolean activateSetHechizo(Hechizos hechizo, Esbirros esbirro) throws WrongPhaseException {
        if (!hechizosArea.contains(hechizo)){
            return false;
        }

        if(phase==Phase.Battle){
            throw new WrongPhaseException();
        }

        hechizo.action(esbirro);
        removeHechizoToGraveyard(hechizo);

        return true;
    }

    /**
     * removeHechizoToGraveyard
     * Este metodo remueve los Hechizos y Secretos jugados al cementerio
     * @param hechizo un objeto de tipo Hechizos
     */
    public void removeHechizoToGraveyard(Hechizos hechizo){
        if(!hechizosArea.contains(hechizo))
            return;

        hechizosArea.remove(hechizo);
        graveyard.add(hechizo);
        hechizo.setLocation(Location.Graveyard);
    }

    /**
     * declareAttack
     * Este metodo se encarga de atacar a un esbirro del rival
     * @param e1 Un objeto de tipo Esbirros del jugador actual
     * @param e2 Un objeto de tipo Esbirros del jugador contrario
     * @return Un boolean
     * @throws WrongPhaseException
     * @throws EsbirrosMultipleAttackException
     */
    public boolean declareAttack(Esbirros e1, Esbirros e2) throws WrongPhaseException, EsbirrosMultipleAttackException {
        if (phase!=Phase.Battle){
            throw new WrongPhaseException();
        }

        if (e1.isAttacked()){
            throw new EsbirrosMultipleAttackException();
        }

        ArrayList<Esbirros> oppEsbirrosArea = Carta.getBoard().getOpponentPlayer().getField().esbirrosArea;

        if(e2==null&&oppEsbirrosArea.size()==0){
            e1.action();
        }else if(e2!=null&&oppEsbirrosArea.contains(e2)) {
            e1.action(e2);
        }else {
            return false;
        }
        if (Carta.getBoard().getPlayer().getLifePoints() <= 0) {
            Carta.getBoard().getPlayer().setLifePoints(0);
            Carta.getBoard().setWinner(Carta.getBoard().getOpponentPlayer());
        }
        if (Carta.getBoard().getOpponentPlayer().getLifePoints() <= 0) {
            Carta.getBoard().getOpponentPlayer().setLifePoints(0);
            Carta.getBoard().setWinner(Carta.getBoard().getPlayer());
        }

        return true;
    }

    /**
     * enPhase
     * Este metodo termina la fase actual para pasar tanto a la de battala como a la de segunda main
     */
    public void endPhase(){
        switch (phase){
            case MainPhase:
                setPhase(Phase.Battle);
                break;
            case Battle:
                setPhase(Phase.Main2);
                break;
            case Main2:
                endTurn();
                break;
        }
    }

    /**
     * endTurn
     * Este metodo termina instantaneamente tu turno sin importar la fase actual
     */
    public void endTurn() {
        phase = MainPhase;

        for (Esbirros e: esbirrosArea){
            e.setAttacked(false);
        }

        Carta.getBoard().nextPlayer();
    }

    /**
     * addCardToHand
     * Este metodo añade una carta a la mano del jugador
     */
    public  void addCardToHand(){
        if(deck.getDeck().size()==0){
            if (this==Carta.getBoard().getPlayer().getField()){
                Carta.getBoard().setWinner(Carta.getBoard().getOpponentPlayer());
            }else{
                Carta.getBoard().setWinner((Carta.getBoard().getPlayer()));
            }
            return;
        }
        Carta temp=deck.drawOneCard();
        hand.add(temp);
        temp.setLocation(Location.Hand);
    }

    /**
     * addNCardToHand
     * Este metodo añade una cantidad de cartas especificas
     * @param n Un entero
     */
    public void addNCardToHand(int n){
        for (int j=0;j<n;j++){
            addCardToHand();
        }
    }

    /**
     * getPhase
     * Este metodo devuelve la fase actual
     * @return
     */
    public Phase getPhase(){
        return phase;
    }

    /**
     * Este metodo coloca la fase actual
     * @param phase Un objeto de tipo Phase
     */
    private void setPhase(Phase phase) {
        this.phase=phase;
    }

    /**
     * getDeck
     * Este metodo obtiene el deck de los jugadore
     * @return Un objeto de tipo Deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * getEsbirrosArea
     * Este metodo consigue el area designada para colocar esbirros en el campo
     * @return Un array de Esbirros
     */
    public ArrayList<Esbirros> getEsbirrosArea() {
        return esbirrosArea;
    }

    /**
     * getHechizosArea
     * Este metodo consigue el area de Hechizos del jugador
     * @return Un array de Hechizos
     */
    public ArrayList<Hechizos> getHechizosArea() {
        return hechizosArea;
    }

    /**
     * getHand
     * Este metodo consigue la mano del jugador
     * @return Un array de la clase Carta
     */
    public ArrayList<Carta> getHand() {
        return hand;
    }

    /**
     * getGraveyard
     * Este metodo consigue el cementerio del jugador
     * @return Un array de la clase Carta
     */
    public ArrayList<Carta> getGraveyard() {
        return graveyard;
    }

    /*public boolean activateHechizo(Hechizos hechizo, Esbirros esbirro) throws WrongPhaseException {
        if(phase==Phase.Battle)
            throw new WrongPhaseException();
        hechizo.action(esbirro);
        removeHechizoToGraveyard(hechizo);
        return true;
    }*/

}
