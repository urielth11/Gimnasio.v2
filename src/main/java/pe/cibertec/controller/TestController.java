package pe.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		return "auto"; 
	}

}
