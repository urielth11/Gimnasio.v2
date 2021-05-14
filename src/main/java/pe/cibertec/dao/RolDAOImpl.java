package pe.cibertec.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.cibertec.dao.spec.RolDAO;
import pe.cibertec.entity.Rol;

@Repository
public class RolDAOImpl implements RolDAO {
	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Rol bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Rol> listAll() {
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			query=session.createQuery("select u from Rol u");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public Rol findById(String id) {
		Session session = factory.getCurrentSession();
		Rol bean = null;
		try {
			bean = session.find(Rol.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public void update(Rol bean) {
		Session session = factory.getCurrentSession();
		try {
			session.update(bean);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String id) {
		Session session = factory.getCurrentSession();
		try {
			Rol bean = session.find(Rol.class, id);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveUpdate(Rol bean) {
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
