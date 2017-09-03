package konami.pes.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Role {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO, generator="ROLE_SEQ")
	@SequenceGenerator(name="ROLE_SEQ", sequenceName="ROLE_SEQ")
	@Column(name="ROLE_ID")
	private Integer id;
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "OPERATOR_ROLE",  joinColumns = {
			@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "OPERATOR_ID",
					nullable = false, updatable = false) })
	private List<Operator> operators;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
