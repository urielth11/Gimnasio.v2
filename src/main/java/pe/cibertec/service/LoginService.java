package pe.cibertec.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.cibertec.dao.spec.UsuarioDAO;
import pe.cibertec.entity.Usuario;

@Service
public class LoginService implements UserDetailsService {
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDet=null;
		
		Usuario bean;
		bean=usuarioDAO.iniciarSesion(username);	
		
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		rol.add(new SimpleGrantedAuthority(bean.getRol().getCargo()));
		
		userDet=new User(bean.getLogUsu(), bean.getPasUsu(),rol);
		
		return userDet;
	}
}
