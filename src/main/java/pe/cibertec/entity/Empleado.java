package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String empleado_Nro_Dni;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="Empleado_Nro_Dni")
	private Persona persona;

	public Empleado() {
	}

	public String getEmpleado_Nro_Dni() {
		return this.empleado_Nro_Dni;
	}

	public void setEmpleado_Nro_Dni(String empleado_Nro_Dni) {
		this.empleado_Nro_Dni = empleado_Nro_Dni;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}