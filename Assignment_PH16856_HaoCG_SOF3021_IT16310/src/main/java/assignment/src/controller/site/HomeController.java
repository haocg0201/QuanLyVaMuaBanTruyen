package assignment.src.controller.site;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	private HttpSession session;
	
	@GetMapping("/home/index")
	public String index() {
		return "templates/site/index";		
	}
	
	@GetMapping("/home/about")
	public String about() {
		return "templates/site/about";		
	}
	
	@GetMapping("/home/contact")
	public String contact() {
		return "templates/site/contact";		
	}
	
	
}
