package monopoly;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;

@Entity
public class Ferrocarril extends Propiedad {

	@ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "Ferrocarril_Vecinos", 
	        joinColumns = { @JoinColumn(name = "id_ferrocarril") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_vecino") })
	@JsonBackReference
	Set<Ferrocarril> vecinoDe;
	@ManyToMany(mappedBy = "vecinoDe")
	@JsonBackReference
	Set<Ferrocarril> vecinos;
	
	public Set<Ferrocarril> getVecinoDe() {
		return vecinoDe;
	}
	public void setVecinoDe(HashSet<Ferrocarril> vecinoDe) {
		this.vecinoDe = vecinoDe;
	}
	public Set<Ferrocarril> getVecinos() {
		return vecinos;
	}
	public void setVecinos(HashSet<Ferrocarril> vecinos) {
		this.vecinos = vecinos;
	}
}
