package konami.pes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PlayerStatsPerTeam {

	private Integer totalMatches = 0;
	private Integer totalWins = 0;
	private Integer totalDraws = 0;
	private Integer totalLoses = 0;
	private Integer totalGoalsScored = 0;
	private Integer totalGoalsConceded = 0;

	public Double getWinPercentage() {

		if (totalMatches == 0) {
			return (double) 0;
		}
		double percentage=100.0 * (double)totalWins / (double)totalMatches;
		return formatDouble(percentage);
	}

	public Double getDrawPercentage() {

		if (totalMatches == 0) {
			return (double) 0;
		}
		double percentage=100.0 * (double)totalDraws / (double)totalMatches;
		return formatDouble(percentage);
	}

	public Double getLosePercentage() {

		if (totalMatches == 0) {
			return (double) 0;
		}
		double percentage=100.0 * (double)totalLoses / (double)totalMatches;
		return formatDouble(percentage);
	}

	public Double getGoalsScoredPerMatch() {

		if (totalMatches == 0) {
			return (double) 0;
		}
		return formatDouble((double)totalGoalsScored / (double)totalMatches);
	}

	public Double getGoalsConcededPerMatch() {

		if (totalMatches == 0) {
			return (double) 0;
		}
		return formatDouble((double)totalGoalsConceded / (double)totalMatches);
	}

	public Integer getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(Integer totalMatches) {
		this.totalMatches = totalMatches;
	}

	public Integer getTotalWins() {
		return totalWins;
	}

	public void setTotalWins(Integer totalWins) {
		this.totalWins = totalWins;
	}

	public Integer getTotalDraws() {
		return totalDraws;
	}

	public void setTotalDraws(Integer totalDraws) {
		this.totalDraws = totalDraws;
	}

	public Integer getTotalLoses() {
		return totalLoses;
	}

	public void setTotalLoses(Integer totalLoses) {
		this.totalLoses = totalLoses;
	}

	public Integer getTotalGoalsScored() {
		return totalGoalsScored;
	}

	public void setTotalGoalsScored(Integer totalGoalsScored) {
		this.totalGoalsScored = totalGoalsScored;
	}

	public Integer getTotalGoalsConceded() {
		return totalGoalsConceded;
	}

	public void setTotalGoalsConceded(Integer totalGoalsConceded) {
		this.totalGoalsConceded = totalGoalsConceded;
	}
	private double formatDouble(double d) {

		DecimalFormat df = new DecimalFormat("#.##");
		double p = Double.parseDouble(df.format(d));
		return p;
	}
}
