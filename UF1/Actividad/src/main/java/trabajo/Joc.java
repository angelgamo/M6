package trabajo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Joc {

	ArrayList<Jugador> jugadores;

	public Joc() {
		super();
	}
	
	public Joc(ArrayList<Jugador> jugadores) {
		super();
		this.jugadores = jugadores;
	}

	@XmlElementWrapper(name="jugadors")
	@XmlElement(name="jugador")
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Joc [jugadores=" + jugadores + "]";
	}
	
	
}
