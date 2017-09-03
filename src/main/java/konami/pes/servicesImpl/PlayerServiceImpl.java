package konami.pes.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konami.pes.dao.PlayerDao;
import konami.pes.domain.Player;
import konami.pes.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerDao playerDao;
	
	public List<Player> getAllPlayers() {
		
		return playerDao.getAllPlayers();
	}

	public String getPlayerImage(Integer playerId) {
		
		return playerDao.getPlayerImage(playerId);
	}

	public Player getPlayerById(Integer playerId) {
		
		return playerDao.getPlayerById(playerId);
	}

	public boolean savePlayer(Player player) {
		
		return playerDao.savePlayer(player);
	}

}
