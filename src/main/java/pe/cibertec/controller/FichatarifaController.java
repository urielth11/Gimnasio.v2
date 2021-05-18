package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.entity.Fichatarifa;
import pe.cibertec.entity.Socio;
import pe.cibertec.service.spec.FichatarifaService;
import pe.cibertec.service.spec.SocioService;

@Controller
@RequestMapping(value = "/tarifa")
public class FichatarifaController {
	@Autowired
	private FichatarifaService tarifaS; 
	
	@RequestMapping(value = {"/",""})
	public String index(Model model) {
		try {
			model.addAttribute("tarifas",tarifaS.listAll());
			model.addAttribute("tarifa",new Fichatarifa());
			model.addAttribute("titulo","Mantenimiento de Tarifa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "tarifa/lista";
	}
	
	@RequestMapping(value = "/nuevo")
	public String nuevo(Model model) {
		try {
			model.addAttribute("tarifa",new Fichatarifa());
			model.addAttribute("titulo","Registrar Tarifa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "tarifa/nuevo";
	}
	
	@RequestMapping(value = "/editar/{id}")
	@ResponseBody
	public Fichatarifa editar(Model model, @PathVariable String id) {
		Fichatarifa bean = null;
		try {
			bean = tarifaS.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(Model model, @PathVariable String id) {
		try {
			tarifaS.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/tarifa";
	}
	
	@RequestMapping(value = "/grabar")
	public String grabarSocio(RedirectAttributes redirect, @ModelAttribute Fichatarifa tarifa) {
		try {
			tarifaS.saveUpdate(tarifa);
			redirect.addFlashAttribute("MENSAJE","Tarifa grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar tarifa");
			e.printStackTrace();
		}
		return "redirect:/tarifa";
	}
}
