package pe.cibertec.service.spec;

import java.util.List;

import pe.cibertec.entity.Menu;
import pe.cibertec.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, String> {
	public List<Menu> traerEnlaces(String cargo);
}
