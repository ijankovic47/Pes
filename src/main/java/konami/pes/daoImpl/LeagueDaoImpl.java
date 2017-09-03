package konami.pes.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.LeagueDao;
import konami.pes.domain.League;

@Repository
@Transactional
public class LeagueDaoImpl implements LeagueDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<League> getAllLeagues() {
	
		List<League> leagues=new ArrayList<League>();
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select l from League l");
		leagues=q.list();
		return leagues;
	}

	public String getLeagueEmblem(String leagueName) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select l.emblem from League l where l.name='"+leagueName+"'").setMaxResults(1);
		if(q.list().size()>0){
			if(q.list().get(0)!=null){
			return q.list().get(0).toString();
			}
		}
		return null;
	}

	public League getLeagueById(Integer leagueId) {
	
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select l from League l where l.id="+leagueId).setMaxResults(1);
		League l=(League) q.list().get(0);
		return l;
	}

	public League getLeagueByName(String leagueName) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select l from League l where l.name="+leagueName).setMaxResults(1);
		if(q.list().isEmpty()){
			return null;
		}
		League l=(League) q.list().get(0);
		return l;
	}

	public boolean saveOrUpdateLeague(League league) {
		
		Session s=sessionFactory.getCurrentSession();
		s.saveOrUpdate(league);
		return true;
	}

}
