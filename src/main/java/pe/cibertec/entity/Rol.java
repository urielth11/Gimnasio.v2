package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rol")
	private String idRol;

	private String cargo;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="rol")
	private List<Menu> tbMenus;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> tbUsuarios;

	public Rol() {
	}

	public String getIdRol() {
		return this.idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Menu> getTbMenus() {
		return this.tbMenus;
	}

	public void setTbMenus(List<Menu> tbMenus) {
		this.tbMenus = tbMenus;
	}

	public Menu addTbMenus(Menu tbMenus) {
		getTbMenus().add(tbMenus);
		tbMenus.setRol(this);

		return tbMenus;
	}

	public Menu removeTbMenus(Menu tbMenus) {
		getTbMenus().remove(tbMenus);
		tbMenus.setRol(null);

		return tbMenus;
	}

	public List<Usuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<Usuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public Usuario addTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setRol(this);

		return tbUsuario;
	}

	public Usuario removeTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setRol(null);

		return tbUsuario;
	}

}