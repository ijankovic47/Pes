package konami.pes.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.ClubDao;
import konami.pes.domain.Club;

@Repository
@Transactional
public class ClubDaoImpl implements ClubDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Club> getClubsByLeagueName(String leagueName) {
		
		List<Club> clubs=new ArrayList<Club>();
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c from Club c where c.league.name='"+leagueName+"' order by c.name");
		clubs=q.list();
		return clubs;
	}

	public Club getClubById(Integer clubId) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c from Club c where c.id="+clubId).setMaxResults(1);
		Club c=(Club) q.list().get(0);
		return c;
	}

	public List<Club> getAllClubs() {
		
		List<Club> clubs=new ArrayList<Club>();
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c from Club c order by c.name");
		clubs=q.list();
		return clubs;
	}

	public boolean saveClub(Club club) {
		
		Session s=sessionFactory.getCurrentSession();
		s.saveOrUpdate(club);
		return true;
	}

}
