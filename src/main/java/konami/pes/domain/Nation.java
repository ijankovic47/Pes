package konami.pes.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Nation extends Team{

	@ManyToOne(fetch=FetchType.EAGER)
	private Continent continent;
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="nation")
//	private List<League> leagues;
	
	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

//	public List<League> getLeagues() {
//		return leagues;
//	}
//
//	public void setLeagues(List<League> leagues) {
//		this.leagues = leagues;
//	}
}
