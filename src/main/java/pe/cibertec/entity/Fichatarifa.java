package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the fichatarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Fichatarifa.findAll", query="SELECT f FROM Fichatarifa f")
public class Fichatarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idTarifa;

	private int cantidad;

	private double precio;

	private String tiempo;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="fichatarifa")
	@JsonIgnore
	private List<Matricula> matriculas;

	public Fichatarifa() {
	}

	public String getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(String idTarifa) {
		this.idTarifa = idTarifa;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula addMatricula(Matricula matricula) {
		getMatriculas().add(matricula);
		matricula.setFichatarifa(this);

		return matricula;
	}

	public Matricula removeMatricula(Matricula matricula) {
		getMatriculas().remove(matricula);
		matricula.setFichatarifa(null);

		return matricula;
	}

}