package pe.cibertec.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.FichatarifaDAO;
import pe.cibertec.dao.spec.MatriculaDAO;
import pe.cibertec.entity.Matricula;
import pe.cibertec.service.spec.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	@Autowired
	MatriculaDAO matriculaDAO;
	@Autowired
	FichatarifaDAO ftDAO;
	
	@Override
	public void save(Matricula bean) {
		Calendar c = Calendar.getInstance();
		c.setTime(bean.getFechaInicio());
		c.add(Calendar.MONTH, ftDAO.findById(bean.getFichatarifa().getIdTarifa()).getCantidad());
		bean.setFechaSalida(c.getTime());
		bean.setCodMatricula("M"+String.format("%04d",matriculaDAO.listAll().size()+1));//generacion de codigo U000000001
		bean.setTipo(0);//por defecto debe ser inactivo hasta generar comprobante de pago
		matriculaDAO.save(bean);
	}

	@Override
	public void update(Matricula bean) {
		matriculaDAO.update(bean);
	}

	@Override
	public void delete(String id) {
		
	}

	@Override
	public void saveUpdate(Matricula bean) {
		matriculaDAO.saveUpdate(bean);
	}

	@Override
	public List<Matricula> listAll() {
		return matriculaDAO.listAll();
	}

	@Override
	public Matricula findById(String id) {
		return matriculaDAO.findById(id);
	}
}
