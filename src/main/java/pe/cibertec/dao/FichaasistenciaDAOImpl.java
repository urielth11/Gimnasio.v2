package pe.cibertec.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.cibertec.dao.spec.FichaasistenciaDAO;
import pe.cibertec.entity.Fichaasistecia;

@Repository
public class FichaasistenciaDAOImpl implements FichaasistenciaDAO {
	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Fichaasistecia bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Fichaasistecia> listAll() {
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			query=session.createQuery("select u from Fichaasistecia u");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Transactional
	public Fichaasistecia findById(Integer id) {
		Session session = factory.getCurrentSession();
		Fichaasistecia bean = null;
		try {
			bean = session.find(Fichaasistecia.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional
	public void update(Fichaasistecia bean) {
		Session session = factory.getCurrentSession();
		try {
			session.update(bean);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		try {
			Fichaasistecia bean = session.find(Fichaasistecia.class, id);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void saveUpdate(Fichaasistecia bean) {
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
