package TEC;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson=new Gson();
        /*List<Esbirros> esbirrosList=new ArrayList<>();
        esbirrosList.add(new Esbirros("Abismo Reluciente",25,100));
        esbirrosList.add(new Esbirros("Adicto Kraken",15,75));
        esbirrosList.add(new Esbirros("Aguja Asesina",15,75));
        esbirrosList.add(new Esbirros("Bebé Dragón",15,75));
        esbirrosList.add(new Esbirros("Bestia Fundida",5,25));
        esbirrosList.add(new Esbirros("Bestia Amfibia",5,25));
        esbirrosList.add(new Esbirros("Craneo Invocado",210,300));
        esbirrosList.add(new Esbirros("Dragon Tapis",210,300));
        esbirrosList.add(new Esbirros("Dragon Sobrio",210,350));
        esbirrosList.add(new Esbirros("El Prohibido",1000,999));
        Carta Esbirrios=new Carta(esbirrosList);
        String json=gson.toJson(Esbirrios);
        //System.out.println(json);

        JsonReader jsonReader = null;
        try {
            jsonReader = new JsonReader(new FileReader("Esbirros.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(jsonReader);*/

    }
}
