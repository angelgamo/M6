package Monopoly;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;

@Entity
public class Ferrocarril extends Propiedad {

	@ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "ids_vecinos", 
	        joinColumns = { @JoinColumn(name = "id_ferrocarril") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_vecino") })
	HashSet<Ferrocarril> vecinoDe;
	@ManyToMany(mappedBy = "vecinoDe")
	HashSet<Ferrocarril> vecinos;
	
	public Set<Ferrocarril> getVecinoDe() {
		return vecinoDe;
	}
	public void setVecinoDe(HashSet<Ferrocarril> vecinoDe) {
		this.vecinoDe = vecinoDe;
	}
	public HashSet<Ferrocarril> getVecinos() {
		return vecinos;
	}
	public void setVecinos(HashSet<Ferrocarril> vecinos) {
		this.vecinos = vecinos;
	}
}
