package konami.pes.controllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import konami.pes.domain.League;
import konami.pes.services.LeagueService;
import konami.pes.services.NationService;

@Controller
@RequestMapping(value = "/league")
public class LeagueController {

	@Autowired
	LeagueService leagueService;
	@Autowired
	NationService nationService;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/saveOrUpdateLeague", method = RequestMethod.POST)
	public String saveOrUpdateLeague(@RequestParam("leagueId") String leagueId,
			@RequestParam("leagueName") String leagueName, @RequestParam("leagueNation") Integer leagueNationId,
			@RequestParam("leagueEmblem") String leagueEmblem) {

		League l = new League();
		if (leagueId != null && !leagueId.isEmpty()) {
			l = leagueService.getLeagueById(Integer.valueOf(leagueId));
		}
		l.setName(leagueName);
		l.setNation(nationService.getNationById(leagueNationId));
		l.setEmblem(leagueEmblem);

		leagueService.saveOrUpdateLeague(l);
		return "redirect:/team";
	}

	@RequestMapping(value = "/getLeagueById")
	@ResponseBody
	public League getLeagueById(@RequestParam("leagueId") Integer leagueId) {

		return leagueService.getLeagueById(leagueId);
	}
}
