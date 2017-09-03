package konami.pes.services;

import java.io.File;
import java.util.List;

import konami.pes.domain.League;

public interface LeagueService {

	public static final String LEAGUES_CONTINENTS_IMAGES_PATH="resources"+File.separator+"images"+File.separator+"leagues_continents";
	
	public List<League> getAllLeagues();
	public String getLeagueEmblem(String leagueName);
	public League getLeagueById(Integer leagueId);
	public League getLeagueByName(String leagueName);
	public boolean saveOrUpdateLeague(League league);
}
