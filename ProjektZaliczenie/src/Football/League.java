package Football;

public class League extends DataBaseObject {
		private String leagueName;

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
