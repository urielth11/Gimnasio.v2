package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name="tb_usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_usu")
	private String codUsu;

	@Column(name="est_usu")
	private int estUsu;

	@Column(name="log_usu")
	private String logUsu;

	@Column(name="pas_usu")
	private String pasUsu;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="dni_usu")
	private Persona persona;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	public Usuario() {
	}

	public String getCodUsu() {
		return this.codUsu;
	}

	public void setCodUsu(String codUsu) {
		this.codUsu = codUsu;
	}

	public int getEstUsu() {
		return this.estUsu;
	}

	public void setEstUsu(int estUsu) {
		this.estUsu = estUsu;
	}

	public String getLogUsu() {
		return this.logUsu;
	}

	public void setLogUsu(String logUsu) {
		this.logUsu = logUsu;
	}

	public String getPasUsu() {
		return this.pasUsu;
	}

	public void setPasUsu(String pasUsu) {
		this.pasUsu = pasUsu;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}