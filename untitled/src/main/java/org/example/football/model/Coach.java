package org.example.football.model;

public class Coach extends Person {
		private Float experience;

		@Override
		public String toString() {
				return "Coach{" +
								"experience=" + experience +
								'}';
		}

		public Coach(int id, String name, Long date, String fullName, Short age, int nationalID, Float experience) {
				super(id, name, date, fullName, age, nationalID);
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
