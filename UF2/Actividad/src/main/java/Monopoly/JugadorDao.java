package Monopoly;

import java.util.List;

public class JugadorDao extends GenericDao<Jugador, Integer> implements IJugadorDao {

	@Override
	public Jugador ComprovarPropietari(Propiedad propietat) {
		return propietat.getPropietario();
	}
	
	@Override
	public boolean Comprar(Jugador j, Propiedad p) {
		
		if(p.getPropietario() != null){
			return false;
		}
		
		int costPropietat = p.getPrecio();
		
		this.modificarDiners(j, -costPropietat);
		p.setPropietario(j);
		return true;
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
		return false;
	}
	
	@Override
	public int edificar(Jugador j, Propiedad p) {
		if (p.getPrecio_por_casa() < j.getDinero() && p.nCasas < 5) {

			this.modificarDiners(j, -p.getPrecio_por_casa());
			p.setnCasas(p.getnCasas() + 1);
		}
		return p.nCasas;
	}

	@Override
	public int modificarDiners(Jugador j, int diners) {
		j.setDinero(j.getDinero()+diners);
		return j.getDinero();}

	@Override
	public boolean hipotecar(Jugador j, Propiedad p) {
		if (j.getPropiedades().contains(p) && !p.isHipotecado()) {
			this.modificarDiners(j, p.getPrecio_hipoteca());
			p.setHipotecado(true);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deshipotecar(Jugador j, Propiedad p) {
		if (j.getPropiedades().contains(p) && p.isHipotecado() && j.getDinero() > p.getPrecio_hipoteca()) {
			this.modificarDiners(j, -p.getPrecio_hipoteca());
			p.setHipotecado(false);
			return true;
		}
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
}
