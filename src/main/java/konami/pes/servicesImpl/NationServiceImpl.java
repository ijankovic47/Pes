package konami.pes.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konami.pes.dao.NationDao;
import konami.pes.domain.Nation;
import konami.pes.services.NationService;

@Service
public class NationServiceImpl implements NationService{

	@Autowired
	NationDao nationDao;

	public List<Nation> getNationsByContinentName(String continentName) {
		
		return nationDao.getNationsByContinentName(continentName);
	}

	public List<Nation> getAllNations() {
		
		return nationDao.getAllNations();
	}

	public Nation getNationById(Integer nationId) {

		return nationDao.getNationById(nationId);
	}

	public boolean saveOrUpdateNation(Nation nation) {
		
		return nationDao.saveOrUpdateNation(nation);
	}
	
	
}
