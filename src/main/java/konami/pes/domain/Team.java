package konami.pes.domain;

import javax.persistence.Entity;
import com.google.gson.Gson;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Team {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO, generator="TEAM_SEQ")
	@SequenceGenerator(name="TEAM_SEQ", sequenceName="TEAM_SEQ")
	private Integer id;
	private String name;
	private String emblem;
	
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
	public String toString(){
		Gson gson=new Gson();
		return gson.toJson(this);
	}
	
	
}
