package trabajo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@XmlRootElement
public class Main {

	public static void main(String[] args) throws Exception {

		// Mostrar joc
		System.out.println("Mostrar joc");
		Joc joc1 = llegirJoc("resources/jugadores.xml");
		System.out.println(joc1);
		
		// Test canviarInicials
		System.out.println("\nTest canviarInicials");
		Joc joc2 = canviarInicials("resources/jugadores.xml", "Dani Fernandez", "AAA");
		System.out.println(joc2);
		
		// Test toggleDaltonic
		System.out.println("\nTest toggleDaltonic");
		Joc joc3 = toggleDaltonic("resources/jugadores.xml", "FUN");
		System.out.println(joc3);
		
		// Test afegeixJugador
		System.out.println("\nTest afegeixJugador");
		Joc joc4 = afegeixJugador("resources/jugadores.xml", joc1.jugadores.get(0));
		System.out.println(joc4);
		
		// Test mostrarClassificacio
		System.out.println("\nTest mostrarClassificacio");
		mostrarClassificacio("resources/jugadores.xml");
		
		// Test actualitzarClassificacio & alCarrer
		System.out.println("\nTest actualitzarClassificacio & alCarrer");
		alCarrer("resources/jugadores.xml", "Dani Fernandez");
		Joc joc5 = llegirJoc("resources/jugadores.xml");
		System.out.println(joc5);

		// Test afegeixPuntuacio
		System.out.println("\nTest afegeixPuntuacio");
		afegeixPuntuacio("resources/jugadores.xml", "Dani Fernandez", 123);
		Joc joc6 = llegirJoc("resources/jugadores.xml");
		System.out.println(joc6);
		
		// Test llistarEnemics
		System.out.println("\nTest llistarEnemics");
		llistarEnemics("resources/Enemics.json");
		
		// Test afegirEnemic
		System.out.println("\nTest afegirEnemic");
		System.out.println(llegirJSON("resources/Enemics.json"));
		afegirEnemic("resources/Enemics.json", "Marc", true, 2);
		System.out.println(llegirJSON("resources/Enemics.json"));
		
		// Test afegirKill
		System.out.println("\nTest afegirKill");
		System.out.println(llegirJSON("resources/Enemics.json"));
		afegirKill("resources/Enemics.json","Goomba",1.1);
		System.out.println(llegirJSON("resources/Enemics.json"));
		
		// Test AfegirPuntuacioEnBaseAPartida
		System.out.println("\nTest calcularPuntuacio");
		System.out.println("Before " + llegirJoc("resources/jugadores.xml"));
		AfegirPuntuacioEnBaseAPartida("resources/jugadores.xml", "Pedro Pepito", "resources/Enemics.json");		
		System.out.println("After  " + llegirJoc("resources/jugadores.xml"));
		
	}
	
	public static Joc llegirJoc(String nomFile) throws JAXBException {
		File f = new File("resources/jugadores.xml");
		JAXBContext context = JAXBContext.newInstance(Joc.class);
		Unmarshaller um = context.createUnmarshaller();
		return (Joc) um.unmarshal(f);
	}
	
	public static boolean escriureJoc(String nomFile, Joc joc) throws JAXBException {
		File f = new File(nomFile);
		JAXBContext context = JAXBContext.newInstance(Joc.class);
		Marshaller m = context.createMarshaller();
		m.marshal(joc, f);
		return true;
	}
	
	public static Joc canviarInicials(String nomFile, String nomJ, String novesI) throws JAXBException {
		Joc joc = llegirJoc(nomFile);
		for (Jugador jugador: joc.jugadores) {
			if (jugador.getNom().equals(nomJ)) {
				jugador.setInicials(novesI);
			}
		}
		return joc;
	}
	
	public static Joc toggleDaltonic(String nomFile, String inicialsJ) throws JAXBException {
		Joc joc = llegirJoc(nomFile);
		for (Jugador jugador: joc.jugadores){
			if(jugador.getInicials().equals(inicialsJ)){
				jugador.getConfiguracio().setMode_daltonic(!jugador.getConfiguracio().isMode_daltonic());
			}
		}
		return joc;
	}
	
	public static Joc afegeixJugador(String nomFile, Jugador jug) throws JAXBException{
		Joc joc = llegirJoc(nomFile);
		joc.jugadores.add(jug);
		return joc;
	}
	
	public static void mostrarClassificacio(String nomFile)throws JAXBException{
		Joc joc = llegirJoc(nomFile);
		for (Jugador jugador: joc.getJugadores()){
			System.out.println(jugador.getNom()+" "+jugador.getPuntuacions());
		}
	}
	
