package pe.cibertec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.entity.Persona;
import pe.cibertec.entity.Socio;
import pe.cibertec.service.spec.SocioService;

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
			Socio bean = new Socio();
			Persona persona = new Persona();
			persona.setGenero("0");
			bean.setPersona(persona);
			
			model.addAttribute("socio",bean);
			model.addAttribute("titulo","Registrar Socio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "socio/nuevo";
	}
	
	@RequestMapping(value = "/editar/{id}")
	@ResponseBody
	public Socio editar(Model model, @PathVariable String id) {
		Socio bean = null;
		try {
			bean = socioS.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(Model model, @PathVariable String id) {
		try {
			socioS.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/socio";
	}
	
	@RequestMapping(value = "/grabar")
	public String grabarSocio(RedirectAttributes redirect, @ModelAttribute Socio socio, @RequestParam("vista") String vista) {
		try {
			socioS.saveUpdate(socio);
			redirect.addFlashAttribute("MENSAJE","Socio grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar socio");
			e.printStackTrace();
		}
		
		if(vista.equals("nuevo")) {
			return "redirect:/socio/nuevo";
		} else {
			return "redirect:/socio";
		}
	}
}
