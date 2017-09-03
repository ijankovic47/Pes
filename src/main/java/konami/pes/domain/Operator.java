package konami.pes.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Operator{
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO, generator="OPERATOR_SEQ")
	@SequenceGenerator(name="OPERATOR_SEQ", sequenceName="OPERATOR_SEQ")
	@Column(name="OPERATOR_ID")
	private Integer id;
	private String username;
	private String password;
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="operators")
	private List<Role> roles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
