package Football;

public class Goal extends DataBaseObject {
		private Player whoScored;

		public Goal(int id, String name, Long date, Player whoScored) {
				super(id, name, date);
				this.whoScored = whoScored;
		}

		public Player getWhoScored() {
				return whoScored;
		}

		public void setWhoScored(Player whoScored) {
				this.whoScored = whoScored;
		}
}
