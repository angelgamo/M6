package XMLJSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class XML2JSON {
	public static void main(String[] args) throws JAXBException {
		//Alumne alumne = llegirAlumne("Material/alumne.xml");
		//System.out.println(alumne);
		
		XML2JSON();
	}
	
	private static Alumne llegirAlumne(String nomFile) throws JAXBException {
		File f = new File(nomFile);
		JAXBContext context = JAXBContext.newInstance(Alumne.class);
		Unmarshaller um = context.createUnmarshaller();
		return (Alumne) um.unmarshal(f);
	}
	
	private static void escriureJSON(String nomFile, JSONObject classe){
		try (FileWriter file = new FileWriter(nomFile)) {

			file.write(classe.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void XML2JSON() throws JAXBException {
		Alumne alumneXML = llegirAlumne("Material/alumne.xml");
		
		JSONObject alumneJSON = new JSONObject();
		alumneJSON.put("nom", alumneXML.getNom());
		alumneJSON.put("edat", alumneXML.getNotaMitja());
		alumneJSON.put("notaMitja", alumneXML.getNotaMitja());
		
		JSONObject assignaturaPreferida = new JSONObject();
		assignaturaPreferida.put("codi", alumneXML.getAssignaturaPreferida().getCodi());
		assignaturaPreferida.put("nom", alumneXML.getAssignaturaPreferida().getNom());
		assignaturaPreferida.put("horesSetmana", alumneXML.getAssignaturaPreferida().getHoresSetmana());
		
		alumneJSON.put("assignaturaPreferida", assignaturaPreferida);
		
		JSONArray vots = new JSONArray();
		vots.add(alumneXML.getVots());
		
		alumneJSON.put("vots", vots);
		
		
		escriureJSON("Material/alumne_traspassat.json", alumneJSON);
	}
	
	private static JSONObject llegirJSON(String nomFile) throws ParseException, org.json.simple.parser.ParseException{
		JSONParser parser = new JSONParser();
		try {
			JSONObject classe = (JSONObject) parser.parse(new FileReader(nomFile));
			return classe;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void JSON2XML() throws ParseException, org.json.simple.parser.ParseException {
		JSONObject alumneJSON = llegirJSON("Material/alumne.json");
		
		String nom = (String) alumneJSON.get("nom");
		int edat = (int) alumneJSON.get("nom");
		String notaMitjanal = (String) alumneJSON.get("nom");
		
		Alumne alumneXML = new Alumne();
	}
}
