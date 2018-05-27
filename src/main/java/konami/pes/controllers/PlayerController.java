package konami.pes.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import konami.pes.domain.Player;

import konami.pes.services.PlayerService;

@Controller
@RequestMapping(value = "/player")
public class PlayerController {

	@Autowired
	PlayerService playerService;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/getPlayerImage", method = RequestMethod.GET)
	@ResponseBody
	public String getPlayerImage(@RequestParam("playerId") Integer playerId) {

		return playerService.getPlayerImage(playerId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showPlayers(Model model) {

		List<Player> players = playerService.getAllPlayers();
		model.addAttribute("players", players);
		return "players";
	}

	@RequestMapping(value = "/saveOrUpdatePlayer", method = RequestMethod.POST)
	public String saveOrUpdatePlayer(@RequestParam("playerId") String playerId,
			@RequestParam("playerName") String playerName, @RequestParam("playerImage") String playerImage) {

		Player p = new Player();
		if (playerId != null && !playerId.isEmpty()) {
			p = playerService.getPlayerById(Integer.valueOf(playerId));
		}
		p.setName(playerName);
		p.setImage(playerImage);

		playerService.savePlayer(p);
		return "redirect:/player";
	}

	@RequestMapping(value = "/getPlayerById", method = RequestMethod.GET)
	@ResponseBody
	public Player getPlayerById(@RequestParam("playerId") Integer playerId) {

		return playerService.getPlayerById(playerId);
	}
}
