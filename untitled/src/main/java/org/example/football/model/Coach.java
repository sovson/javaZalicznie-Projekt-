package org.example.football.model;

import org.example.football.utils.PerformOperation;

public class Coach extends Person implements PerformOperation {
		private Float experience;
		private Team team;

		@Override
		public String toString() {
				return "Trener: " +
								"ID: " + getId() +
								", Imię: " + getName() +
								", Data urodzin: " + getDate() +
								", Wiek: " + getAge() +
								", Numer krajowy: " + getNationalID() +
								", Doświadczenie (lata): " + experience +
								(team != null ? ", Prowadzi drużynę: " + team.getTeamName() : ", Brak drużyny");
		}

		public Coach(String name, String date, Short age, int nationalID, Float experience) {
				super(name, date, age, nationalID);
				this.experience = experience;
				this.team = null;
		}

		public Float getExperience() {
				return experience;
		}

		public void setExperience(Float experience) {
				this.experience = experience;
		}


		@Override
		public void ageup() {
				setAge((short) (getAge() + 1));
		}

		@Override
		public void agedown() {
				setAge((short) (getAge() - 1));
		}

		@Override
		public String getPersonInfo() {
				return null;
		}

		public void setTeam(Team team) {
				this.team = team;
		}

		public Team getTeam() {
				return team;
		}

		public void removeTeam() {
				if (team != null) {
						team.setCoach(null);
						team = null;
				}
		}

}
