package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.FichaasistenciaDAO;
import pe.cibertec.entity.Fichaasistecia;
import pe.cibertec.service.spec.FichaasistenciaService;

@Service
public class FichaasistenciaServiceImpl implements FichaasistenciaService {

	@Autowired
	FichaasistenciaDAO asistenciaDAO;
	
	@Override
	public void save(Fichaasistecia bean) {
		asistenciaDAO.save(bean);
	}

	@Override
	public void update(Fichaasistecia bean) {
		asistenciaDAO.update(bean);
	}

	@Override
	public void delete(Integer id) {
		asistenciaDAO.delete(id);
	}

	@Override
	public void saveUpdate(Fichaasistecia bean) {
		asistenciaDAO.saveUpdate(bean);
	}

	@Override
	public List<Fichaasistecia> listAll() {
		return asistenciaDAO.listAll();
	}

	@Override
	public Fichaasistecia findById(Integer id) {
		return asistenciaDAO.findById(id);
	}

}
