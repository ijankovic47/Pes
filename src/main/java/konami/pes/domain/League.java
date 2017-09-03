package konami.pes.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class League {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO, generator="LEAGUE_SEQ")
	@SequenceGenerator(name="LEAGUE_SEQ", sequenceName="LEAGUE_SEQ")
	private Integer id;
	private String name;
	private String emblem;
	@ManyToOne(fetch=FetchType.EAGER)
	private Nation nation;
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="league")
//	private List<Club> clubs;

	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmblem() {
		return emblem;
	}
	public void setEmblem(String emblem) {
		this.emblem = emblem;
	}
//	public List<Club> getClubs() {
//		return clubs;
//	}
//	public void setClubs(List<Club> clubs) {
//		this.clubs = clubs;
//	}
}
