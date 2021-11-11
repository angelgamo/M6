
package Monopoly;


import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.Set;
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
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			Jugador jugador = new Jugador();
			jugador.setNombre("Alber Valiente");
			jugador.setDinero(0);
			jugador.setJugando(true);
			jugador.setnVictorias(0);
			jugador.setTurno(0);
			jugador.setnPropiedades(1);
			jugador.setColores(new HashSet<Color>());
			jugador.setPropiedades(new HashSet<Propiedad>());
			
			Jugador jugador2 = new Jugador();
			jugador2.setNombre("Luis Medina");
			jugador2.setDinero(0);
			jugador2.setJugando(true);
			jugador2.setnVictorias(0);
			jugador2.setTurno(1);
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
			
			jugador.getPropiedades().add(propiedad);
			jugador2.getPropiedades().add(propiedad);
			
			
			session.saveOrUpdate(jugador);
			session.saveOrUpdate(jugador2);
			session.saveOrUpdate(propiedad);
			
			
			//Ferrocarril ferrocarril = New Ferrocarril();
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
}
