package org.example.football.model;

public class Coach extends Person {
		private Float experience;

		@Override
		public String toString() {
				return "Trener: " +
								"ID: " + getId() +
								", Imię: " + getName() +
								", Data urodzin (rok): " + getDate() +
								", Wiek: " + getAge() +
								", Numer krajowy: " + getNationalID() +
								", Doświadczenie (lata): " + experience;
		}

		public Coach(String name, Long date, Short age, int nationalID, Float experience) {
				super(name, date, age, nationalID);
				this.experience = experience;
		}

		public Float getExperience() {
				return experience;
		}

		public void setExperience(Float experience) {
				this.experience = experience;
		}

		@Override
		public void performOperation() {

		}

		@Override
		public String getPersonInfo() {
				return null;
		}
}
