package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.RolDAO;
import pe.cibertec.entity.Rol;
import pe.cibertec.service.spec.RolService;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	RolDAO rolDAO;

	@Override
	public void save(Rol bean) {
		rolDAO.save(bean);
	}

	@Override
	public void update(Rol bean) {
		rolDAO.update(bean);
	}

	@Override
	public void delete(String id) {
		rolDAO.delete(id);
	}

	@Override
	public void saveUpdate(Rol bean) {
		rolDAO.saveUpdate(bean);
	}

	@Override
	public List<Rol> listAll() {
		return rolDAO.listAll();
	}

	@Override
	public Rol findById(String id) {
		return rolDAO.findById(id);
	}

}
