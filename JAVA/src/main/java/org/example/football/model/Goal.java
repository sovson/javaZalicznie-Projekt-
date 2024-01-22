package org.example.football.model;

import org.example.football.utils.PerformOperation;

public class Goal extends DataBaseObject {


		private Player whoScored;

		@Override
		public String toString() {
				return "Gol: " +
								"ID: " + getId() +
								", Minuta zdobycia gola: " + getDate() +
								", Kto zdobył bramkę: " + whoScored.getName();
		}

		public Goal(int id, String name, String date, Player whoScored) {
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