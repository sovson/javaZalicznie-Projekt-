package org.example.football.model;

import java.util.ArrayList;
import java.util.List;

public class Team extends DataBaseObject {

		private String teamName;
		private int pointsLeague;
		private Coach coach;
		private List<Player> players;


		@Override
		public String toString() {
				StringBuilder result = new StringBuilder("Drużyna: " +
								"ID: " + getId() +
								", Nazwa kraju pochodzenia teamu: '" + getName() + '\'' +
								", Data założenia drużyny: " + getDate() +
								", Nazwa drużyny: '" + teamName + '\'' +
								", Ilość punktów w lidze: " + pointsLeague +
								", Trener: " + (coach != null ? coach.getName() : "Brak trenera") +
								", Zawodnicy: ");
				if (players.isEmpty()) {
						result.append("Brak zawodników w drużynie.");
				} else {
						for (Player player : players) {
								result.append("\n").append(player.getName());
						}
				}

				return result.toString();

		}

		public Team(int id, String name, String date, String teamName, int pointsLeague, Coach coach) {
				super(id, name, date);
				this.teamName = teamName;
				this.pointsLeague = pointsLeague;
				assignCoach(coach);
				this.players = new ArrayList<>();

		}

		public void addPlayer(Player player) {
				if (player.getTeam() == null) {
						players.add(player);
						player.setTeam(this);
						System.out.println("Piłkarz dodany do drużyny.");
				} else {
						System.out.println("Piłkarz jest już przypisany do innej drużyny.");
				}
		}

		public List<Player> getPlayers() {
				return players;
		}

		public void assignCoach(Coach coach) {
				if (this.coach == null) {
						this.coach = coach;
						coach.setTeam(this);
				} else {
						System.out.println("Drużyna już ma przypisanego trenera.");
				}
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

		public void removeCoach() {
				if (coach != null) {
						coach.setTeam(null);
						coach = null;
				}
		}

}