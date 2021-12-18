
package Monopoly;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import Dao.FerrocarrilDao;
import Dao.JugadorDao;
import Dao.PropiedadDao;


public class main {
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	static ArrayList<Propiedad> tablero;

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}
		
	public static void main(String[] args) {
		Test();
		

		
//		Jugador jugador = new Jugador();
//		jugador.setNombre("Alber Valiente");
//		jugador.setDinero(0);
//		jugador.setJugando(true);
//		jugador.setnVictorias(0);
//		jugador.setTurno(0);
//		jugador.setPosicion(156);
//		jugador.setnPropiedades(0);
//		jugador.setColores(new HashSet<Color>());
//		jugador.setPropiedades(new HashSet<Propiedad>());
//		
//		Jugador jugador2 = new Jugador();
//		jugador2.setNombre("Luis Medina");
//		jugador2.setDinero(0);
//		jugador2.setJugando(true);
//		jugador2.setnVictorias(0);
//		jugador2.setTurno(1);
//		jugador2.setPosicion(6156);
//		jugador2.setnPropiedades(0);
//		jugador2.setColores(new HashSet<Color>());
//		jugador2.setPropiedades(new HashSet<Propiedad>());
//		
//		Color color = new Color();
//		color.setNom("naranja");
//		color.setPropietats(new HashSet<Propiedad>());
//		
//		Propiedad propiedad = new Propiedad();
//		propiedad.setAlquiler(10);
//		propiedad.setAlquiler1(20);
//		propiedad.setAlquiler2(30);
//		propiedad.setAlquiler3(40);
//		propiedad.setAlquiler4(50);
//		propiedad.setAlquilerHotel(60);
//		propiedad.setColor(color);
//		propiedad.setHipotecado(false);
//		propiedad.setnCasas(0);
//		propiedad.setNombre("La casa");
//		propiedad.setPosicion(69);
//		propiedad.setPrecio(69);
//		propiedad.setPrecio_hipoteca(420);
//		propiedad.setPrecio_por_casa(421);
//		
//		JugadorDao jd = new JugadorDao();
//		ColorDao cd = new ColorDao();
//		PropiedadDao pd = new PropiedadDao();
//		
//		jd.saveOrUpdate(jugador);
//		jd.saveOrUpdate(jugador2);
//		cd.saveOrUpdate(color);
//		pd.saveOrUpdate(propiedad);
//
//		jd.modificarDiners(jugador, 100);
//		jd.modificarDiners(jugador2, 100);
//		
//		
//		jd.Comprar(jugador, propiedad);
//		
//		jd.pagarLloguer(jugador2, propiedad);
	}
	
	static void Test() {
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			Jugador jugador = new Jugador();
			jugador.setNombre("Alber Valiente");
			jugador.setDinero(0);
			jugador.setJugando(true);
			jugador.setnVictorias(0);
			jugador.setTurno(0);
			jugador.setPosicion(156);
			jugador.setnPropiedades(0);
			jugador.setColores(new HashSet<Color>());
			jugador.setPropiedades(new HashSet<Propiedad>());
			
			Jugador jugador2 = new Jugador();
			jugador2.setNombre("Luis Medina");
			jugador2.setDinero(0);
			jugador2.setJugando(true);
			jugador2.setnVictorias(0);
			jugador2.setTurno(1);
			jugador2.setPosicion(6156);
			jugador2.setnPropiedades(0);
			jugador2.setColores(new HashSet<Color>());
			jugador2.setPropiedades(new HashSet<Propiedad>());
			
			Jugador jugador3 = new Jugador();
			jugador3.setNombre("Fran Alpijama");
			jugador3.setDinero(12);
			jugador3.setJugando(true);
			jugador3.setnVictorias(0);
			jugador3.setTurno(3);
			jugador3.setPosicion(13);
			jugador3.setnPropiedades(0);
			jugador3.setColores(new HashSet<Color>());
			jugador3.setPropiedades(new HashSet<Propiedad>());
			
			Color color = new Color();
			color.setNom("naranja");
			color.setPropietats(new HashSet<Propiedad>());
			
			Color color2 = new Color();
			color2.setNom("rojo");
			color2.setPropietats(new HashSet<Propiedad>());
			
			Color color3 = new Color();
			color3.setNom("azul");
			color3.setPropietats(new HashSet<Propiedad>());
			
			session.saveOrUpdate(color);
			session.saveOrUpdate(color2);
			session.saveOrUpdate(color3);
			
			Propiedad propiedad = new Propiedad();
			propiedad.setAlquiler(10);
			propiedad.setAlquiler1(20);
			propiedad.setAlquiler2(30);
			propiedad.setAlquiler3(40);
			propiedad.setAlquiler4(50);
			propiedad.setAlquilerHotel(60);
			propiedad.setColor(color);
			propiedad.setHipotecado(false);
			propiedad.setnCasas(0);
			propiedad.setNombre("La casa del Albert Valiente");
			propiedad.setPosicion(69);
			propiedad.setPrecio(69);
			propiedad.setPrecio_hipoteca(420);
			propiedad.setPrecio_por_casa(421);
			
			Propiedad propiedad1 = new Propiedad();
			propiedad1.setAlquiler(11);
			propiedad1.setAlquiler1(22);
			propiedad1.setAlquiler2(33);
			propiedad1.setAlquiler3(44);
			propiedad1.setAlquiler4(55);
			propiedad1.setAlquilerHotel(66);
			propiedad1.setColor(color2);
			propiedad1.setHipotecado(false);
			propiedad1.setnCasas(0);
			propiedad1.setNombre("Waka");
			propiedad1.setPosicion(72);
			propiedad1.setPrecio(72);
			propiedad1.setPrecio_hipoteca(426);
			propiedad1.setPrecio_por_casa(427);
			
			
			Ferrocarril f = CreateFerrocarril("Thomas", 0);
			f.setColor(color2);
			
			Ferrocarril f1 = CreateFerrocarril( "Turbao", 2);
			f1.setColor(color2);
			
			Ferrocarril f2 = CreateFerrocarril( "AAAAAA", 3);
			f2.setColor(color2);
			
			Ferrocarril f3 = CreateFerrocarril( "Auswitch", 4);
			f3.setColor(color3);
			
			f.setVecinoDe(new HashSet<Ferrocarril>());
			HashSet<Ferrocarril> aa = (HashSet<Ferrocarril>) f.getVecinoDe();
			aa.add(f1);
			aa.add(f3);
			f.setVecinoDe(aa);
			
			f1.setVecinoDe(new HashSet<Ferrocarril>());
			HashSet<Ferrocarril> bb = (HashSet<Ferrocarril>) f1.getVecinoDe();
			bb.add(f);
			bb.add(f2);
			f1.setVecinoDe(bb);
			
			f2.setVecinoDe(new HashSet<Ferrocarril>());
			HashSet<Ferrocarril> cc = (HashSet<Ferrocarril>) f2.getVecinoDe();
			cc.add(f1);
			cc.add(f3);
			f2.setVecinoDe(cc);
			
			f3.setVecinoDe(new HashSet<Ferrocarril>());
			HashSet<Ferrocarril> dd = (HashSet<Ferrocarril>) f3.getVecinoDe();
			dd.add(f);
			dd.add(f2);
			f3.setVecinoDe(dd);
			
			session.saveOrUpdate(jugador);
			session.saveOrUpdate(jugador2);
			session.saveOrUpdate(jugador3);
			session.saveOrUpdate(propiedad);
			session.saveOrUpdate(propiedad1);
			session.saveOrUpdate(f);
			session.saveOrUpdate(f1);
			session.saveOrUpdate(f2);
			session.saveOrUpdate(f3);
			
			session.getTransaction().commit();
		
			
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
				
				
			}
		}
	}
	
	public int edificar(Jugador j, Propiedad p) {
		JugadorDao jd = new JugadorDao();
		PropiedadDao pd = new PropiedadDao();
		if (p.getnCasas() < 5) {
			if(jd.ComprovarColor(p)) {
				jd.modificarDiners(j, -p.getPrecio_por_casa());
				p.setnCasas(p.getnCasas() + 1);
			}
		}
		jd.saveOrUpdate(j);
		pd.saveOrUpdate(p);
		return p.getnCasas();
	}
	
	public boolean transportFerrocarril(Jugador j, Ferrocarril f){
		
		int posJ = j.getPosicion();
		
		FerrocarrilDao fd = new FerrocarrilDao();
		JugadorDao jd = new JugadorDao();
		
		if (tablero.get(posJ) instanceof Ferrocarril) {
			Ferrocarril fCasilla = (Ferrocarril) tablero.get(posJ);
			if ((jd.ComprovarPropietari(fCasilla).getId_jugador() == j.getId_jugador()) && (fd.isFerrocarrilVei(f.getId_propiedad(), fCasilla.getId_propiedad())) && jd.ComprovarPropietari(f).getId_jugador() == j.getId_jugador()) {
				j.setPosicion(f.getPosicion());
				jd.saveOrUpdate(j);
				return true;
			}
		}
		
		return false;
	}
	
	static void CambiarCositas(Jugador j, Propiedad p, Ferrocarril f){
		JugadorDao jd = new JugadorDao();
		
		jd.modificarDiners(j, 10000);
		
		jd.Comprar(j, f);
		jd.Comprar(j, p);
		
		jd.hipotecar(j, p);
		
	}
	
	Color CreateColor(String name) {
		Color c = new Color();
		c.setNom("name");
		c.setPropietats(new HashSet<Propiedad>());
		c.setJugador(null);
		return c;
	}
	
	Propiedad CreatePropiedad(Color color, String name, int posicio) {
		Propiedad p = new Propiedad();
		p.setAlquiler(10);
		p.setAlquiler1(20);
		p.setAlquiler2(30);
		p.setAlquiler3(40);
		p.setAlquiler4(50);
		p.setAlquilerHotel(60);
		p.setColor(color);
		p.setHipotecado(false);
		p.setnCasas(1);
		p.setNombre(name);
		p.setPosicion(posicio);
		p.setPrecio(100);
		p.setPrecio_hipoteca(200);
		p.setPrecio_por_casa(150);
		p.setPropietario(null);
		return p;
	}
	
	static Ferrocarril CreateFerrocarril(String name, int posicio) {
		Ferrocarril f = new Ferrocarril();
		f.setAlquiler(10);
		f.setAlquiler1(20);
		f.setAlquiler2(30);
		f.setAlquiler3(40);
		f.setAlquiler4(50);
		f.setAlquilerHotel(60);
		f.setHipotecado(false);
		f.setnCasas(1);
		f.setNombre(name);
		f.setPosicion(posicio);
		f.setPrecio(100);
		f.setPrecio_hipoteca(200);
		f.setPrecio_por_casa(150);
		f.setPropietario(null);
		return f;
	}
	
	void Start() {
		Color c1 = CreateColor("Rojo");
		Color c2 = CreateColor("Naranja");
		Color c3 = CreateColor("Amarillo");
		Color c4 = CreateColor("Verde");
		
		ArrayList<Propiedad> tableroAux = new ArrayList<Propiedad>();
		
		for (int i = 1; i <= 20; i++) {
			int n = i%5;
			switch (n) {
			case 1:
				Propiedad p1 = CreatePropiedad(c1, "Propiedad "+c1.getNom()+" "+n, i);
				tableroAux.add(p1);
				break;
			case 2:
				Propiedad p2 = CreatePropiedad(c2, "Propiedad "+c2.getNom()+" "+n, i);
				tableroAux.add(p2);
				break;
			case 3:
				Propiedad p3 = CreatePropiedad(c3, "Propiedad "+c3.getNom()+" "+n, i);
				tableroAux.add(p3);
				break;
			case 4:
				Propiedad p4 = CreatePropiedad(c4, "Propiedad "+c4.getNom()+" "+n, i);
				tableroAux.add(p4);
				break;
			case 5:
				Ferrocarril f  = CreateFerrocarril("Ferrocarril "+n, i);
				tableroAux.add(f);
				break;
			}
		}
		tablero = tableroAux;
	}
	
	void TurnBeggining() {
		int _number_Players = 2;
	}
	
	
	
	
	
	
	
	
	
	
	void Roll(Jugador j) {
		JugadorDao jd = new JugadorDao();
		
		Random rd = new Random();
		int dice1, dice2, rollResult;
		dice1 = rd.nextInt(7)+1;
		dice2 = rd.nextInt(7)+1;
		rollResult = dice1+dice2;
		if ((jd.saberPosicion(j)+rollResult) >= tablero.size()) {
			j.setPosicion((jd.saberPosicion(j) + rollResult) - tablero.size()-1);
		} else {
			j.setPosicion((jd.saberPosicion(j) + rollResult));
		}
		
		// saber en que casilla cae i cosas
		
		Propiedad casilla = tablero.get(j.getPosicion());
		
		if(jd.ComprovarPropietari(casilla) == null){
			if (casilla instanceof Ferrocarril) jd.Comprar(j, (Ferrocarril) casilla);
			else jd.Comprar(j, casilla);
		} else if (!jd.ComprovarPropietari(casilla).equals(j.getNombre())) {
			if (casilla instanceof Ferrocarril){
				jd.pagarLloguer(j, (Ferrocarril) casilla);
			} else {
				jd.pagarLloguer(j, casilla);
			}
		}
		if (dice1==dice2) {
			Roll(j);
		}
		
		
	}
	
	
}
