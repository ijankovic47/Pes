package konami.pes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import konami.pes.domain.Exhibition;
import konami.pes.domain.Player;
import konami.pes.model.PlayerStats;
import konami.pes.services.ExhibitionService;
import konami.pes.services.PlayerService;

@Controller
@RequestMapping(value="/exhibition")
public class ExhibitionController {

	@Autowired
	PlayerService playerService;
	@Autowired
	ExhibitionService exhibitionService;
	
	@RequestMapping(value="/getPlayerStats")
	@ResponseBody
	public PlayerStats getPlayerStats(@RequestParam("playerId") Integer playerId){
		
		Player p=playerService.getPlayerById(playerId);
		PlayerStats ps=new PlayerStats();
		ps.setPlayer(p);
		ps.setExhibitions(exhibitionService.getExhibitionsByPlayerId(playerId,null));
		return ps;
	}
	@RequestMapping(value="/getPlayerExhibitions")
	@ResponseBody
	public List<Exhibition> getPlayerExhibitions(@RequestParam("playerId")  Integer playerId){
		
		return exhibitionService.getExhibitionsByPlayerId(playerId, null);
	}
}
