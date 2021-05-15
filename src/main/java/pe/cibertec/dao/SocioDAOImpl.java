package pe.cibertec.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.cibertec.dao.spec.SocioDAO;
import pe.cibertec.entity.Socio;

@Repository
public class SocioDAOImpl implements SocioDAO {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Socio bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Socio> listAll() {
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			query=session.createQuery("select u from Socio u");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Transactional
	public Socio findById(String id) {
		Session session = factory.getCurrentSession();
		Socio bean = null;
		try {
			bean = session.find(Socio.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional
	public void update(Socio bean) {
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
			Socio bean = session.find(Socio.class, id);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void saveUpdate(Socio bean) {
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
