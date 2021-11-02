package XML;

import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Alumne implements Comparable {
	private String nom;
	private int edat;
	private float notaMitja;
	private AssignaturaPreferida assignaturaPreferida;
	private ArrayList<Boolean> vots;
	
	public Alumne() {
		super();
	}

	public Alumne(String nom, int edat, float notaMitja, AssignaturaPreferida assignaturaPreferida,
			ArrayList<Boolean> vots) {
		super();
		this.nom = nom;
		this.edat = edat;
		this.notaMitja = notaMitja;
		this.assignaturaPreferida = assignaturaPreferida;
		this.vots = vots;
	}

	@XmlElement(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlElement(name="edat")
	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	@XmlElement(name="notaMitja")
	public float getNotaMitja() {
		return notaMitja;
	}

	public void setNotaMitja(float notaMitja) {
		this.notaMitja = notaMitja;
	}

	@XmlElement(name="assignaturaPreferida")
	public AssignaturaPreferida getAssignaturaPreferida() {
		return assignaturaPreferida;
	}

	public void setAssignaturaPreferida(AssignaturaPreferida assignaturaPreferida) {
		this.assignaturaPreferida = assignaturaPreferida;
	}

	@XmlElementWrapper(name="vots")
	@XmlElement(name="vot")
	public ArrayList<Boolean> getVots() {
		return vots;
	}

	public void setVots(ArrayList<Boolean> vots) {
		this.vots = vots;
	}

	@Override
	public String toString() {
		return "Alumne [nom=" + nom + ", edat=" + edat + ", notaMitja=" + notaMitja + ", assignaturaPreferida="
				+ assignaturaPreferida + ", vots=" + vots + "]";
	}

	@Override
	public int compareTo(Object o) {
		Alumne otherAlumne = (Alumne) o;
		
		int votsTrue = Collections.frequency(vots, true);
		int votsFalse = Collections.frequency(vots, false);
		int otherVotsTrue = Collections.frequency(otherAlumne.getVots(), true);
		int otherVotsFalse = Collections.frequency(otherAlumne.getVots(), false);
		
		if (votsTrue > otherVotsTrue) {
			return -1;
		} else if (votsTrue < otherVotsTrue) {
			return 1;
		} else if (votsFalse < otherVotsFalse) {
			return -1;
		} else if (votsFalse > otherVotsFalse) {
			return 1;
		} else {
			return 0;
		}
	}
}
