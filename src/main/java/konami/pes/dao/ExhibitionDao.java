package konami.pes.dao;
import java.util.List;

import konami.pes.domain.Exhibition;
public interface ExhibitionDao {

	public boolean saveExhibition(Exhibition exhibition);
	public List<Exhibition> getExhibitionByPlayerId(Integer playerId,Integer count);
}
