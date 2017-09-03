package konami.pes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import konami.pes.domain.Player;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
	return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
	return "login";
	}
}
