package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the comprobantepago database table.
 * 
 */
@Entity
@NamedQuery(name="Comprobantepago.findAll", query="SELECT c FROM Comprobantepago c")
public class Comprobantepago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nroComprobante;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaPago;

	//bi-directional many-to-one association to Matricula
	@ManyToOne
	@JoinColumn(name="codMatricula")
	private Matricula matricula;

	public Comprobantepago() {
	}

	public String getNroComprobante() {
		return this.nroComprobante;
	}

	public void setNroComprobante(String nroComprobante) {
		this.nroComprobante = nroComprobante;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Matricula getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}