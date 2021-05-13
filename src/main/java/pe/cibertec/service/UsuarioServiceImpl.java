package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.UsuarioDAO;
import pe.cibertec.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO autoDAO;
	
	public void save(Usuario bean) {
		autoDAO.save(bean);
	}

	@Override
	public List<Usuario> listAll() {
		return autoDAO.listAll();
	}

}
