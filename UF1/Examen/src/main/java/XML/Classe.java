package XML;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Classe {
	private String nom;
	private ArrayList<Alumne> alumnes;
	
	public Classe() {
		super();
	}

	public Classe(String nom, ArrayList<Alumne> alumnes) {
		super();
		this.nom = nom;
		this.alumnes = alumnes;
	}

	@XmlElement(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElementWrapper(name="alumnes")
	@XmlElement(name="alumne")
	public ArrayList<Alumne> getAlumnes() {
		return alumnes;
	}

	public void setAlumnes(ArrayList<Alumne> alumnes) {
		this.alumnes = alumnes;
	}

	@Override
	public String toString() {
		return "Classe [nom=" + nom + ", alumnes=" + alumnes + "]";
	}
	
	
}
