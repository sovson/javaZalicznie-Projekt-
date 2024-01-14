package org.example.football.model;

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

		public Person(String name, Long date, Short age, int nationalID) {
				super(IdGenerator.generateId(), name, date);

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