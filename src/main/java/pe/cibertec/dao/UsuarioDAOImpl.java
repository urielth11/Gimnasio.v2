package pe.cibertec.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.cibertec.dao.spec.UsuarioDAO;
import pe.cibertec.entity.Menu;
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

	@Transactional(readOnly = true)
	public Usuario findById(String id) {
		Session session = factory.getCurrentSession();
		Usuario bean = null;
		try {
			bean = session.find(Usuario.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional
	public void update(Usuario bean) {
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
			Usuario bean = session.find(Usuario.class, id);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void saveUpdate(Usuario bean) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String claveEncriptada = encoder. encode(bean.getPasUsu());
		bean.setPasUsu(claveEncriptada);
		
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario iniciarSesion(String vLogin) {
		Session session=factory.getCurrentSession();
		Usuario bean=null;
		Query query=null;
		try {
			String hql="select u from Usuario u where u.logUsu=?1";
			query=session.createQuery(hql);
			query.setParameter(1, vLogin);
			List<Usuario> lista=query.getResultList();
			if(!lista.isEmpty())
				bean=(Usuario) query.getSingleResult();
			
			//Optional x;//ofnullable
			//bean = (Usuario) Optional.ofNullable(query.getSingleResult()).orElse(new Usuario());
			//Optional.ofnullable(query::getSingleResult).or(new Usuario());
			//bean.length > 0 ? bean: new Usuario


			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Menu> traerEnlaces(String cargo) {
		Session session=factory.getCurrentSession();
		List<Menu> lista=null;
		Query query=null;
		try {
			//String hql="select e from RolEnlace re join re.enlace e where re.rol.idrol=?1";
			String hql="select m from Menu m where m.rol.cargo=?1";
			query=session.createQuery(hql);
			query.setParameter(1, cargo);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
