package konami.pes.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Continent {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO, generator="CONTINENT_SEQ")
	@SequenceGenerator(name="CONTINENT_SEQ", sequenceName="CONTINENT_SEQ")
	private Integer id;
	private String name;
	private String emblem;
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="continent")
//	private List<Nation> nations;
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
//	public List<Nation> getNations() {
//		return nations;
//	}
//	public void setNations(List<Nation> nations) {
//		this.nations = nations;
//	}
	
	
}
