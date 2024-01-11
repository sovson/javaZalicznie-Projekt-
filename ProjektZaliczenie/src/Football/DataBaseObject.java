package Football;

public abstract class DataBaseObject {
		private int id;
		private String name;
		private Long date;

		public DataBaseObject(int id, String name, Long date) {
				this.id = id;
				this.name = name;
				this.date = date;
		}

		public int getId() {
				return id;
		}

		public void setId(int id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public Long getDate() {
				return date;
		}

		public void setDate(Long date) {
				this.date = date;
		}
}
