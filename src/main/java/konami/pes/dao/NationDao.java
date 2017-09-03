package konami.pes.dao;
import java.util.List;

import konami.pes.domain.Nation;;

public interface NationDao {

	public List<Nation> getNationsByContinentName(String continentName);
	public List<Nation> getAllNations();
	public Nation getNationById(Integer nationId);
	public boolean saveOrUpdateNation(Nation nation);
}
