package konami.pes.dao;

import java.util.List;

import konami.pes.domain.Club;

public interface ClubDao {

	public List<Club> getClubsByLeagueName(String leagueName);
	public Club getClubById(Integer clubId);
	public List<Club> getAllClubs();
	public boolean saveClub(Club club);
}
