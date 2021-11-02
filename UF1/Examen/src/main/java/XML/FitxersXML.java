package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FitxersXML {
	public static void main(String[] args) throws JAXBException {
		Classe classe1 = llegirClasse("Material/classe.xml");
		System.out.println(classe1);
		
		escriureClasse("Material/classe_copia.xml", classe1);
		
		afegirvot("Figo", true);
		
		System.out.println(comprovarGuanyador());
	}

	private static Classe llegirClasse(String nomFile) throws JAXBException {
		File f = new File(nomFile);
		JAXBContext context = JAXBContext.newInstance(Classe.class);
		Unmarshaller um = context.createUnmarshaller();
		return (Classe) um.unmarshal(f);
	}
	
	private static boolean escriureClasse(String nomFile, Classe classe) throws JAXBException {
		File f = new File(nomFile);
		JAXBContext context = JAXBContext.newInstance(Classe.class);
		Marshaller m = context.createMarshaller();
		m.marshal(classe, f);
		return true;
	}
	
	private static void afegirvot(String nomAlumne, boolean vot) throws JAXBException {
		Classe classe = llegirClasse("Material/classe.xml");
		for (Alumne alumne : classe.getAlumnes()) {
			if (alumne.getNom().equals(nomAlumne)) {
				ArrayList<Boolean> vots = alumne.getVots();
				vots.add(vot);
				alumne.setVots(vots);
			}
		}
		escriureClasse("Material/classe.xml", classe);
	}
	
	private static String comprovarGuanyador() throws JAXBException {
		Classe classe = llegirClasse("Material/classe.xml");
		ArrayList<Alumne> alumnes = classe.getAlumnes();
		Collections.sort(alumnes);
		return alumnes.get(0).getNom();
	}
	
}
