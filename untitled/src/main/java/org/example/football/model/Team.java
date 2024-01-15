package org.example.football.model;


public class Team extends DataBaseObject {

		private String teamName;
		private int pointsLeague;
		private Coach coach;

		@Override
		public String toString() {
				return "Drużyna: " +
								"ID: " + getId() +
								", Nazwa kraju pochodzenia teamu: '" + getName() + '\'' +
								", Data założenia drużyny: " + getDate() +
								", Nazwa drużyny: '" + teamName + '\'' +
								", Ilość punktów w lidze: " + pointsLeague +
								", Trener: " + coach.getName();

		}

		public Team(int id, String name, String date, String teamName, int pointsLeague, Coach coach) {
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


}