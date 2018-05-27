package konami.pes.controllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import konami.pes.domain.Continent;
import konami.pes.services.ContinentService;

@Controller
@RequestMapping(value = "/continent")
public class ContinentController {

	@Autowired
	ContinentService continentService;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/getContinentById")
	@ResponseBody
	public Continent getContinentById(@RequestParam("continentId") Integer continentId) {

		return continentService.getContinentById(continentId);

	}

	@RequestMapping(value = "/saveOrUpdateContinent", method = RequestMethod.POST)
	public String saveOrUpdateContinent(@RequestParam("continentId") String continentId,
			@RequestParam("continentName") String continentName,
			@RequestParam("continentEmblem") String continentEmblem) {

		Continent c = new Continent();
		if (continentId != null && !continentId.isEmpty()) {
			c = continentService.getContinentById(Integer.valueOf(continentId));
		}
		c.setName(continentName);
		c.setEmblem(continentEmblem);
		
		continentService.saveOrUpdateContinent(c);
		
		return "redirect:/team";
	}
}
