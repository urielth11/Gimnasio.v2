package pe.cibertec.service;


import java.util.List;

import pe.cibertec.entity.Usuario;

public interface UsuarioService {
	public void save(Usuario bean);
	public List<Usuario> listAll();
	public Usuario findById(int id);
}