	public static Joc actualitzarClassificacio(Joc joc){
		ArrayList<Jugador> jugadores = joc.getJugadores();
		Collections.sort(jugadores);
		
		for (Jugador jugador: jugadores) {
			jugador.setPosicio(jugadores.indexOf(jugador)+1);
		}
		
		joc.setJugadores(jugadores);
		
		return joc;
	}
	
	
	public static void alCarrer(String nomFile, String nomJ) throws JAXBException {
		Joc joc = llegirJoc(nomFile);
		for (int i = 0; i < joc.jugadores.size()-1; i++) {
			if (joc.jugadores.get(i).getNom().equals(nomJ)) {
				
				joc.jugadores.remove(i);
				
				break;
			}
		}
		joc = actualitzarClassificacio(joc);
				escriureJoc(nomFile, joc);
	}
	
	
	public static void afegeixPuntuacio(String nomFile, String nomJugador, int punt) throws JAXBException{
		Joc j = llegirJoc(nomFile);
		for (Jugador jugador : j.getJugadores()) {
			if(jugador.getNom().equals(nomJugador)){
				ArrayList<Integer> puntuacions = jugador.getPuntuacions();
				puntuacions.add(punt);
				jugador.setPuntuacions(puntuacions);
				
			}
		}
		j = actualitzarClassificacio(j);
		escriureJoc(nomFile, j);
		
	}
	
	public static JSONArray llegirJSON(String nomFile) throws ParseException, org.json.simple.parser.ParseException{
		JSONParser parser = new JSONParser();
		try {
			JSONArray Enemics = (JSONArray) parser.parse(new FileReader(nomFile));
			return Enemics;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void escriureJSON(String nomFile, JSONArray llistaEnemics){
		try (FileWriter file = new FileWriter("Enemics.json")) {

			file.write(llistaEnemics.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void llistarEnemics(String nomFile) throws Exception{
		
		JSONArray enemics = llegirJSON(nomFile);
		for (Object enemic : enemics) {
			JSONObject temp = (JSONObject) enemic;
			System.out.println("Nom: " + temp.get("nom") + ", Punts Base: " + temp.get("puntsBase") + ", N. Morts: " + temp.get("numMorts"));
		}
		
	}
	
	public static void afegirEnemic(String nomFile, String nomEnemic, boolean elite, int puntsBase) throws ParseException, org.json.simple.parser.ParseException{
		JSONArray enemics = llegirJSON(nomFile);
		JSONObject enemic = new JSONObject();
		JSONArray bonus = new JSONArray();
		enemic.put("nom", nomEnemic);
		enemic.put("elite", elite);
		enemic.put("puntsBase", puntsBase);
		enemic.put("numMorts", 0);
		enemic.put("bonus", bonus);
		enemics.add(enemic);
		escriureJSON(nomFile,enemics);
		
	}
	
	public static void afegirKill(String nomFile, String nomEnemic, double bonus) throws ParseException, org.json.simple.parser.ParseException {
		JSONArray enemics = llegirJSON(nomFile);
		for (Object enemic : enemics) {
			JSONObject temp = (JSONObject) enemic;
			if (temp.get("nom").equals(nomEnemic)) {
				temp.put("numMorts", (long)temp.get("numMorts") + 1);
				ArrayList<Double> bonusList = ((ArrayList<Double>)temp.get("bonus"));
				bonusList.add(bonus);
				temp.put("bonus", bonusList);
				enemic = (Object)temp;
				System.out.println(enemics);
			}
		}
		escriureJSON(nomFile,enemics);
	}
	
	public static int calcularPuntuacio (String nomFile) throws Exception{
		 Double puntsTotals = 0.0;
		 JSONArray enemics = llegirJSON(nomFile);
		 
		 for (Object enemic : enemics) {
			JSONObject temp = (JSONObject) enemic;
			int puntsEnemic = 0;
			double puntPerMort = temp.get("puntsBase") instanceof Double ? (double)temp.get("puntsBase") : (double)((long)temp.get("puntsBase") * 1.0);
			
			JSONArray bonus = (JSONArray) temp.get("bonus");
			
			for (int i = 0; i < bonus.size(); i++) {
				puntPerMort *= bonus.get(i) instanceof Double ? (double)bonus.get(i) : (double)((long)bonus.get(i) * 1.0);
				puntsEnemic += puntPerMort;
			}
			
			if((boolean)temp.get("elite")){
				puntsEnemic *= 2;
			}
			
			puntsTotals += puntsEnemic;
			
		}
		 
		 return puntsTotals.intValue();
	}
	
	public static void AfegirPuntuacioEnBaseAPartida(String nomFitxerXML, String nomJugador, String nomFitxerJSON) throws Exception{
		try {
			int puntuacio = calcularPuntuacio(nomFitxerJSON);
			afegeixPuntuacio(nomFitxerXML,nomJugador,puntuacio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	 
}
