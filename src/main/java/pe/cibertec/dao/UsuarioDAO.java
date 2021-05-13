package pe.cibertec.dao;

import java.util.List;

import pe.cibertec.entity.Usuario;

public interface UsuarioDAO {
	public void save (Usuario bean);
	public List<Usuario> listAll();
	public Usuario findById(int id);
}
