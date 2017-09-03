package konami.pes.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.ContinentDao;
import konami.pes.domain.Continent;

@Repository
@Transactional
public class ContinentDaoImpl implements ContinentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Continent> getAllContinents() {
		
		List<Continent> continents=new ArrayList<Continent>();
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c from Continent c");
		continents=q.list();
		return continents;
	}

	public String getContinentEmblem(String continentName) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c.emblem from Continent c where c.name='"+continentName+"'");
		if(q.list().size()>0){
			if(q.list().get(0)!=null){
			return q.list().get(0).toString();
			}
		}
		return null;
	}

	public Continent getContinentByName(String continentName) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c from Continent c where c.name='"+continentName+"'").setMaxResults(1);
		if(q.list().isEmpty()){
			return null;
		}
		Continent c=(Continent) q.list().get(0);
		return c;
	}

	public Continent getContinentById(Integer continentId) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select c from Continent c where c.id="+continentId).setMaxResults(1);
		if(q.list().isEmpty()){
			return null;
		}
		Continent c=(Continent) q.list().get(0);
		return c;
	}

	public boolean saveOrUpdateContinent(Continent continent) {
		
		Session s=sessionFactory.getCurrentSession();
		s.saveOrUpdate(continent);
		return true;
	}

}
