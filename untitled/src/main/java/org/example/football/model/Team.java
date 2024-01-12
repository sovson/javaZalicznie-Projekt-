package org.example.football.model;

import org.example.football.utils.PerformOperation;

public class Team extends DataBaseObject implements PerformOperation {

		private String teamName;
		private int pointsLeague;
		private Coach coach;

		@Override
		public String toString() {
				return "Team{" +
								"teamName='" + teamName + '\'' +
								", pointsLeague=" + pointsLeague +
								", coach=" + coach +
								'}';
		}

		public Team(int id, String name, Long date, String teamName, int pointsLeague, Coach coach) {
				super(id, name, date);
				this.teamName = teamName;
				this.pointsLeague = pointsLeague;
				this.coach = coach;
		}

		public String getTeamName() {
				return teamName;
		}

		public void setTeamName(String teamName) {
				this.teamName = teamName;
		}

		public int getPointsLeague() {
				return pointsLeague;
		}

		public void setPointsLeague(int pointsLeague) {
				this.pointsLeague = pointsLeague;
		}

		public Coach getCoach() {
				return coach;
		}

		public void setCoach(Coach coach) {
				this.coach = coach;
		}

		@Override
		public void performOperation() {

		}
}