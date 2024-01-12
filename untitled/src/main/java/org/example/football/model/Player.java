package org.example.football.model;

import org.example.football.utils.Foot;
import org.example.football.utils.Position;

public class Player extends Person {
		private int number;
		private Float salary;
		private Foot preferredFoot;
		private Position playerPosition;

		@Override
		public String toString() {
				return "Player{" +
								"number=" + number +
								", salary=" + salary +
								", preferredFoot=" + preferredFoot +
								", playerPosition=" + playerPosition +
								'}';
		}

		public Player(int id, String name, Long date, String fullName, Short age, int nationalID, int number, Float salary, Foot preferredFoot, Position playerPosition) {
				super(id, name, date, fullName, age, nationalID);
				this.number = number;
				this.salary = salary;
				this.preferredFoot = preferredFoot;
				this.playerPosition = playerPosition;
		}

		public int getNumber() {
				return number;
		}

		public void setNumber(int number) {
				this.number = number;
		}

		public Float getSalary() {
				return salary;
		}

		public void setSalary(Float salary) {
				this.salary = salary;
		}

		public Foot getPreferredFoot() {
				return preferredFoot;
		}

		public void setPreferredFoot(Foot preferredFoot) {
				this.preferredFoot = preferredFoot;
		}

		public Position getPlayerPosition() {
				return playerPosition;
		}

		public void setPlayerPosition(Position playerPosition) {
				this.playerPosition = playerPosition;
		}

		@Override
		public void performOperation() {

		}

		@Override
		public String getPersonInfo() {
				return null;
		}
}
