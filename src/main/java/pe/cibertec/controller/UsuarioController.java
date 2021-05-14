package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.entity.Usuario;
import pe.cibertec.service.spec.PersonaService;
import pe.cibertec.service.spec.RolService;
import pe.cibertec.service.spec.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioS; 
	@Autowired
	private RolService rolS; 
	@Autowired
	private PersonaService personaS; 
	
	@RequestMapping(value = {"/",""})
	public String index(Model model) {
		try {
			model.addAttribute("usuarios",usuarioS.listAll());
			model.addAttribute("usuario",new Usuario());
			model.addAttribute("titulo","Mantenimiento de Usuario");
			model.addAttribute("roles", rolS.listAll());
			model.addAttribute("personas", personaS.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario/lista";
	}
	
	@RequestMapping(value = "/editar/{id}")
	@ResponseBody
	public Usuario editar(Model model, @PathVariable String id) {
		Usuario bean = null;
		try {
			bean = usuarioS.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(Model model, @PathVariable String id) {
		Usuario bean = null;
		try {
			usuarioS.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/usuario";
	}
	
	@RequestMapping(value = "/grabar")
	public String grabar(RedirectAttributes redirect, @ModelAttribute Usuario usuario) {
		try {
			usuarioS.saveUpdate(usuario);
			redirect.addFlashAttribute("MENSAJE","Usuario grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar usuario");
			e.printStackTrace();
		}
		
		return "redirect:/usuario";
	}
}
