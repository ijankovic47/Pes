package konami.pes.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.PlayerDao;
import konami.pes.domain.Player;

@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {

		List<Player> players=new ArrayList<Player>();
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select p from Player p");
		players=q.list();
		return players;
	}

	public String getPlayerImage(Integer playerId) {
		
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select p.image from Player p where p.id="+playerId).setMaxResults(1);
		if(!q.list().isEmpty()){
			return q.list().get(0).toString();
		}
		return null;
	}

	public Player getPlayerById(Integer playerId) {
		
		Session s=sessionFactory.getCurrentSession();
	    Query q=s.createQuery("select p from Player p where p.id="+playerId).setMaxResults(1);
	    Player p=(Player) q.list().get(0);
	    return p;
	}

	public boolean savePlayer(Player player) {
		Session s=sessionFactory.getCurrentSession();
	    s.saveOrUpdate(player);
	    return true;
	}

}
