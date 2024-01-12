package org.example.football.model;

import org.example.football.utils.PerformOperation;

public class League extends DataBaseObject implements PerformOperation {
		@Override
		public void performOperation() {

		}

		private String leagueName;

		@Override
		public String toString() {
				return "Liga: " + ", ID: " + getId() + ", Nazwa kraju pochodzenia ligii: " + getName() + ", Data założenia ligii: " + getDate() +
								", Nazwa ligii ='" + leagueName + '\'';
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