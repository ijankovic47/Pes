package konami.pes.services;

import java.util.List;

import konami.pes.domain.Exhibition;
import konami.pes.model.PlayerStats;

public interface ExhibitionService {

	public boolean saveExhibition(Exhibition exhibition);
	public List<Exhibition> getExhibitionsByPlayerId(Integer playerId,Integer count);
	public PlayerStats getPlayerStats(Integer playerId);
}
