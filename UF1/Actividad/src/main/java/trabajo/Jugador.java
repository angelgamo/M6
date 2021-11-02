package trabajo;

import java.util.ArrayList;
import java.util.Collections;

import javax.print.attribute.standard.MediaSize.Other;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jugador implements Comparable{
	private String nom;
	private String inicials;
	private int posicio;
	private String DNI;
	private ArrayList<Integer> puntuacions;
	private Configuracio configuracio;
	
	
	public Jugador(){
		super();
	}
	
	public Jugador(String nom, String inicials, int posicio, String dNI, ArrayList<Integer> puntuacions,
			Configuracio configuracio) {
		super();
		this.nom = nom;
		this.inicials = inicials;
		this.posicio = posicio;
		this.DNI = dNI;
		this.puntuacions = puntuacions;
		this.configuracio = configuracio;
	}

	@XmlElement
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlElement
	public String getInicials() {
		return inicials;
	}
	
	public void setInicials(String inicials) {
		this.inicials = inicials;
	}
	
	@XmlElement
	public int getPosicio() {
		return posicio;
	}
	
	public void setPosicio(int posicio) {
		this.posicio = posicio;
	}
	
	@XmlElementWrapper(name="puntuacions")
	@XmlElement(name="puntuacio")
	public ArrayList<Integer> getPuntuacions() {
		return puntuacions;
	}
	
	public void setPuntuacions(ArrayList<Integer> puntuacions) {
		this.puntuacions = puntuacions;
	}
	
	
	@XmlElement(name="configuracio")
	public Configuracio getConfiguracio() {
		return configuracio;
	}
	
	public void setConfiguracio(Configuracio configuracio) {
		this.configuracio = configuracio;
	}

	@XmlElement(name="dni")
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}


	@Override
	public String toString() {
		return "Jugador [nom=" + nom + ", inicials=" + inicials + ", posicio=" + posicio + ", DNI=" + DNI
				+ ", puntuacions=" + puntuacions + ", configuracio=" + configuracio + "]";
	}

	@Override
	public int compareTo(Object o) {
		Jugador j2 = (Jugador) o;
		
		int myBestScore = Collections.max(this.puntuacions);
		int otherBestScore = Collections.max(j2.getPuntuacions());
		int res;
		
		if (myBestScore < otherBestScore) {
			res = 1;
		}else if (myBestScore > otherBestScore) {
			res = -1;
		}else {
			res = 0;
			}
		return res;
	}
	
	
	
}
