package pe.cibertec.dao.spec;

import java.util.List;

import pe.cibertec.entity.Menu;
import pe.cibertec.entity.Usuario;

public interface UsuarioDAO extends CrudDAO<Usuario, String> {
	public Usuario iniciarSesion(String vLogin);
	public List<Menu> traerEnlaces(String cargo);
}
