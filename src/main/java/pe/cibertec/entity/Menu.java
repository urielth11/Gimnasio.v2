package pe.cibertec.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_menu database table.
 * 
 */
@Entity
@Table(name="tb_menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_menu")
	private String codMenu;

	@Column(name="des_menu")
	private String desMenu;

	@Column(name="url_menu")
	private String urlMenu;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="Rol_idRol")
	private Rol rol;

	public Menu() {
	}

	public String getCodMenu() {
		return this.codMenu;
	}

	public void setCodMenu(String codMenu) {
		this.codMenu = codMenu;
	}

	public String getDesMenu() {
		return this.desMenu;
	}

	public void setDesMenu(String desMenu) {
		this.desMenu = desMenu;
	}

	public String getUrlMenu() {
		return this.urlMenu;
	}

	public void setUrlMenu(String urlMenu) {
		this.urlMenu = urlMenu;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}