package org.example.football.model;

import org.example.football.utils.Foot;
import org.example.football.utils.PerformOperation;
import org.example.football.utils.Position;

public class Player extends Person implements PerformOperation {
		private int number;
		private Float salary;
		private Foot preferredFoot;
		private Position playerPosition;

		@Override
		public String toString() {
				return "Piłkarz: " +
								"ID: " + getId() +
								", Imię: '" + getName() + '\'' +
								", Data urodzin: " + getDate() +
								", Wiek: " + getAge() +
								", Numer krajowy: " + getNationalID() +
								", Numer na koszulce: " + number +
								", Wynagrodzenie: " + salary +
								", Preferowana noga: " + preferredFoot +
								", Pozycja piłkarza: " + playerPosition;
		}

		public Player(String name, String date, Short age, int nationalID, int number, Float salary, Foot preferredFoot, Position playerPosition) {
				super(name, date, age, nationalID);
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
		public String getPersonInfo() {
				return null;
		}

		@Override
		public void ageup() {
				setAge((short) (getAge() + 1));
		}

		@Override
		public void agedown() {
				setAge((short) (getAge() - 1));
		}
}
