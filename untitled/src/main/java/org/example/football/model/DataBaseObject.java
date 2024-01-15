package org.example.football.model;

import org.example.football.utils.PerformOperation;

public abstract class DataBaseObject {
		private int id;
		private String name;
		private Long date;
		private static int numberOfObjects = 0;

		public static void incrementNumberOfObjects() {
				numberOfObjects++;
		}

		public static int getNumberOfObjects() {
				return numberOfObjects;
		}

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