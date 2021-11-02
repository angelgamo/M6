package trabajo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuracio {
	private boolean mode_daltonic;
	private String tipus_controlador;
	private String resolucio_pantalla;
	
	public Configuracio(){
		super();
	}

	public Configuracio(boolean mode_daltonic, String tipus_controlador, String resolucio_pantalla) {
		super();
		this.mode_daltonic = mode_daltonic;
		this.tipus_controlador = tipus_controlador;
		this.resolucio_pantalla = resolucio_pantalla;
	}
	
	@XmlElement
	public boolean isMode_daltonic() {
		return mode_daltonic;
	}

	public void setMode_daltonic(boolean mode_daltonic) {
		this.mode_daltonic = mode_daltonic;
	}
	
	@XmlElement
	public String getTipus_controlador() {
		return tipus_controlador;
	}

	public void setTipus_controlador(String tipus_controlador) {
		this.tipus_controlador = tipus_controlador;
	}
	
	@XmlElement
	public String getResolucio_pantalla() {
		return resolucio_pantalla;
	}

	public void setResolucio_pantalla(String resolucio_pantalla) {
		this.resolucio_pantalla = resolucio_pantalla;
	}

	@Override
	public String toString() {
		return "Configuracio [mode_daltonic=" + mode_daltonic + ", tipus_controlador=" + tipus_controlador
				+ ", resolucio_pantalla=" + resolucio_pantalla + "]";
	}
}
