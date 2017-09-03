package konami.pes.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konami.pes.dao.ClubDao;
import konami.pes.domain.Club;
import konami.pes.services.ClubService;

@Service
public class ClubServiceImpl implements ClubService{

	@Autowired
	ClubDao clubDao;
	
	public List<Club> getClubsByLeagueName(String leagueName) {
		
		return clubDao.getClubsByLeagueName(leagueName);
	}

	public Club getClubById(Integer clubId) {
		
		return clubDao.getClubById(clubId);
	}

	public List<Club> getAllClubs() {
		
		return clubDao.getAllClubs();
	}

	public boolean saveClub(Club c) {
		
		return clubDao.saveClub(c);
	}

}
