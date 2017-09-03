package konami.pes.services;

import konami.pes.domain.Team;

public interface TeamService {

	public String getTeamEmblem(Integer teamId);
	public Team getTeamById(Integer teamId);
}
