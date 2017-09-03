package konami.pes.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import konami.pes.dao.OperatorDao;
import konami.pes.domain.Operator;

@Repository
@Transactional
public class OperatorDaoImpl implements OperatorDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Operator getOperatorByUsername(String username) {
		
		Operator o=null;
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("select o from Operator o where o.username='"+username+"'").setMaxResults(1);
		if(!q.list().isEmpty()){
			o=(Operator) q.list().get(0);
		}
		return o;
	}

}
