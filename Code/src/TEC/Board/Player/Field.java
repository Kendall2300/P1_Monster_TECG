package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.Hechizos;
import TEC.Cartas.Location;

import java.util.ArrayList;

import static TEC.Board.Player.Phase.MainPhase;

public class Field {
    private Phase phase=MainPhase;
    private ArrayList<Esbirros> esbirrosArea;
    private ArrayList<Carta> graveyard;
    private ArrayList<Carta> hand;
    private ArrayList<Hechizos> hechizosArea;
    //private final Deck deck;

    public Field(){
        esbirrosArea=new ArrayList<Esbirros>();
        hand=new ArrayList<Carta>();
        graveyard=new ArrayList<Carta>();
        //deck=new Deck();
    }
    public boolean addEsbirroToField(Esbirros esbirro){
        if(!(hand.contains(esbirro))&& Esbirros.getLocation()== Location.Hand){
            return false;
        }
        if(esbirrosArea.size()>=3){
            //throw new NoEsbirrosSpaceException();
        }
        if(phase==Phase.Battle);
            //throw new WrongPhaseException();
        hand.remove(esbirro);
        esbirro.setLocation(Location.Field);
        esbirrosArea.add(esbirro);
        return true;
    }
    public void removeEsbirroToGraveyard(Esbirros esbirro){
        if(esbirrosArea.contains(esbirro)){
            esbirrosArea.remove(esbirro);
            graveyard.add(esbirro);
            esbirro.setLocation(Location.Graveyard);
        }
    }
    public void removeHechizoToGraveyard(Hechizos hechizo){
        if(!hechizosArea.contains(hechizo))
            return;
        hechizosArea.remove(hechizo);
        graveyard.add(hechizo);
        hechizo.setLocation(Location.Graveyard);
    }
    public boolean addHechizoToField(Hechizos hechizo, Esbirros esbirro){
        if(!hand.contains(hechizo))
            return false;
        if (hechizosArea.size()>=3);
            //throw new NoSpellSpaceException();
        if (phase==Phase.Battle);
            //throw new WrongPhaseException();
        hand.remove(hechizo);
        hechizosArea.add(hechizo);
        hechizo.setLocation(Location.Field);
        return true;
    }
    public boolean activateHechizo(Hechizos hechizo, Esbirros esbirro){
        if(phase==Phase.Battle);
            //throw new WrongPhaseException();
        hechizo.action(esbirro);
        removeHechizoToGraveyard(hechizo);
        return true;
    }
    public boolean declareAttack(Esbirros e1, Esbirros e2){
        if (phase!=Phase.Battle);
            //throw new WrongPhaseException();
        ArrayList<Esbirros> oppEsbirrosArea=Carta.getBoard().getOpponentPlayer().getField().esbirrosArea;
        if(e2==null&&oppEsbirrosArea.size()==0)
            e1.action();
        else if(e2!=null&&oppEsbirrosArea.contains(e2))
            e1.action(e2);
        else
            return false;
        if (Carta.getBoard().getPlayer().getLifePoints()<=0){
            Carta.getBoard().getPlayer().setLifePoints(0);
            Carta.getBoard().setWinner(Carta.getBoard().getOpponentPlayer());
        }
        if (Carta.getBoard().getOpponentPlayer().getLifePoints()<=0){
            Carta.getBoard().getOpponentPlayer().setLifePoints(0);
            Carta.getBoard().setWinner(Carta.getBoard().getPlayer());
        }
        return true;
    }

    public void endPhase(){
        switch (phase){
            case MainPhase:
                setPhase(Phase.Battle);
                break;
            case Battle:
                setPhase(Phase.EndTurn);
        }
    }
    public void endTurn() {
        phase = Phase.MainPhase;
        Carta.getBoard().nextPlayer();
    }
    public  void addCardToHand(){

    }
    public void addNCardToHand(int n){

    }
    public Phase getPhase(){
        return phase;
    }
    private void setPhase(Phase phase) {
        this.phase=phase;
    }

    public ArrayList<Esbirros> getEsbirrosArea() {
        return esbirrosArea;
    }

    public ArrayList<Carta> getGraveyard() {
        return graveyard;
    }

    public ArrayList<Carta> getHand() {
        return hand;
    }

    public ArrayList<Hechizos> getHechizosArea() {
        return hechizosArea;
    }

}
