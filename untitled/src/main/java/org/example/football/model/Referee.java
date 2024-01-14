package org.example.football.model;

public class Referee extends Person {
		private String level;

		@Override
		public String toString() {
				return "Sędzia " +
								"ID: " + getId() +
								", Imię " + getName() +
								", Data urodzin: " + getDate() +
								", Wiek: " + getAge() +
								", Numer krajowy: " + getNationalID() +
								", poziom sędziowski (w latach): " + level + '\'';
		}

		public Referee(String name, Long date, Short age, int nationalID, String level) {
				super(name, date, age, nationalID);
				this.level = level;
		}

		public String getLevel() {
				return level;
		}

		public void setLevel(String level) {
				this.level = level;
		}

		@Override
		public void performOperation() {

		}

		@Override
		public String getPersonInfo() {
				return null;
		}
}