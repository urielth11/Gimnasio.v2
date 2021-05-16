package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.ComprobantepagoDAO;
import pe.cibertec.dao.spec.MatriculaDAO;
import pe.cibertec.entity.Comprobantepago;
import pe.cibertec.entity.Matricula;
import pe.cibertec.service.spec.ComprobantepagoService;

@Service
public class ComprobantepagoServiceImpl implements ComprobantepagoService {

	@Autowired
	ComprobantepagoDAO comprobanteDAO;
	@Autowired
	MatriculaDAO matriculaDAO;
	
	@Override
	public void save(Comprobantepago bean) {
		Matricula m = matriculaDAO.findById(bean.getMatricula().getCodMatricula());
		m.setTipo(1);
		matriculaDAO.update(m);
		
		bean.setNroComprobante("C"+String.format("%09d",comprobanteDAO.listAll().size()+1));//generacion de codigo C000000001
		comprobanteDAO.save(bean);
	}

	@Override
	public void update(Comprobantepago bean) {
		comprobanteDAO.update(bean);
		
	}

	@Override
	public void delete(String id) {
		comprobanteDAO.delete(id);
	}

	@Override
	public void saveUpdate(Comprobantepago bean) {
		comprobanteDAO.saveUpdate(bean);
		
	}

	@Override
	public List<Comprobantepago> listAll() {
		return comprobanteDAO.listAll();
	}

	@Override
	public Comprobantepago findById(String id) {
		return comprobanteDAO.findById(id);
	}

}
