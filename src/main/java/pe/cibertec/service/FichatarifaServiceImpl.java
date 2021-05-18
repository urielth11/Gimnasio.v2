package pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.FichatarifaDAO;
import pe.cibertec.entity.Fichatarifa;
import pe.cibertec.service.spec.FichatarifaService;

@Service
public class FichatarifaServiceImpl implements FichatarifaService {

	@Autowired
	FichatarifaDAO fichaTDAO;
	
	@Override
	public void save(Fichatarifa bean) {
		bean.setIdTarifa("T"+String.format("%09d",fichaTDAO.listAll().size()+1));//generacion de codigo U000000001
		bean.setEstado(1);//por defecto debe ser activo
		fichaTDAO.save(bean);
	}

	@Override
	public void update(Fichatarifa bean) {
		fichaTDAO.update(bean);
	}

	@Override
	public void delete(String id) {
		Fichatarifa bean = fichaTDAO.findById(id);
		switch (bean.getEstado()) {
		case 1:
			bean.setEstado(0);
			break;
		default:
			bean.setEstado(1);
			break;
		} 
		fichaTDAO.update(bean);
	}

	@Override
	public void saveUpdate(Fichatarifa bean) {
		if("".equals(bean.getIdTarifa())) {
			bean.setIdTarifa("T"+String.format("%09d",fichaTDAO.listAll().size()+1));//generacion de codigo U000000001
			bean.setEstado(1);//por defecto debe ser activo
		}
		fichaTDAO.saveUpdate(bean);
	}

	@Override
	public List<Fichatarifa> listAll() {
		return fichaTDAO.listAll();
	}

	@Override
	public Fichatarifa findById(String id) {
		return fichaTDAO.findById(id);
	}

}
