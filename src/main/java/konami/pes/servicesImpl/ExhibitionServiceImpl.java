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
