package konami.pes.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import konami.pes.dao.OperatorDao;
import konami.pes.domain.Operator;
import konami.pes.domain.Role;
import konami.pes.services.OperatorService;

@Service
public class OperatorServiceImpl implements UserDetailsService, OperatorService {
	
	@Autowired
	OperatorDao operatorDao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Operator o=operatorDao.getOperatorByUsername(username);
		
		
		if(o!=null){
			List<GrantedAuthority> authorities =
					new ArrayList<GrantedAuthority>();
			for(Role role:o.getRoles()){
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			return new User(o.getUsername(),o.getPassword(),authorities);
		}
		throw new UsernameNotFoundException(
				"User '" + username + "' not found.");
	}

}
