package monopoly;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@Column(name="posicion")
	private int posicion;
	
	@Column(name="dinero")
	private int dinero;
	
	@Column(name="n_propiedades")
	private int nPropiedades;
	
	@Column(name="n_victorias")
	private int nVictorias;
	
	@OneToMany(mappedBy="jugador")
	@JsonBackReference
	private Set<Color> colores;
	
	@OneToMany(mappedBy="propietario")
	@JsonBackReference
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
	
	public int getPosicion() {
		return posicion;
	}
	
	public void setPosicion(int posicion) {
		this.posicion = posicion;
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

	public void setPropiedades(Set<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
}
