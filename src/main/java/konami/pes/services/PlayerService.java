package konami.pes.services;
import java.io.File;
import java.util.List;

import konami.pes.domain.Player;
public interface PlayerService {

	public static final String PLAYER_IMAGES_PATH="resources"+File.separator+"images"+File.separator+"players";
	
	public List<Player> getAllPlayers();
	public String getPlayerImage(Integer playerId);
	public Player getPlayerById(Integer playerId);
	public boolean savePlayer(Player player);
}
