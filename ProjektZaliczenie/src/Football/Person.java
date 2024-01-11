package Football;

public abstract class Person extends DataBaseObject {
		private String fullName;
		private Short age;
		private int nationalID;

		@Override
		public String toString() {
				return "Person{" +
								"fullName='" + fullName + '\'' +
								", age=" + age +
								", nationalID=" + nationalID +
								'}';
		}

		public Person(int id, String name, Long date, String fullName, Short age, int nationalID) {
				super(id, name, date);
				this.fullName = fullName;
				this.age = age;
				this.nationalID = nationalID;
		}

		public String getFullName() {
				return fullName;
		}

		public void setFullName(String fullName) {
				this.fullName = fullName;
		}

		public Short getAge() {
				return age;
		}

		public void setAge(Short age) {
				this.age = age;
		}

		public int getNationalID() {
				return nationalID;
		}

		public void setNationalID(int nationalID) {
				this.nationalID = nationalID;
		}

		public abstract String getPersonInfo();

}
