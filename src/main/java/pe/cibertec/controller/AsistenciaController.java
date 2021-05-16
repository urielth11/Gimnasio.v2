package pe.cibertec.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.entity.Comprobantepago;
import pe.cibertec.entity.Fichaasistecia;
import pe.cibertec.service.spec.ComprobantepagoService;
import pe.cibertec.service.spec.FichaasistenciaService;
import pe.cibertec.service.spec.MatriculaService;

@Controller
@RequestMapping(value = "/asistencia")
public class AsistenciaController {
	@Autowired
	private FichaasistenciaService asistenciaS;
	
	@RequestMapping(value = {"/",""})
	public String index(Model model) {
		try {
			model.addAttribute("asistencias",asistenciaS.listAll());
			model.addAttribute("titulo","Cronograma de Asistencia");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "asistencia/lista";
	}
	
	@RequestMapping(value = "/grabar")
	public String grabar(RedirectAttributes redirect, @ModelAttribute Fichaasistecia asistencia) {
		try {
			asistenciaS.save(asistencia);
			redirect.addFlashAttribute("MENSAJE","Comprobante grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar comprobante");
			e.printStackTrace();
		}
		
		return "redirect:/asistencia/nuevo";
	}
}
