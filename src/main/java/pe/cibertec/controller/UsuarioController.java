package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	
	@RequestMapping(value = "/grabar")
	public String grabar(RedirectAttributes redirect, @ModelAttribute Usuario bean) {
		try {
			//Proyecto p=new Proyecto();
			//p.setCodigoProyecto(codPro);
			//bean.setProyecto(p);
			usuarioS.save(bean);
			redirect.addFlashAttribute("MENSAJE","Auto registrado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro de auto");
			e.printStackTrace();
		}
		
		return "redirect:/usuario/";
	}
}
