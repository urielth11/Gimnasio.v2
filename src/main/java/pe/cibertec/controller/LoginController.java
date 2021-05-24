package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.cibertec.entity.Socio;
import pe.cibertec.service.spec.SocioService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	private SocioService socioS; 
	
	@RequestMapping(value = {"/",""})
	public String index(Model model) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
}
