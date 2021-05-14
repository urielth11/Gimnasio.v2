package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the socio database table.
 * 
 */
@Entity
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String socio_Nro_Dni;

	private int estado;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="socio")
	@JsonIgnore
	private List<Matricula> matriculas;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="Socio_Nro_Dni")
	private Persona persona;

	public Socio() {
	}

	public String getSocio_Nro_Dni() {
		return this.socio_Nro_Dni;
	}

	public void setSocio_Nro_Dni(String socio_Nro_Dni) {
		this.socio_Nro_Dni = socio_Nro_Dni;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula addMatricula(Matricula matricula) {
		getMatriculas().add(matricula);
		matricula.setSocio(this);

		return matricula;
	}

	public Matricula removeMatricula(Matricula matricula) {
		getMatriculas().remove(matricula);
		matricula.setSocio(null);

		return matricula;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}