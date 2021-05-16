package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fichaasistecia database table.
 * 
 */
@Entity
@NamedQuery(name="Fichaasistecia.findAll", query="SELECT f FROM Fichaasistecia f")
public class Fichaasistecia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFichaAsistecia;

	@Temporal(TemporalType.TIMESTAMP)
	private Date hFin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date hInicio;

	//bi-directional many-to-one association to Matricula
	@ManyToOne
	@JoinColumn(name="codMatricula")
	private Matricula matricula;

	public Fichaasistecia() {
	}

	public int getIdFichaAsistecia() {
		return this.idFichaAsistecia;
	}

	public void setIdFichaAsistecia(int idFichaAsistecia) {
		this.idFichaAsistecia = idFichaAsistecia;
	}

	public Date getHFin() {
		return this.hFin;
	}

	public void setHFin(Date hFin) {
		this.hFin = hFin;
	}

	public Date getHInicio() {
		return this.hInicio;
	}

	public void setHInicio(Date hInicio) {
		this.hInicio = hInicio;
	}

	public Matricula getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}