package XML;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AssignaturaPreferida {
	private String codi;
	private String nom;
	private int horesSetmana;
	
	public AssignaturaPreferida() {
		super();
	}
	
	public AssignaturaPreferida(String codi, String nom, int horesSetmana) {
		super();
		this.codi = codi;
		this.nom = nom;
		this.horesSetmana = horesSetmana;
	}
	
	@XmlAttribute
	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}
	
	@XmlElement(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlElement(name="horesSetmana")
	public int getHoresSetmana() {
		return horesSetmana;
	}

	public void setHoresSetmana(int horesSetmana) {
		this.horesSetmana = horesSetmana;
	}

	@Override
	public String toString() {
		return "AssignaturaPreferida [codi=" + codi + ", nom=" + nom + ", horesSetmana=" + horesSetmana + "]";
	}

	
}
