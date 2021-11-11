package Monopoly;

public interface IJugadorDao extends IGenericDao<Jugador, Integer> {
	Jugador ComprovarPropietari(Propiedad p);
	
	boolean Comprar(Jugador j, Propiedad p);
	
	boolean pagarLloguer(Jugador j,Propiedad p);
	
	int edificar(Jugador j, Propiedad p);
	
	int modificarDiners(Jugador j, int diners);
	
	boolean hipotecar(Jugador j, Propiedad p);
	
	boolean deshipotecar(Jugador j, Propiedad p);
	
	Jugador Reassignar();
}
