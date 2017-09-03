package konami.pes.dao;

import konami.pes.domain.Team;

public interface TeamDao {

	public String getTeamEmblem(Integer teamId);
	public Team getTeamById(Integer teamId);
}
