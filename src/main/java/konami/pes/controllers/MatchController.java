package konami.pes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import konami.pes.domain.Continent;
import konami.pes.domain.Exhibition;
import konami.pes.domain.League;
import konami.pes.domain.Player;
import konami.pes.services.ContinentService;
import konami.pes.services.ExhibitionService;
import konami.pes.services.LeagueService;
import konami.pes.services.PlayerService;

@Controller
@RequestMapping(value="/match")
public class MatchController {

	@Autowired
	PlayerService playerService;
	@Autowired
	LeagueService leagueService;
	@Autowired
	ContinentService continentService;
	@Autowired
	ExhibitionService exhibitionService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String playMatch(Model model){
		
		List<Player> players=playerService.getAllPlayers();
		List<League> leagues=leagueService.getAllLeagues();
		List<Continent> continents=continentService.getAllContinents();
		model.addAttribute("players", players);
		model.addAttribute("leagues", leagues);
		model.addAttribute("continents", continents);
		if(!model.containsAttribute("exhibition")){
			model.addAttribute("exhibition", new Exhibition());
		}
		
		
		return "match"; 
	}
	@RequestMapping(value="/playExhibition",method=RequestMethod.POST)
	public String playExhibition(@Valid@ModelAttribute("exhibition") Exhibition exhibition, BindingResult br, RedirectAttributes model,@RequestParam("league1") String league1name ,@RequestParam("league2") String league2name){
		
		if(br.hasErrors()){
			return "redirect:/match";
		}
		boolean saved=exhibitionService.saveExhibition(exhibition);
		exhibition.setScore1(null);
		exhibition.setScore2(null);
		model.addFlashAttribute("exhibition", exhibition);
		model.addFlashAttribute("league1name", league1name);
		model.addFlashAttribute("league2name", league2name);
		return "redirect:/match";
	}
	@RequestMapping(value="/getLeagueOrContinentEmblem",method=RequestMethod.GET)
	@ResponseBody
	public String getLeagueOrContinentEmblem(@RequestParam("leagueOrContinentName") String name){
		
		String emblem=leagueService.getLeagueEmblem(name);
		if(emblem!=null){
			return emblem;
		}
		return continentService.getContinentEmblem(name);
	}
}
