package konami.pes.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import konami.pes.domain.Player;

@Entity
public class Exhibition {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO, generator="EXHIBITION_SEQ")
	@SequenceGenerator(name="EXHIBITION_SEQ", sequenceName="EXHIBITION_SEQ")
	private Integer id;
	@NotNull
	@Min(value=0)
	private Integer score1;
	@NotNull
	@Min(value=0)
	private Integer score2;
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Player player1;
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Player player2;
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Team team1;
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Team team2;
	@Column(name="DATE_PLAYED")
	private Date date;
	private Boolean interrupted;
	
	
	public Boolean getInterrupted() {
		return interrupted;
	}
	public void setInterrupted(Boolean interrupted) {
		this.interrupted = interrupted;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScore1() {
		return score1;
	}
	public void setScore1(Integer score1) {
		this.score1 = score1;
	}
	public Integer getScore2() {
		return score2;
	}
	public void setScore2(Integer score2) {
		this.score2 = score2;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
