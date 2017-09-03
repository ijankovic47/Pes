package konami.pes.dao;
import java.util.List;

import konami.pes.domain.Continent;
public interface ContinentDao {

	public List<Continent> getAllContinents();
	public String getContinentEmblem(String continentName);
	public Continent getContinentByName(String continentName);
	public Continent getContinentById(Integer continentId);
	public boolean saveOrUpdateContinent(Continent continent);
}
