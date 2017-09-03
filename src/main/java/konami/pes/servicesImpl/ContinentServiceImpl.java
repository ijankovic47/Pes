package konami.pes.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konami.pes.dao.ContinentDao;
import konami.pes.domain.Continent;
import konami.pes.services.ContinentService;

@Service
public class ContinentServiceImpl implements ContinentService{

	@Autowired
	ContinentDao continentDao;
	
	public List<Continent> getAllContinents() {
		
		return continentDao.getAllContinents();
	}

	public String getContinentEmblem(String continentName) {

		return continentDao.getContinentEmblem(continentName);
	}

	public Continent getContinentByName(String continentName) {
		
		return continentDao.getContinentByName(continentName);
	}

	public Continent getContinentById(Integer continentId) {
		
		return continentDao.getContinentById(continentId);
	}

	public boolean saveOrUpdateContinent(Continent continent) {
		
		return continentDao.saveOrUpdateContinent(continent);
	}

}
