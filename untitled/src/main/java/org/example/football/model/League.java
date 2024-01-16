package org.example.football.model;

import org.example.football.utils.PerformOperation;

import java.util.ArrayList;
import java.util.List;

public class League extends DataBaseObject {


		private String leagueName;
		private List<Team> teams;

		@Override
		public String toString() {
				StringBuilder result = new StringBuilder("Liga: " +
								"ID: " + getId() +
								", Nazwa kraju pochodzenia ligii: '" + getName() + '\'' +
								", Data założenia ligi: " + getDate() +
								", Nazwa ligi: '" + leagueName + '\'' +
								"\nDrużyny w lidze: ");

				if (teams.isEmpty()) {
						result.append("Brak drużyn w lidze.");
				} else {
						for (Team team : teams) {
								result.append("\n").append(team.getTeamName());
						}
				}

				return result.toString();
		}


		public League(int id, String name, String date, String leagueName) {
				super(id, name, date);
				this.leagueName = leagueName;
				this.teams = new ArrayList<>();
		}

		public List<Team> getTeams() {
				return teams;
		}

		public void addTeam(Team team) {
				if (team != null) {
						teams.add(team);
						team.setLeague(this);
				}
		}

		public void addTeamToLeague(Team team) {
				if (team != null) {
						teams.add(team);
						System.out.println("Drużyna dodana do ligi.");
				} else {
						System.out.println("Nie można dodać pustej drużyny do ligi.");
				}
		}

		public String getLeagueName() {
				return leagueName;
		}

		public void setLeagueName(String leagueName) {
				this.leagueName = leagueName;
		}
}