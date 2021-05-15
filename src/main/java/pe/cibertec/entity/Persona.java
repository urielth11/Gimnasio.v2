package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nro_Dni;

	private String apellidos;

	private String email;

	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_nac")
	private Date fechaNac;

	private String genero;

	private String nombres;

	private String telefono;

	//bi-directional one-to-one association to Empleado
	@OneToOne(mappedBy="persona")
	@JsonIgnore
	private Empleado empleado;

	//bi-directional one-to-one association to Socio
	@OneToOne(mappedBy="persona")
	@JsonIgnore
	private Socio socio;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	@JsonIgnore
	private List<Usuario> tbUsuarios;

	public Persona() {
	}

	public String getNro_Dni() {
		return this.nro_Dni;
	}

	public void setNro_Dni(String nro_Dni) {
		this.nro_Dni = nro_Dni;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<Usuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<Usuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public Usuario addTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setPersona(this);

		return tbUsuario;
	}

	public Usuario removeTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setPersona(null);

		return tbUsuario;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nro_Dni;
	}

}