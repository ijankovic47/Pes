package konami.pes.servicesImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konami.pes.dao.ExhibitionDao;
import konami.pes.domain.Exhibition;
import konami.pes.model.PlayerStats;
import konami.pes.services.ExhibitionService;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {

	@Autowired
	ExhibitionDao exhibitionDao;
	
	public boolean saveExhibition(Exhibition exhibition) {
		
		Date now=new Date();
		exhibition.setDate(now);
		System.out.println(exhibition.getDate());
		System.out.println(exhibition.getPlayer1().getId());
		System.out.println(exhibition.getPlayer2().getId());
		System.out.println(exhibition.getTeam1().getId());
		System.out.println(exhibition.getTeam2().getId());
		System.out.println(exhibition.getScore1());
		System.out.println(exhibition.getScore2());
		System.out.println(exhibition.getInterrupted());
		exhibition.setInterrupted(true);
		return exhibitionDao.saveExhibition(exhibition);
	}

	public List<Exhibition> getExhibitionsByPlayerId(Integer playerId,Integer count) {
		
		return exhibitionDao.getExhibitionByPlayerId(playerId,count);
	}

	public PlayerStats getPlayerStats(Integer playerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
