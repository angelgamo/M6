package Monopoly;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Jugador")
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_jugador")
	private int id_jugador;
	
	@Column(name="nombre_jugador")
	private String nombre;
	 
	@Column(name="jugando")
	private boolean jugando;
	
	@Column(name="turno")
	private int turno;
	
	@Column(name="dinero")
	private int dinero;
	
	@Column(name="nPropiedades")
	private int nPropiedades;
	
	@Column(name="nVictorias")
	private int nVictorias;
	
	@OneToMany(mappedBy="jugador")
	private Set<Color> colores;
	
	@OneToMany(mappedBy="propietario")
	private Set<Propiedad> propiedades;

	public int getId_jugador() {
		return id_jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isJugando() {
		return jugando;
	}

	public void setJugando(boolean jugando) {
		this.jugando = jugando;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getnPropiedades() {
		return nPropiedades;
	}

	public void setnPropiedades(int nPropiedades) {
		this.nPropiedades = nPropiedades;
	}

	public int getnVictorias() {
		return nVictorias;
	}

	public void setnVictorias(int nVictorias) {
		this.nVictorias = nVictorias;
	}

	public Set<Color> getColores() {
		return colores;
	}

	public void setColores(Set<Color> colores) {
		this.colores = colores;
	}

	public Set<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(HashSet<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
}
