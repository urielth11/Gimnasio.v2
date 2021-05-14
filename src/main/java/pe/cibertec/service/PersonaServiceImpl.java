package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.PersonaDAO;
import pe.cibertec.dao.spec.UsuarioDAO;
import pe.cibertec.entity.Persona;
import pe.cibertec.service.spec.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaDAO personaDAO;
	
	@Override
	public void save(Persona bean) {
		personaDAO.save(bean);
	}

	@Override
	public void update(Persona bean) {
		personaDAO.update(bean);
	}

	@Override
	public void delete(String id) {
		personaDAO.delete(id);
	}

	@Override
	public void saveUpdate(Persona bean) {
		personaDAO.saveUpdate(bean);
	}

	@Override
	public List<Persona> listAll() {
		return personaDAO.listAll();
	}

	@Override
	public Persona findById(String id) {
		return personaDAO.findById(id);
	}
	
}
