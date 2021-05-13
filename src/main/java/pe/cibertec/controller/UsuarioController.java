package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.entity.Usuario;
import pe.cibertec.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioS; 
	
	
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		try {
			model.addAttribute("usuarios",usuarioS.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario/lista";
	}
	
	@RequestMapping(value = "/agregar")
	public String agregar(Model model) {
		try {
			model.addAttribute("usuario",new Usuario());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario/grabar";
	}
	
	@RequestMapping(value = "/editar/{id}")
	public String editar(Model model, @PathVariable int id) {
		try {
			model.addAttribute("usuario",usuarioS.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario/grabar";
	}
	
	
	@RequestMapping(value = "/grabar")
	public String grabar(RedirectAttributes redirect, @ModelAttribute Usuario bean) {
		try {
			usuarioS.save(bean);
			redirect.addFlashAttribute("MENSAJE","Auto registrado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro de auto");
			e.printStackTrace();
		}
		
		return "redirect:/usuario/";
	}
}
