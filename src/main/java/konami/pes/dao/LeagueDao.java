package konami.pes.dao;

import java.util.List;

import konami.pes.domain.League;

public interface LeagueDao {

	public List<League> getAllLeagues();
	public String getLeagueEmblem(String leagueName);
	public League getLeagueById(Integer leagueId);
	public League getLeagueByName(String leagueName);
	public boolean saveOrUpdateLeague(League league);
}
