package pe.cibertec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.dao.spec.FichatarifaDAO;
import pe.cibertec.entity.Matricula;
import pe.cibertec.entity.Socio;
import pe.cibertec.entity.Usuario;
import pe.cibertec.service.spec.FichatarifaService;
import pe.cibertec.service.spec.MatriculaService;
import pe.cibertec.service.spec.SocioService;

@Controller
@RequestMapping(value = "/matricula")
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaS;
	@Autowired
	private FichatarifaService fTarifaS;
	@Autowired
	private SocioService socioS;
	
	@RequestMapping(value = {"/",""})
	public String index(Model model) {
		try {
			Date myDate = new Date();
			Matricula bean = new Matricula();
			bean.setFechaInicio(myDate);
			
			model.addAttribute("tarifas",fTarifaS.listAll());
			model.addAttribute("socios",socioS.listAll());
			model.addAttribute("matricula",bean);
			model.addAttribute("socio",new Socio());
			model.addAttribute("titulo","Registra Ficha de Matricula");
			model.addAttribute("hoy",new SimpleDateFormat("dd-MM-yyyy").format(myDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "matricula/nuevo";
	}
	
	@RequestMapping(value = "/grabar")
	public String grabar(RedirectAttributes redirect, @ModelAttribute Matricula matricula) {
		try {
			matriculaS.save(matricula);
			redirect.addFlashAttribute("MENSAJE","Matricula grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar matricula");
			e.printStackTrace();
		}
		
		return "redirect:/matricula";
	}
	
	@RequestMapping(value = "/grabarSocio")
	public String grabarSocio(RedirectAttributes redirect, @ModelAttribute Socio socio) {
		try {
			socioS.save(socio);
			redirect.addFlashAttribute("MENSAJE","Socio grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar socio");
			e.printStackTrace();
		}
		
		return "redirect:/matricula";
	}

	@RequestMapping(value = "/buscarSocio/{id}")
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
}
