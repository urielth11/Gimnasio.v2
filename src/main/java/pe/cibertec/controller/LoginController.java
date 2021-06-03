package pe.cibertec.controller;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.cibertec.entity.Menu;
import pe.cibertec.service.spec.UsuarioService;

@Controller
public class LoginController {
	@Autowired
	private UsuarioService usuarioS; 
	
	@RequestMapping(value = {"/principal"})
	public String principal(Model model, HttpSession  session) {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			/*if (request.isUserInRole("Administrador")) {
		        request.getUserPrincipal()
		    }*/

			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Set<String> roles = authentication.getAuthorities().stream()
			     .map(r -> r.getAuthority()).collect(Collectors.toSet());
			User user = (User)authentication.getPrincipal();
			
			List<Menu> menus = usuarioS.traerEnlaces(roles.stream().findFirst().get());
			session.setAttribute("menus", menus);
			session.setAttribute("usuarioLogueado", user.getUsername());
			session.setAttribute("rolLogueado", roles.stream().findFirst().get());
			System.out.println(user.getUsername());
			System.out.println("");
			System.out.println(roles.stream().findFirst().get());
			System.out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/usuario";
	}
	
	@RequestMapping(value = {"/login","/"})
	public String login(Model model) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
}
