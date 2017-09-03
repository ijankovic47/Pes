package konami.pes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import konami.pes.domain.Exhibition;
import konami.pes.domain.Player;
import konami.pes.domain.Team;

public class PlayerStats {

	private List<Exhibition> exhibitions;
	private Player player;

	public Integer getTotalMatches() {

		return exhibitions.size();
	}

	public Integer getTotalWins() {

		int totalWins = 0;
		for (Exhibition e : exhibitions) {
			if (player.getId() == e.getPlayer1().getId() && e.getScore1() > e.getScore2()) {
				totalWins++;
			} else if (player.getId() == e.getPlayer2().getId() && e.getScore2() > e.getScore1()) {
				totalWins++;
			}
		}
		return totalWins;
	}

	public Integer getTotalLoses() {

		int totalLoses = 0;
		for (Exhibition e : exhibitions) {
			if (player.getId() == e.getPlayer1().getId() && e.getScore1() < e.getScore2()) {
				totalLoses++;
			} else if (player.getId() == e.getPlayer2().getId() && e.getScore2() < e.getScore1()) {
				totalLoses++;
			}
		}
		return totalLoses;
	}

	public Integer getTotalDraws() {

		int totalDraws = 0;
		for (Exhibition e : exhibitions) {
			if (e.getScore1() == e.getScore2()) {
				totalDraws++;
			}
		}
		return totalDraws;
	}

	public Double getWinPercentage() {
		int totalMatches = getTotalMatches();
		if (totalMatches == 0) {
			return (double) 0;
		}
		double winPercentage = 0;
		winPercentage = 100.0 * (double)getTotalWins() / (double)getTotalMatches();
		return formatDouble(winPercentage);
	}

	public Double getLosePercentage() {
		int totalMatches = getTotalMatches();
		if (totalMatches == 0) {
			return (double) 0;
		}
		double losePercentage = 0;
		losePercentage = 100.0 * (double)getTotalLoses() / (double)getTotalMatches();
		return formatDouble(losePercentage);
	}

	public Double getDrawPercentage() {
		int totalMatches = getTotalMatches();
		if (totalMatches == 0) {
			return (double) 0;
		}
		double drawPercentage = 0;
		drawPercentage = 100.0 * (double)getTotalDraws() / (double)getTotalMatches();
		return formatDouble(drawPercentage);
	}

	public Double getGoalsScoredPerMatch() {

		if (getTotalMatches() == 0) {
			return (double) 0;
		}
		double totalGoals = 0;
		for (Exhibition e : exhibitions) {
			if (e.getPlayer1().getId() == getPlayer().getId()) {
				totalGoals += e.getScore1();
			} else if (e.getPlayer2().getId() == getPlayer().getId()) {
				totalGoals += e.getScore2();
			}
		}
		return formatDouble((double)totalGoals / (double)getTotalMatches());
	}

	public Double getGoalsConcededPerMatch() {

		if (getTotalMatches() == 0) {
			return (double) 0;
		}
		double totalGoals = 0;
		for (Exhibition e : exhibitions) {
			if (e.getPlayer1().getId() == getPlayer().getId()) {
				totalGoals += e.getScore2();
			} else if (e.getPlayer2().getId() == getPlayer().getId()) {
				totalGoals += e.getScore1();
			}
		}
		return formatDouble((double)totalGoals / (double)getTotalMatches());
	}
	
	public Map<Team, PlayerStatsPerTeam> getPlayerStatsPerTeam(){
		
		Map<Team,PlayerStatsPerTeam> pspt=new HashMap<Team, PlayerStatsPerTeam>();
		for(Exhibition e:exhibitions){
			if(getPlayer().getId()==e.getPlayer1().getId()){
				if(!pspt.containsKey(e.getTeam1())){
					pspt.put(e.getTeam1(), new PlayerStatsPerTeam());
				}
					PlayerStatsPerTeam ps=pspt.get(e.getTeam1());
					ps.setTotalMatches((ps.getTotalMatches()+1));
					if(e.getScore1()>e.getScore2()){
						ps.setTotalWins((ps.getTotalWins()+1));
					}
					else if(e.getScore1()<e.getScore2()){
						ps.setTotalLoses((ps.getTotalLoses()+1));
					}
					else{
						ps.setTotalDraws((ps.getTotalDraws()+1));
					}
					ps.setTotalGoalsScored((ps.getTotalGoalsScored()+e.getScore1()));
					ps.setTotalGoalsConceded((ps.getTotalGoalsConceded()+e.getScore2()));
					pspt.put(e.getTeam1(), ps);
			}
			
			else if(getPlayer().getId()==e.getPlayer2().getId()){
				if(!pspt.containsKey(e.getTeam2())){
					pspt.put(e.getTeam2(), new PlayerStatsPerTeam());
				}
					PlayerStatsPerTeam ps=pspt.get(e.getTeam2());
					ps.setTotalMatches((ps.getTotalMatches()+1));
					if(e.getScore2()>e.getScore1()){
						ps.setTotalWins((ps.getTotalWins()+1));
					}
					else if(e.getScore2()<e.getScore1()){
						ps.setTotalLoses((ps.getTotalLoses()+1));
					}
					else{
						ps.setTotalDraws((ps.getTotalDraws()+1));
					}
					ps.setTotalGoalsScored((ps.getTotalGoalsScored()+e.getScore2()));
					ps.setTotalGoalsConceded((ps.getTotalGoalsConceded()+e.getScore1()));
					pspt.put(e.getTeam2(), ps);
			}
		}
		
		
		
		return sortPspt(pspt);
	}
	private double formatDouble(double d) {

		DecimalFormat df = new DecimalFormat("#.##");
		double p = Double.parseDouble(df.format(d));
		return p;
	}

	public List<Exhibition> getExhibitions() {
		return exhibitions;
	}

	public void setExhibitions(List<Exhibition> exhibitions) {
		this.exhibitions = exhibitions;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	private Map<Team,PlayerStatsPerTeam> sortPspt(Map<Team,PlayerStatsPerTeam> pspt){
		
		Map<Team,PlayerStatsPerTeam> sorted=new LinkedHashMap<Team, PlayerStatsPerTeam>();
		List<Entry<Team, PlayerStatsPerTeam>> list=new ArrayList<Entry<Team, PlayerStatsPerTeam>>(pspt.entrySet());
		boolean a=true;
		while(a){
			a=false;
			for(int i=0;i<list.size()-1;i++){
				if(list.get(i).getValue().getTotalMatches()<list.get(i+1).getValue().getTotalMatches()){
					Entry<Team, PlayerStatsPerTeam> pom=list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, pom);
					a=true;
				}
			}
		}
		for(Entry<Team, PlayerStatsPerTeam> e:list){
			sorted.put(e.getKey(), e.getValue());
		}
		return sorted;
	}

}
