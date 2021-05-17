package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.PersonaDAO;
import pe.cibertec.dao.spec.SocioDAO;
import pe.cibertec.entity.Socio;
import pe.cibertec.service.spec.SocioService;

@Service
public class SocioServiceImpl implements SocioService {
	@Autowired
	SocioDAO socioDAO;
	@Autowired
	PersonaDAO personaDAO;
	
	@Override
	public void save(Socio bean) {
		bean.getPersona().setNro_Dni(bean.getSocio_Nro_Dni());
		bean.setEstado(1);//por defecto debe ser activo
		personaDAO.save(bean.getPersona());
		socioDAO.save(bean);
	}

	@Override
	public void update(Socio bean) {
		socioDAO.update(bean);
	}

	@Override
	public void delete(String id) {
		Socio bean = socioDAO.findById(id);
		switch (bean.getEstado()) {
		case 1:
			bean.setEstado(0);
			break;
		default:
			bean.setEstado(1);
			break;
		} 
		socioDAO.update(bean);
	}

	@Override
	public void saveUpdate(Socio bean) {
		bean.getPersona().setNro_Dni(bean.getSocio_Nro_Dni());
		if(bean.getEstado()==0) {
			bean.setEstado(0);//por defecto debe ser activo
		}else {
			bean.setEstado(1);
		}
		personaDAO.saveUpdate(bean.getPersona());
		socioDAO.saveUpdate(bean);
	}

	@Override
	public List<Socio> listAll() {
		return socioDAO.listAll();
	}

	@Override
	public Socio findById(String id) {
		return socioDAO.findById(id);
	}
}
