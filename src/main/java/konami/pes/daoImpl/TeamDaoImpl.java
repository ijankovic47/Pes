package konami.pes.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.TeamDao;
import konami.pes.domain.Club;
import konami.pes.domain.Nation;
import konami.pes.domain.Team;

@Repository
@Transactional
public class TeamDaoImpl implements TeamDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public String getTeamEmblem(Integer teamId) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select t.emblem from Team t where t.id="+teamId).setMaxResults(1);
		if(!q.list().isEmpty()){
			return q.list().get(0).toString();
		}
		return null;
	}

	public Team getTeamById(Integer teamId) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c from Club c where c.id="+teamId).setMaxResults(1);
		if(!q.list().isEmpty()){
			Club c=(Club) q.list().get(0);
			return c;
		}
		else{
			q=s.createQuery("select n from Nation n where n.id="+teamId).setMaxResults(1);
			Nation n=(Nation) q.list().get(0);
			return n;
		}
		
	}

}
