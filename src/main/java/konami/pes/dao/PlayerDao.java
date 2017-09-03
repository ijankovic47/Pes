package konami.pes.dao;

import java.util.List;

import konami.pes.domain.Player;

public interface PlayerDao {

	public List<Player> getAllPlayers();
	public String getPlayerImage(Integer playerId);
	public Player getPlayerById(Integer playerId);
	public boolean savePlayer(Player player);
}
