package Monopoly;

public interface IJugadorDao extends IGenericDao<Jugador, Integer> {
	Jugador ComprovarPropietari(Propiedad p);
	
	boolean Comprar(Jugador j, Propiedad p);
	
	boolean Comprar(Jugador j, Ferrocarril f);
	
	public boolean ComprovarColor(Propiedad p);
	
	boolean pagarLloguer(Jugador j,Propiedad p);
	
	boolean pagarLloguer(Jugador j, Ferrocarril f);
	
	//int edificar(Jugador j, Propiedad p);
	
	int saberPosicion(Jugador j);
	
	int modificarDiners(Jugador j, int diners);
	
	boolean hipotecar(Jugador j, Propiedad p);
	
	boolean hipotecar(Jugador j, Ferrocarril f);
	
	boolean deshipotecar(Jugador j, Propiedad p);
	
	boolean deshipotecar(Jugador j, Ferrocarril f);
	
	Jugador Reassignar();
}
