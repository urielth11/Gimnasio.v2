package pe.cibertec.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.cibertec.entity.Comprobantepago;
import pe.cibertec.entity.Matricula;
import pe.cibertec.service.spec.ComprobantepagoService;
import pe.cibertec.service.spec.MatriculaService;

@Controller
@RequestMapping(value = "/comprobante")
public class ComprobantepagoController {
	
	@Autowired
	private MatriculaService matriculaS;
	@Autowired
	private ComprobantepagoService comprobanteS;
	
	@RequestMapping(value = {"/",""})
	public String index(Model model) {
		try {
			Date myDate = new Date();
			Comprobantepago bean = new Comprobantepago();
			bean.setFechaPago(myDate);
			
			model.addAttribute("comprobante",bean);
			model.addAttribute("matriculas",matriculaS.listAll());
			model.addAttribute("titulo","Registra Comprobante Pago");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "comprobantepago/nuevo";
	}
	
	@RequestMapping(value = "/grabar")
	public String grabar(RedirectAttributes redirect, @ModelAttribute Comprobantepago comprobante) {
		try {
			comprobanteS.save(comprobante);
			redirect.addFlashAttribute("MENSAJE","Comprobante grabado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al grabar comprobante");
			e.printStackTrace();
		}
		
		return "redirect:/comprobante";
	}

	@RequestMapping(value = "/buscarMatricula/{id}")
	@ResponseBody
	public Matricula editar(Model model, @PathVariable String id) {
		Matricula bean = null;
		try {
			bean = matriculaS.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
