package Dao;

import java.util.List;
import java.util.Set;

import Monopoly.Jugador;
import Monopoly.Propiedad;
import Monopoly.Color;
import Monopoly.Ferrocarril;

public class JugadorDao extends GenericDao<Jugador, Integer> implements IJugadorDao {

	@Override
	public Jugador ComprovarPropietari(Propiedad propietat) {
		return propietat.getPropietario();
	}
	
	@Override
	public boolean Comprar(Jugador j, Propiedad p) {
		
		PropiedadDao pd = new PropiedadDao();
		
		if(p.getPropietario() != null){
			return false;
		}
		
		int costPropietat = p.getPrecio();
		
		this.modificarDiners(j, -costPropietat);
		p.setPropietario(j);
		Set<Propiedad> propiedades = j.getPropiedades();
		propiedades.add(p);
		j.setPropiedades(propiedades);
		j.setnPropiedades(j.getnPropiedades()+1);
		this.saveOrUpdate(j);
		pd.saveOrUpdate(p);
		return true;
	}
	
	@Override
	public boolean Comprar(Jugador j, Ferrocarril f) {
		
		FerrocarrilDao fd = new FerrocarrilDao();
		
		if(f.getPropietario() != null){
			return false;
		}
		
		int costPropietat = f.getPrecio();
		
		this.modificarDiners(j, -costPropietat);
		f.setPropietario(j);
		j.getPropiedades().add(f);
		j.setnPropiedades(j.getnPropiedades()+1);
		this.saveOrUpdate(j);
		fd.saveOrUpdate(f);
		return true;
	}
	
	@Override
	public boolean ComprovarColor(Propiedad p) {
		PropiedadDao pd = new PropiedadDao();
		Color c = p.getColor();
		Jugador j = p.getPropietario();
		boolean flag = true;
		for (Propiedad pr : c.getPropietats()) {
			if(!pr.getPropietario().equals(j)) {
				flag=false;
			}
		}
		pd.saveOrUpdate(p);
		return flag;
	}

	
	@Override
	public boolean pagarLloguer(Jugador j, Propiedad p) {
		switch(p.getnCasas()){
			case 0:
				this.modificarDiners(j, -p.getAlquiler());
				this.modificarDiners(p.getPropietario(), p.getAlquiler());				
				return true;
			case 1:
				this.modificarDiners(j, -p.getAlquiler1());
				this.modificarDiners(p.getPropietario(), p.getAlquiler1());				
				return true;
			case 2:
				this.modificarDiners(j, -p.getAlquiler2());
				this.modificarDiners(p.getPropietario(), p.getAlquiler2());				
				return true;
			case 3:
				this.modificarDiners(j, -p.getAlquiler3());
				this.modificarDiners(p.getPropietario(), p.getAlquiler3());				
				return true;
			case 4:
				this.modificarDiners(j, -p.getAlquiler4());
				this.modificarDiners(p.getPropietario(), p.getAlquiler4());				
				return true;
			case 5:
				this.modificarDiners(j, -p.getAlquilerHotel());
				this.modificarDiners(p.getPropietario(), p.getAlquilerHotel());
				return true;
		}
		this.saveOrUpdate(j);
		return false;
	}
	
	@Override
	public boolean pagarLloguer(Jugador j, Ferrocarril f) {
		int nEstaciones = 0;
		Jugador propietario = f.getPropietario();
		for (Propiedad p : propietario.getPropiedades()) {
			if (p instanceof Ferrocarril) {
				nEstaciones++;
			}
		}
		if (nEstaciones != 0) {
			this.modificarDiners(j, -(nEstaciones*25));
			this.modificarDiners(j, (nEstaciones*25));
			return true;
		}
		return false;
	}
	
	/*
	@Override
	public int edificar(Jugador j, Propiedad p) {
		PropiedadDao pd = new PropiedadDao();
		if (p.getnCasas() < 5) {
			if(ComprovarColor(p)) {
				this.modificarDiners(j, -p.getPrecio_por_casa());
				p.setnCasas(p.getnCasas() + 1);
			}
		}
		this.saveOrUpdate(j);
		pd.saveOrUpdate(p);
		return p.getnCasas();
	}
	*/

	@Override
	public int modificarDiners(Jugador j, int diners) {
		j.setDinero(j.getDinero()+diners);
		this.saveOrUpdate(j);
		return j.getDinero();}

	@Override
	public boolean hipotecar(Jugador j, Propiedad p) {
		PropiedadDao pd = new PropiedadDao();
		if (j.getPropiedades().contains(p) && !p.isHipotecado()) {
			this.modificarDiners(j, p.getPrecio_hipoteca());
			p.setHipotecado(true);
			return true;
		}
		this.saveOrUpdate(j);
		pd.saveOrUpdate(p);
		return false;
	}
	
	@Override
	public boolean hipotecar(Jugador j, Ferrocarril f) {
		FerrocarrilDao fd = new FerrocarrilDao();
		if (j.getPropiedades().contains(f) && !f.isHipotecado()) {
			this.modificarDiners(j, f.getPrecio_hipoteca());
			f.setHipotecado(true);
			return true;
		}
		this.saveOrUpdate(j);
		fd.saveOrUpdate(f);
		return false;
	}
	
	@Override
	public boolean deshipotecar(Jugador j, Propiedad p) {
		PropiedadDao pd = new PropiedadDao();
		if (j.getPropiedades().contains(p) && p.isHipotecado() && j.getDinero() > p.getPrecio_hipoteca()) {
			this.modificarDiners(j, -p.getPrecio_hipoteca());
			p.setHipotecado(false);
			return true;
		}
		this.saveOrUpdate(j);
		pd.saveOrUpdate(p);
		return false;
	}
	
	@Override
	public boolean deshipotecar(Jugador j, Ferrocarril f) {
		FerrocarrilDao fd = new FerrocarrilDao();
		if (j.getPropiedades().contains(f) && f.isHipotecado() && j.getDinero() > f.getPrecio_hipoteca()) {
			this.modificarDiners(j, -f.getPrecio_hipoteca());
			f.setHipotecado(false);
			return true;
		}
		this.saveOrUpdate(j);
		fd.saveOrUpdate(f);
		return false;
	}

	@Override
	public Jugador Reassignar() {
		List<Jugador> jugadors = this.list();
		
		for (Jugador j : jugadors) {
			if(j.getDinero() < 0){
				this.delete(j);
			}
		}
		
		if(jugadors.size() == 1) {
			System.out.println("Ha ganao "+jugadors.get(0).getNombre());
			return jugadors.get(0);
		}
		return null;
	}

	@Override
	public int saberPosicion(Jugador j) {
		return j.getPosicion();
	}	
}
