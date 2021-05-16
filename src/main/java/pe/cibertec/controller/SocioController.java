package pe.cibertec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.entity.Socio;
import pe.cibertec.entity.Usuario;
import pe.cibertec.service.spec.PersonaService;
import pe.cibertec.service.spec.RolService;
import pe.cibertec.service.spec.SocioService;
import pe.cibertec.service.spec.UsuarioService;

@Controller
@RequestMapping(value = "/socio")
public class SocioController {
	@Autowired
	private SocioService socioS; 
	
	@RequestMapping(value = {"/",""})
	public String index(Model model) {
		try {
			model.addAttribute("socios",socioS.listAll());
			model.addAttribute("socio",new Socio());
			model.addAttribute("titulo","Mantenimiento Socio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "socio/lista";
	}
	
	@RequestMapping(value = "/nuevo")
	public String nuevo(Model model) {
		try {
			model.addAttribute("socio",new Socio());
			model.addAttribute("titulo","Registrar Socio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "socio/nuevo";
	}
	
	@RequestMapping(value = "/grabar")
	public String grabarSocio(RedirectAttributes redirect, @ModelAttribute Socio socio, @RequestParam("vista") String vista) {
		try {
			socioS.save(socio);
			redirect.addFlashAttribute("MENSAJE","Socio grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar socio");
			e.printStackTrace();
		}
		
		if(vista.equals("nuevo")) {
			return "redirect:/socio/nuevo";
		} else {
			return "redirect:/socio/";
		}
	}
}
