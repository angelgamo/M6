
package Monopoly;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class main {
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

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
			jugador2.setnPropiedades(1);
			jugador2.setColores(new HashSet<Color>());
			jugador2.setPropiedades(new HashSet<Propiedad>());
			
			Color color = new Color();
			color.setNom("naranja");
			color.setPropietats(new HashSet<Propiedad>());
			color.setJugador(jugador);
			
			Color color2 = new Color();
			color2.setNom("rojo");
			color2.setPropietats(new HashSet<Propiedad>());
			color2.setJugador(jugador2);
			
			jugador.getColores().add(color);
			jugador2.getColores().add(color2);
			
			session.saveOrUpdate(color);
			session.saveOrUpdate(color2);
			
			Propiedad propiedad = new Propiedad();
			propiedad.setAlquiler(10);
			propiedad.setAlquiler1(20);
			propiedad.setAlquiler2(30);
			propiedad.setAlquiler3(40);
			propiedad.setAlquiler4(50);
			propiedad.setAlquilerHotel(60);
			propiedad.setColor(color);
			propiedad.setHipotecado(false);
			propiedad.setnCasas(1);
			propiedad.setNombre("La casa del Albert Valiente");
			propiedad.setPosicion(69);
			propiedad.setPrecio(69);
			propiedad.setPrecio_hipoteca(420);
			propiedad.setPrecio_por_casa(421);
			propiedad.setPropietario(jugador);
			
			//jugador.getPropiedades().add(propiedad);
			//jugador2.getPropiedades().add(propiedad);

			
			Ferrocarril f = CreateFerrocarril( "Thomas", 0);
			f.setColor(color2);
			
			Ferrocarril f1 = CreateFerrocarril( "Thomas", 0);
			f1.setColor(color2);
			
			f.setVecinoDe(new HashSet<Ferrocarril>());
			HashSet<Ferrocarril> aa = (HashSet<Ferrocarril>) f.getVecinoDe();
			aa.add(f1);
			f.setVecinoDe(aa);
			
			f1.setVecinoDe(new HashSet<Ferrocarril>());
			HashSet<Ferrocarril> bb = (HashSet<Ferrocarril>) f1.getVecinoDe();
			bb.add(f);
			f1.setVecinoDe(bb);
			
			session.saveOrUpdate(jugador);
			session.saveOrUpdate(jugador2);
			session.saveOrUpdate(propiedad);
			session.saveOrUpdate(f);
			session.saveOrUpdate(f1);
			
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
	
	ArrayList<Propiedad> Start() {
		Color c1 = CreateColor("Rojo");
		Color c2 = CreateColor("Naranja");
		Color c3 = CreateColor("Amarillo");
		Color c4 = CreateColor("Verde");
		
		ArrayList<Propiedad> tablero = new ArrayList<Propiedad>();
		
		for (int i = 1; i <= 20; i++) {
			int n = i%5;
			switch (n) {
			case 1:
				Propiedad p1 = CreatePropiedad(c1, "Propiedad "+c1.getNom()+" "+n, i);
				tablero.add(p1);
				break;
			case 2:
				Propiedad p2 = CreatePropiedad(c2, "Propiedad "+c2.getNom()+" "+n, i);
				tablero.add(p2);
				break;
			case 3:
				Propiedad p3 = CreatePropiedad(c3, "Propiedad "+c3.getNom()+" "+n, i);
				tablero.add(p3);
				break;
			case 4:
				Propiedad p4 = CreatePropiedad(c4, "Propiedad "+c4.getNom()+" "+n, i);
				tablero.add(p4);
				break;
			case 5:
				Ferrocarril f  = CreateFerrocarril("Ferrocarril "+n, i);
				tablero.add(f);
				break;
			}
		}
		
		return tablero;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	void Roll(Jugador j, ArrayList<Propiedad> tablero){
		Random rd = new Random();
		int dice1, dice2, rollResult;
		dice1 = rd.nextInt(7)+1;
		dice2 = rd.nextInt(7)+1;
		rollResult = dice1+dice2;
		if((j.getPosicion()+rollResult) > tablero.size()){
			
		}
		if(dice1==dice2){
			Roll(j,tablero);
		}
		
		
	}
	
	
}
