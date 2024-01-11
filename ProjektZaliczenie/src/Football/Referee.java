package Football;

public class Referee extends Person {
		private String level;

		public Referee(int id, String name, Long date, String fullName, Short age, int nationalID, String level) {
				super(id, name, date, fullName, age, nationalID);
				this.level = level;
		}

		public String getLevel() {
				return level;
		}

		public void setLevel(String level) {
				this.level = level;
		}
}
