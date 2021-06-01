package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.UsuarioDAO;
import pe.cibertec.entity.Menu;
import pe.cibertec.entity.Usuario;
import pe.cibertec.service.spec.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public void save(Usuario bean) {
		bean.setCodUsu("U"+String.format("%09d",usuarioDAO.listAll().size()+1));//generacion de codigo U000000001
		bean.setEstUsu(1);//por defecto Usuario debe ser activo
		usuarioDAO.save(bean);
	}

	@Override
	public List<Usuario> listAll() {
		return usuarioDAO.listAll();
	}

	@Override
	public void update(Usuario bean) {
		usuarioDAO.update(bean);
	}

	@Override
	public void delete(String id) {
		Usuario bean = usuarioDAO.findById(id);
		switch (bean.getEstUsu()) {
		case 1:
			bean.setEstUsu(0);
			break;
		default:
			bean.setEstUsu(1);
			break;
		} 
		usuarioDAO.update(bean);
	}

	@Override
	public void saveUpdate(Usuario bean) {
		if("".equals(bean.getCodUsu())) {
			bean.setCodUsu("U"+String.format("%09d",usuarioDAO.listAll().size()+1));//generacion de codigo U000000001
			bean.setEstUsu(1);//por defecto Usuario debe ser activo
		}
		usuarioDAO.saveUpdate(bean);
	}

	@Override
	public Usuario findById(String id) {
		return usuarioDAO.findById(id);
	}

	@Override
	public List<Menu> traerEnlaces(String cargo) {
		return usuarioDAO.traerEnlaces(cargo);
	}

}
