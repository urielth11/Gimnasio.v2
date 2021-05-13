package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the matricula database table.
 * 
 */
@Entity
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codMatricula;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	private Date fechaSalida;

	private int tipo;

	//bi-directional many-to-one association to Comprobantepago
	@OneToMany(mappedBy="matricula")
	private List<Comprobantepago> comprobantepagos;

	//bi-directional many-to-one association to Fichaasistecia
	@OneToMany(mappedBy="matricula")
	private List<Fichaasistecia> fichaasistecias;

	//bi-directional many-to-one association to Fichatarifa
	@ManyToOne
	@JoinColumn(name="idTarifa")
	private Fichatarifa fichatarifa;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="Socio_Nro_Dni")
	private Socio socio;

	public Matricula() {
	}

	public String getCodMatricula() {
		return this.codMatricula;
	}

	public void setCodMatricula(String codMatricula) {
		this.codMatricula = codMatricula;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public List<Comprobantepago> getComprobantepagos() {
		return this.comprobantepagos;
	}

	public void setComprobantepagos(List<Comprobantepago> comprobantepagos) {
		this.comprobantepagos = comprobantepagos;
	}

	public Comprobantepago addComprobantepago(Comprobantepago comprobantepago) {
		getComprobantepagos().add(comprobantepago);
		comprobantepago.setMatricula(this);

		return comprobantepago;
	}

	public Comprobantepago removeComprobantepago(Comprobantepago comprobantepago) {
		getComprobantepagos().remove(comprobantepago);
		comprobantepago.setMatricula(null);

		return comprobantepago;
	}

	public List<Fichaasistecia> getFichaasistecias() {
		return this.fichaasistecias;
	}

	public void setFichaasistecias(List<Fichaasistecia> fichaasistecias) {
		this.fichaasistecias = fichaasistecias;
	}

	public Fichaasistecia addFichaasistecia(Fichaasistecia fichaasistecia) {
		getFichaasistecias().add(fichaasistecia);
		fichaasistecia.setMatricula(this);

		return fichaasistecia;
	}

	public Fichaasistecia removeFichaasistecia(Fichaasistecia fichaasistecia) {
		getFichaasistecias().remove(fichaasistecia);
		fichaasistecia.setMatricula(null);

		return fichaasistecia;
	}

	public Fichatarifa getFichatarifa() {
		return this.fichatarifa;
	}

	public void setFichatarifa(Fichatarifa fichatarifa) {
		this.fichatarifa = fichatarifa;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}