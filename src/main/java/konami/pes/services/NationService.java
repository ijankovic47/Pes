package konami.pes.services;
import java.io.File;
import java.util.List;

import konami.pes.domain.Nation;

public interface NationService {

	public static final String NATION_IMAGES_PATH="resources"+File.separator+"images"+File.separator+"teams";
	
	
	public List<Nation> getNationsByContinentName(String continentName);
	public List<Nation> getAllNations();
	public Nation getNationById(Integer nationId);
	public boolean saveOrUpdateNation(Nation nation);
}
