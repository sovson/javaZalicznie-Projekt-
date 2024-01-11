package Football;

public class League extends DataBaseObject implements PerformOperation {
		@Override
		public void performOperation() {

		}

		private String leagueName;

		@Override
		public String toString() {
				return "League{" +
								"leagueName='" + leagueName + '\'' +
								'}';
		}

		public League(int id, String name, Long date, String leagueName) {
				super(id, name, date);
				this.leagueName = leagueName;
		}

		public String getLeagueName() {
				return leagueName;
		}

		public void setLeagueName(String leagueName) {
				this.leagueName = leagueName;
		}
}
