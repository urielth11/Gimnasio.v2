package pe.cibertec.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.cibertec.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Usuario bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Usuario> listAll() {
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			query=session.createQuery("select u from Usuario u");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public Usuario findById(int id) {
		Session session = factory.getCurrentSession();
		Usuario usu = null;
		try {
			usu = session.find(Usuario.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usu;
	}

}
