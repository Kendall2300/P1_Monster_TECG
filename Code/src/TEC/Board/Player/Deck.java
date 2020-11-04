package TEC.Board.Player;

import TEC.Cartas.Carta;
import TEC.Cartas.Esbirros;
import TEC.Cartas.Hechizos.*;
import TEC.Cartas.Location;
import TEC.Exceptions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {
    private static ArrayList<Carta> esbirros;
    private static ArrayList<Carta> hechizos;

    private static String esbirrospath = "src/Datos/EsbirrosDatabase.csv";
    private static String hechizospath = "src/Datos/HechizosDatabase.csv";

    private final ArrayList<Carta> deck;
    int trials = 0;

    public Deck() throws IOException, NumberFormatException, UnexpectedFormatException {
        if ((esbirros == null) || (hechizos == null)) {

            Scanner sc = new Scanner(System.in);

            while (true) {

                try {

                    esbirros = loadCardsFromFile(Deck.getMonstersPath());
                    hechizos = loadCardsFromFile(Deck.getSpellsPath());
                    break;

                } catch (UnexpectedFormatException e) {

                    if (trials >= 3) {
                        sc.close();
                        throw e;
                    }

                    System.out.println("Error in reading from file "
                            + e.getSourceFile() + " at line "
                            + e.getSourceLine());
                    System.out.println(e.getMessage());
                    System.out.println("Please enter another path:");

                    trials++;

                    if (e.getSourceFile().equalsIgnoreCase(
                            Deck.getMonstersPath())) {
                        Deck.setMonstersPath(sc.nextLine());
                    }
                    if (e.getSourceFile()
                            .equalsIgnoreCase(Deck.getSpellsPath())) {
                        Deck.setSpellsPath(sc.nextLine());
                    }

                } catch (FileNotFoundException e) {

                    if (trials >= 3) {
                        sc.close();
                        throw e;
                    }

                    String s = (esbirros == null) ? Deck.getMonstersPath()
                            : Deck.getSpellsPath();

                    System.out.println("The file \"" + s + "\" is not found.");
                    System.out.println("Please enter another path:");

                    trials++;
                    String path = sc.nextLine();

                    if (esbirros == null)
                        Deck.setMonstersPath(path);
                    else
                        Deck.setSpellsPath(path);

                }

            }

            sc.close();

        }

        deck = new ArrayList<Carta>();
        buildDeck(esbirros, hechizos);
        shuffleDeck();
    }

    public ArrayList<Carta> loadCardsFromFile(String path) throws IOException,
            UnexpectedFormatException {

        ArrayList<Carta> temp = new ArrayList<Carta>();

        String line;

        BufferedReader br = new BufferedReader(new FileReader(path));

        int lineNumber = 0;

        while ((line = br.readLine()) != null) {

            lineNumber++;

            String[] cardInfo = line.split(";");

            if (cardInfo.length == 0) {

                br.close();
                throw new MissingFieldException(
                        "The number of fields in the line did not match the expected.",
                        path, lineNumber);

            } else {

                if (cardInfo[0].equalsIgnoreCase("Esbirro")
                        && cardInfo.length != 4) {

                    br.close();
                    throw new MissingFieldException(
                            "The number of fields in the line did not match the expected.",
                            path, lineNumber);

                } else if (cardInfo[0].equalsIgnoreCase("Hechizos")
                        && cardInfo.length != 3) {

                    br.close();
                    throw new MissingFieldException(
                            "The number of fields in the line did not match the expected.",
                            path, lineNumber);

                }
            }

            for (int i = 0; i < cardInfo.length; i++)
                if (cardInfo[i].equals("") || cardInfo[i].equals(" ")) {

                    br.close();
                    throw new EmptyFieldException("Empty Field.", path,
                            lineNumber, i + 1);

                }

            if (cardInfo[0].contains("Esbirros")) {

                temp.add(new Esbirros(cardInfo[1], Integer.parseInt(cardInfo[2]), Integer
                        .parseInt(cardInfo[3])));

            }else{
                if (!cardInfo[0].contains("Hechizos")){
                    br.close();
                    throw new UnknownCartaTypeException("Unknown Card Type",path,lineNumber,cardInfo[0]);
                }
                switch (cardInfo[1]){
                    case "ChocoMilk":
                        temp.add(new ChocoMilk(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "Congelar":
                        temp.add(new Congelar(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "Curar":
                        temp.add(new Curar(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "Desmadre":
                        temp.add(new Desmadre(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "El_gran_Keto":
                        temp.add(new El_gran_Keto(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "FrioPolar":
                        temp.add(new FrioPolar(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "LlamadaImpura":
                        temp.add(new LlamadaImpura(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "PoderSupremo":
                        temp.add(new PoderSupremo(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "RobarOponente":
                        temp.add(new RobarOponente(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "RoboMagico":
                        temp.add(new RoboMagico(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "Aguante":
                        temp.add(new Aguante(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "CilindrosMagicos":
                        temp.add(new CilindrosMagicos(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "DonDuende":
                        temp.add(new DonDuende(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "ElLoco":
                        temp.add(new ElLoco(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "ElVendado":
                        temp.add(new ElVendado(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "HerramientasBrayan":
                        temp.add(new HerramientasBrayan(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "Joker":
                        temp.add(new Joker(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "NegarAtaque":
                        temp.add(new NegarAtaque(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "NegarTurno":
                        temp.add(new NegarTurno(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    case "SoloPostres":
                        temp.add(new SoloPostres(cardInfo[1], Integer.parseInt(cardInfo[2])));
                        break;
                    default:
                        throw new UnknownHechizosException("Unknown Spell card",
                                path, lineNumber, cardInfo[1]);
                }
            }
        }
        br.close();

        return (temp);
    }



    private void buildDeck(ArrayList<Carta> esbirros, ArrayList<Carta> hechizos ) {

        int esbirrosQouta = 10;
        int hechizosQouta = 10;

        Random r = new Random();

        for (; esbirrosQouta > 0; esbirrosQouta--) {

            Esbirros monster = (Esbirros) esbirros.get(r.nextInt(esbirros
                    .size()));

            Esbirros clone = new Esbirros(monster.getName(),
                    monster.getAttack(), monster.getMana_cost());
            clone.setHidden(monster.isHidden());
            clone.setLocation(Location.Deck);

            deck.add(clone);

        }

        for (; hechizosQouta > 0; hechizosQouta--) {

            Carta spell = hechizos.get(r.nextInt(hechizos.size()));

            Hechizos clone;

            if (spell instanceof ChocoMilk) {

                clone = new ChocoMilk(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof Congelar) {

                clone = new Congelar(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof Desmadre) {

                clone = new Desmadre(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof El_gran_Keto) {

                clone = new El_gran_Keto(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof Curar) {

                clone = new Curar(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof FrioPolar) {

                clone = new FrioPolar(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof LlamadaImpura) {

                clone = new LlamadaImpura(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof PoderSupremo) {

                clone = new PoderSupremo(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof RobarOponente) {

                clone = new RobarOponente(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof RoboMagico) {

                clone = new RoboMagico(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }
            if (spell instanceof Aguante) {

                clone = new Aguante(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof CilindrosMagicos) {

                clone = new CilindrosMagicos(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof DonDuende) {

                clone = new DonDuende(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof ElLoco) {

                clone = new ElLoco(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof ElVendado) {

                clone = new ElVendado(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof HerramientasBrayan) {

                clone = new HerramientasBrayan(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof Joker) {

                clone = new Joker(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof NegarAtaque) {

                clone = new NegarAtaque(spell.getName(),
                        spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof NegarTurno) {

                clone = new NegarTurno(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }

            if (spell instanceof SoloPostres) {

                clone = new SoloPostres(spell.getName(), spell.getMana_cost());
                clone.setLocation(Location.Deck);
                deck.add(clone);
                continue;

            }
        }
    }

    private void shuffleDeck() {

        Collections.shuffle(deck);

    }

    public ArrayList<Carta> drawNCards(int n) {

        ArrayList<Carta> cards = new ArrayList<Carta>(n);

        for (int i = 0; i < n; i++)
            cards.add(deck.remove(0));

        return (cards);

    }

    public Carta drawOneCard() {
        return (deck.remove(0));

    }

    public static ArrayList<Carta> getMonsters() {
        return esbirros;
    }

    public static void setMonsters(ArrayList<Carta> esbirros) {
        Deck.esbirros = esbirros;
    }

    public static ArrayList<Carta> getSpells() {
        return hechizos;
    }

    public static void setSpells(ArrayList<Carta> hechizos) {
        Deck.hechizos = hechizos;
    }

    public ArrayList<Carta> getDeck() {
        return deck;
    }

    public static String getMonstersPath() {
        return esbirrospath;
    }

    public static void setMonstersPath(String esbirrospath) {
        Deck.esbirrospath = esbirrospath;
    }

    public static String getSpellsPath() {
        return hechizospath;
    }

    public static void setSpellsPath(String hechizospath) {
        Deck.hechizospath = hechizospath;
    }

}
