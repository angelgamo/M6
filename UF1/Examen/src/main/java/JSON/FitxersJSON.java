package JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FitxersJSON {
	public static void main(String[] args) throws ParseException, org.json.simple.parser.ParseException {
		System.out.println(llegirJSON("Material/classe.json"));
		
		JSONObject classe = llegirJSON("Material/classe.json");
		
		for (Object alumne: (JSONArray) classe.get("alumnes")) {
			JSONObject alum = (JSONObject) alumne;
			System.out.println(alum.get("nom"));
		}
		
		//escriureJSON("Material/classe_copia.json", classe);
		
		afegirVot("Pau", false);
		
		eliminarVotFalseMitjana9();
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
	
	private static void escriureJSON(String nomFile, JSONObject classe){
		try (FileWriter file = new FileWriter(nomFile)) {

			file.write(classe.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void afegirVot(String nomAlumne, boolean vot) throws ParseException, org.json.simple.parser.ParseException {
		JSONObject classe = llegirJSON("Material/classe.json");
		JSONArray alumnes = new JSONArray();
		for (Object obj: (JSONArray) classe.get("alumnes")) {
			JSONObject alumne = (JSONObject) obj;
			
			if (alumne.get("nom").equals(nomAlumne)) {
				JSONObject alumneUpdated = new JSONObject();
				alumneUpdated.put("nom", alumne.get("nom"));
				alumneUpdated.put("edat", alumne.get("edat"));
				alumneUpdated.put("notaMitja", alumne.get("notaMitja"));
				alumneUpdated.put("assignaturaPreferida", alumne.get("assignaturaPreferida"));
				JSONArray vots = (JSONArray) alumne.get("vots");
				vots.add(vot);
				alumneUpdated.put("vots", vots);
				alumnes.add(alumneUpdated);
			}else {
				alumnes.add(alumne);
			}
		}
		classe.put("alumnes", alumnes);
		escriureJSON("Material/classe.json", classe);
	}
	
	private static void eliminarVotFalseMitjana9() throws ParseException, org.json.simple.parser.ParseException {
		JSONObject classe = llegirJSON("Material/classe.json");
		JSONArray alumnes = new JSONArray();
		for (Object obj: (JSONArray) classe.get("alumnes")) {
			JSONObject alumne = (JSONObject) obj;
			
			Double notaMitjana = Double.parseDouble("" + alumne.get("notaMitja"));
			boolean eliminaVot = false;
			
			if (notaMitjana > 9.0) {
				JSONObject alumneUpdated = new JSONObject();
				alumneUpdated.put("nom", alumne.get("nom"));
				alumneUpdated.put("edat", alumne.get("edat"));
				alumneUpdated.put("notaMitja", alumne.get("notaMitja"));
				alumneUpdated.put("assignaturaPreferida", alumne.get("assignaturaPreferida"));
				JSONArray vots = (JSONArray) alumne.get("vots");
				
				JSONArray votsUpdated = new JSONArray();
				
				for (Object vot : (JSONArray) vots) {
					if ((Boolean) vot || eliminaVot) {
						votsUpdated.add((Boolean) vot);
					}else {
						eliminaVot = true;
					}
				}
				
				if (!eliminaVot) {
					votsUpdated.add(true);
				}
				alumneUpdated.put("vots", votsUpdated);
				alumnes.add(alumneUpdated);
			}else {
				alumnes.add(alumne);
			}
		}
		classe.put("alumnes", alumnes);
		escriureJSON("Material/classe.json", classe);
	}
}
