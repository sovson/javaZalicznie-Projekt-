package Football;

public class Goal extends DataBaseObject implements PerformOperation {
		@Override
		public void performOperation() {

		}

		private Player whoScored;

		@Override
		public String toString() {
				return "Goal{" +
								"whoScored=" + whoScored +
								'}';
		}

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
