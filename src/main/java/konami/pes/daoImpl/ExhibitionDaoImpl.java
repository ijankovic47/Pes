package konami.pes.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.ExhibitionDao;
import konami.pes.domain.Exhibition;

@Repository
@Transactional
public class ExhibitionDaoImpl implements ExhibitionDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean saveExhibition(Exhibition exhibition) {
		
		Session s=sessionFactory.getCurrentSession();
	    Integer i=(Integer) s.save(exhibition);
		if(i!=null){
	    return true;
		}
		return false;
	}

	public List<Exhibition> getExhibitionByPlayerId(Integer playerId,Integer count) {
		
		List<Exhibition> exhibitions=new ArrayList<Exhibition>();
		Session s=sessionFactory.getCurrentSession();
		Query q=null;
		if(count==null){
		q=s.createQuery("select e from Exhibition e where (e.player1.id="+playerId+" or e.player2.id="+playerId+") order by e.date desc");
		}
		else{
			q=s.createQuery("select e from Exhibition e where (e.player1.id="+playerId+" or e.player2.id="+playerId+") order by e.date desc").setMaxResults(count);
		}
		exhibitions=q.list();
		return exhibitions;
	}

}
