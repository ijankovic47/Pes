package konami.pes.services;

import java.io.File;
import java.util.List;

import konami.pes.domain.Continent;

public interface ContinentService {

	public static final String LEAGUES_CONTINENTS_IMAGES_PATH="resources"+File.separator+"images"+File.separator+"leagues_continents";
	
	public List<Continent> getAllContinents();
	public String getContinentEmblem(String continentName);
	public Continent getContinentByName(String continentName);
	public Continent getContinentById(Integer continentId);
	public boolean saveOrUpdateContinent(Continent continent);
}
