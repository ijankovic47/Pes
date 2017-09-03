package konami.pes.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.NationDao;
import konami.pes.domain.Nation;

@Repository
@Transactional
public class NationDaoImpl implements NationDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Nation> getNationsByContinentName(String continentName) {
		
		List<Nation> nations=new ArrayList<Nation>();
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select n from Nation n where n.continent.name='"+continentName+"' order by n.name");
		nations=q.list();
		return nations;
	}

	public List<Nation> getAllNations() {
		
		List<Nation> nations=new ArrayList<Nation>();
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select n from Nation n order by n.name");
		nations=q.list();
		return nations;
	}

	public Nation getNationById(Integer nationId) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select n from Nation n where n.id="+nationId);
		Nation n=(Nation) q.list().get(0);
		return n;
	}

	public boolean saveOrUpdateNation(Nation nation) {
		
		Session s=sessionFactory.getCurrentSession();
		s.saveOrUpdate(nation);
		return true;
	}
}
