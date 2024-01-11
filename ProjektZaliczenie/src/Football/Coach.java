package Football;

public class Coach extends Person {
		private Float experience;

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
}
