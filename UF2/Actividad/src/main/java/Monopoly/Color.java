package Monopoly;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Color")
public class Color {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_color")
	private int id_color;
	
	@Column(name="nom_color")
	private String nom;
	
	@OneToMany(mappedBy = "color")
	private Set<Propiedad> propietats;
	
	@ManyToOne
	@JoinColumn(name="id_jugador", nullable=true)
	
	private Jugador jugador;

	public int getId_color() {
		return id_color;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Propiedad> getPropietats() {
		return propietats;
	}

	public void setPropietats(Set<Propiedad> propietats) {
		this.propietats = propietats;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
