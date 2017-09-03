package konami.pes.services;

import java.io.File;
import java.util.List;

import konami.pes.domain.Club;

public interface ClubService {

	public static final String CLUB_IMAGES_PATH="resources"+File.separator+"images"+File.separator+"teams";
	
	public List<Club> getClubsByLeagueName(String leagueName);
	public Club getClubById(Integer clubId);
	public List<Club> getAllClubs();
	public boolean saveClub(Club c);
}
