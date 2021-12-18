package monopoly;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Propiedad")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Propiedad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_propiedad")
	int id_propiedad;
	
	@Column(name="nombre_propiedad")
	String nombre;
	
	@Column(name="precio")
	int precio;
	
	@Column(name="alquiler")
	int alquiler;
	
	@Column(name="alquiler1")
	int alquiler1;
	
	@Column(name="alquiler2")
	int alquiler2;
	
	@Column(name="alquiler3")
	int alquiler3;
	
	@Column(name="alquiler4")
	int alquiler4;
	
	@Column(name="alquiler_hotel")
	int alquilerHotel;
	
	@Column(name="precio_por_casa")
	int precio_por_casa;
	
	@Column(name="n_casas")
	int nCasas;
	
	@Column(name="precio_hipoteca")
	int precio_hipoteca;
	
	@Column(name="hipotecado")
	boolean hipotecado;
	
	@Column(name="posicion")
	int posicion;
	
	@ManyToOne
	@JoinColumn(name="id_jugador", nullable=true)
	private Jugador propietario;
	
	@ManyToOne
	@JoinColumn(name="id_color", nullable=false)
	private Color color;

	public int getId_propiedad() {
		return id_propiedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}

	public int getAlquiler1() {
		return alquiler1;
	}

	public void setAlquiler1(int alquiler1) {
		this.alquiler1 = alquiler1;
	}

	public int getAlquiler2() {
		return alquiler2;
	}

	public void setAlquiler2(int alquiler2) {
		this.alquiler2 = alquiler2;
	}

	public int getAlquiler3() {
		return alquiler3;
	}

	public void setAlquiler3(int alquiler3) {
		this.alquiler3 = alquiler3;
	}

	public int getAlquiler4() {
		return alquiler4;
	}

	public void setAlquiler4(int alquiler4) {
		this.alquiler4 = alquiler4;
	}

	public int getAlquilerHotel() {
		return alquilerHotel;
	}

	public void setAlquilerHotel(int alquilerHotel) {
		this.alquilerHotel = alquilerHotel;
	}

	public int getPrecio_por_casa() {
		return precio_por_casa;
	}

	public void setPrecio_por_casa(int precio_por_casa) {
		this.precio_por_casa = precio_por_casa;
	}

	public int getnCasas() {
		return nCasas;
	}

	public void setnCasas(int nCasas) {
		this.nCasas = nCasas;
	}

	public int getPrecio_hipoteca() {
		return precio_hipoteca;
	}

	public void setPrecio_hipoteca(int precio_hipoteca) {
		this.precio_hipoteca = precio_hipoteca;
	}

	public boolean isHipotecado() {
		return hipotecado;
	}

	public void setHipotecado(boolean hipotecado) {
		this.hipotecado = hipotecado;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Jugador getPropietario() {
		return propietario;
	}

	public void setPropietario(Jugador propietario) {
		this.propietario = propietario;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
