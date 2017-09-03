package konami.pes.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konami.pes.dao.LeagueDao;
import konami.pes.domain.League;
import konami.pes.services.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService{

	@Autowired
	LeagueDao leagueDao;
	
	public List<League> getAllLeagues() {
		
		return leagueDao.getAllLeagues();
	}

	public String getLeagueEmblem(String leagueName) {
		
		return leagueDao.getLeagueEmblem(leagueName);
	}

	public League getLeagueById(Integer leagueId) {
		
		return leagueDao.getLeagueById(leagueId);
	}

	public League getLeagueByName(String leagueName) {
		
		return leagueDao.getLeagueByName(leagueName);
	}

	public boolean saveOrUpdateLeague(League league) {
		
		return leagueDao.saveOrUpdateLeague(league);
	}

}
