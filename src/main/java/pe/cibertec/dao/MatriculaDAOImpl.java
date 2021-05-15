package pe.cibertec.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.cibertec.dao.spec.MatriculaDAO;
import pe.cibertec.entity.Matricula;

@Repository
public class MatriculaDAOImpl implements MatriculaDAO {
	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Matricula bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Matricula> listAll() {
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			query=session.createQuery("select u from Matricula u");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Transactional
	public Matricula findById(String id) {
		Session session = factory.getCurrentSession();
		Matricula bean = null;
		try {
			bean = session.find(Matricula.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional
	public void update(Matricula bean) {
		Session session = factory.getCurrentSession();
		try {
			session.update(bean);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void delete(String id) {
		Session session = factory.getCurrentSession();
		try {
			Matricula bean = session.find(Matricula.class, id);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void saveUpdate(Matricula bean) {
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
