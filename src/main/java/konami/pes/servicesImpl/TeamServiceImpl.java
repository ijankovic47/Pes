package konami.pes.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konami.pes.dao.TeamDao;
import konami.pes.domain.Team;
import konami.pes.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamDao teamDao;
	public String getTeamEmblem(Integer teamId) {
		
		return teamDao.getTeamEmblem(teamId);
	}
	public Team getTeamById(Integer teamId) {
		
		return teamDao.getTeamById(teamId);
	}

}
