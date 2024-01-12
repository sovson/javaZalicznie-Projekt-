package org.example.football.main;

import java.util.Scanner;

import org.example.football.model.*;
import org.example.football.utils.Foot;
import org.example.football.utils.Position;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;


public class Main {
		private static Scanner scanner = new Scanner(System.in);

		private static List<DataBaseObject> objectsList = new ArrayList<>();

		private static void addNewObject() {
				System.out.println("Wybierz typ obiektu do dodania:");
				System.out.println("1. Piłkarz");
				System.out.println("2. Trener");
				System.out.println("3. Sędzia");
				System.out.println("4. Mecz");
				System.out.println("5. Drużyna");
				System.out.println("6. Liga");
				System.out.println("7. Gol");
				System.out.println("10. Cofnij się do menu głównego");


				int objectType = scanner.nextInt();
				switch (objectType) {
						case 1:
								addPlayer();
								break;
						case 2:
								addCoach();
								break;
						case 3:
								addReferee();
								break;
						/*case 4:
								addMatch();
								break;
						case 5:
								addTeam();
								break;
						case 6:
								addLeague();
								break;
						case 7:
								addGoal();
								break;

						 */
						case 10:
								break;
						default:
								System.out.println("Nieprawidłowy typ obiektu. Powrót do menu głównego.");
				}
		}

		private static void addPlayer() {
				System.out.println("Dodawanie nowego gracza:");

				System.out.print("ID: ");
				int id = scanner.nextInt();

				System.out.print("Imię: ");
				String name = scanner.next();

				System.out.print("Data urodzenia: ");
				Long date = scanner.nextLong();

				System.out.print("Wiek: ");
				Short age = scanner.nextShort();

				System.out.print("Numer krajowy: ");
				int nationalID = scanner.nextInt();

				System.out.print("Numer gracza: ");
				int number = scanner.nextInt();

				System.out.print("Wynagrodzenie: ");
				float salary = scanner.nextFloat();

				System.out.print("Preferowana noga (LEFT, RIGHT, BOTH): ");
				Foot preferredFoot = Foot.valueOf(scanner.next().toUpperCase());

				System.out.print("Pozycja (GOALKEEPER, DEFENDER, MIDFIELDER, STRIKER): ");
				Position playerPosition = Position.valueOf(scanner.next().toUpperCase());

				// Utwórz obiekt Player i dodaj do listy obiektów
				Player newPlayer = new Player(id, name, date, age, nationalID, number, salary, preferredFoot, playerPosition);
				objectsList.add(newPlayer);
				System.out.println("Nowy gracz został dodany!");
		}

		private static void addCoach() {
				System.out.println("Dodawanie nowego trenera:");

				// Pobierz dane od użytkownika
				System.out.print("ID: ");
				int id = scanner.nextInt();

				System.out.print("Imię: ");
				String name = scanner.next();

				System.out.print("Data urodzenia: ");
				Long date = scanner.nextLong();

				System.out.print("Wiek: ");
				Short age = scanner.nextShort();

				System.out.print("Numer krajowy: ");
				int nationalID = scanner.nextInt();

				System.out.print("Doświadczenie: ");
				float experience = scanner.nextFloat();

				// Utwórz obiekt Coach i dodaj do listy obiektów
				Coach newCoach = new Coach(id, name, date, age, nationalID, experience);
				// Dodaj newCoach do odpowiedniej listy obiektów, np. coachesList.add(newCoach);
				objectsList.add(newCoach);
				System.out.println("Nowy trener został dodany!");
		}

		private static void addReferee() {
				System.out.println("Dodawanie nowego sędziego:");

				// Pobierz dane od użytkownika
				System.out.print("ID: ");
				int id = scanner.nextInt();

				System.out.print("Imię: ");
				String name = scanner.next();

				System.out.print("Data urodzenia: ");
				Long date = scanner.nextLong();

				System.out.print("Wiek: ");
				Short age = scanner.nextShort();

				System.out.print("Numer krajowy: ");
				int nationalID = scanner.nextInt();

				System.out.print("Poziom sędziego (doświadczenie w latach): ");
				String level = scanner.next();

				// Utwórz obiekt Referee i dodaj do listy obiektów
				Referee newReferee = new Referee(id, name, date, age, nationalID, level);
				objectsList.add(newReferee);
				System.out.println("Nowy sędzia został dodany!");
		}

		private static void displayAllObjects() {
				System.out.println("Wyświetlanie wszystkich obiektów:");

				System.out.println("Gracze:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Player) {
								System.out.println(obj);
						}
				}

				System.out.println("Trenerzy:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Coach) {
								System.out.println(obj);
						}
				}
				System.out.println("Sędzia:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Referee) {
								System.out.println(obj);
						}
				}

		}

		public static void main(String[] args) {
				int choice;

				do {
						System.out.println("1. Dodaj nowy obiekt");
						System.out.println("3. Wyświetlanie wszystkich zapamiętanych obiektów");
						System.out.println("2. Wyjdź");
						System.out.print("Wybierz opcję: ");
						choice = scanner.nextInt();

						switch (choice) {
								case 1:
										addNewObject();
										break;
								case 3:
										displayAllObjects();
										break;
								case 2:
										System.out.println("Koniec programu.");
										break;
								default:
										System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
						}
				} while (choice != 2);
		}


}
