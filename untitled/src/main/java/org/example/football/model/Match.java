package org.example.football.model;

import org.example.football.utils.PerformOperation;

import java.util.List;

public class Match extends DataBaseObject implements PerformOperation {

		private String Stadium;
		private Team homeTeam;
		private Team awayTeam;
		private List<Goal> goals;
		private Referee matchReferee;

		@Override
		public String toString() {
				return "Mecz: " + "ID: " + getId() +
								", Nazwa meczu (Drużyna X v Drużyna Y): '" + getName() + '\'' +
								", Data meczu (rok): " + getDate() +
								", Stadium='" + Stadium + '\'' +
								", homeTeam=" + homeTeam +
								", awayTeam=" + awayTeam +
								", goals=" + goals +
								", matchReferee=" + matchReferee +
								'}';
		}

		public Match(int id, String name, Long date, String stadium, Team homeTeam, Team awayTeam, List<Goal> goals, Referee matchReferee) {
				super(id, name, date);
				Stadium = stadium;
				this.homeTeam = homeTeam;
				this.awayTeam = awayTeam;
				this.goals = goals;
				this.matchReferee = matchReferee;
		}

		public String getStadium() {
				return Stadium;
		}

		public void setStadium(String stadium) {
				Stadium = stadium;
		}

		public Team getHomeTeam() {
				return homeTeam;
		}

		public void setHomeTeam(Team homeTeam) {
				this.homeTeam = homeTeam;
		}

		public Team getAwayTeam() {
				return awayTeam;
		}

		public void setAwayTeam(Team awayTeam) {
				this.awayTeam = awayTeam;
		}

		public List<Goal> getGoals() {
				return goals;
		}

		public void setGoals(List<Goal> goals) {
				this.goals = goals;
		}

		public Referee getMatchReferee() {
				return matchReferee;
		}

		public void setMatchReferee(Referee matchReferee) {
				this.matchReferee = matchReferee;
		}

		@Override
		public void performOperation() {

		}
}
