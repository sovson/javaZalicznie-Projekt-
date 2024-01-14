package org.example.football.main;

import org.example.football.model.*;
import org.example.football.utils.Foot;
import org.example.football.utils.Position;

import java.util.*;


public class Main {
		private static final Scanner scanner = new Scanner(System.in);

		private static final List<DataBaseObject> objectsList = new ArrayList<>();

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

				int objectType = readIntInput();
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
						case 4:
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


						case 10:
								break;
						default:
								System.out.println("Nieprawidłowy typ obiektu. Powrót do menu głównego.");
				}
		}

		private static void addPlayer() {
				System.out.println("Dodawanie nowego gracza:");


				System.out.print("Imię: ");
				String name = scanner.next();

				System.out.print("Data urodzenia: ");
				Long date = readLongInput();

				System.out.print("Wiek: ");
				Short age = readShortInput();

				System.out.print("Numer krajowy: ");
				int nationalID = readIntInput();

				System.out.print("Numer na koszulce: ");
				int number = readIntInput();

				System.out.print("Wynagrodzenie: ");
				float salary = readShortFloat();

				System.out.print("Preferowana noga: ");
				Foot preferredFoot = selectPreferredFoot();

				System.out.print("Pozycja: ");
				Position playerPosition = selectPlayerPosition();

				Player newPlayer = new Player(name, date, age, nationalID, number, salary, preferredFoot, playerPosition);
				objectsList.add(newPlayer);
				System.out.println("Nowy gracz został dodany!" + newPlayer.getId());
		}


		private static void addCoach() {
				System.out.println("Dodawanie nowego trenera:");


				System.out.print("Imię: ");
				String name = scanner.next();

				System.out.print("Data urodzenia: ");
				Long date = readLongInput();

				System.out.print("Wiek: ");
				Short age = readShortInput();

				System.out.print("Numer krajowy: ");
				int nationalID = readIntInput();

				System.out.print("Doświadczenie: ");
				float experience = readShortFloat();

				Coach newCoach = new Coach(name, date, age, nationalID, experience);
				objectsList.add(newCoach);
				System.out.println("Nowy trener został dodany!");
		}

		private static void addReferee() {
				System.out.println("Dodawanie nowego sędziego:");

				int id = IdGenerator.generateId();

				System.out.print("Imię: ");
				String name = scanner.next();

				System.out.print("Data urodzenia: ");
				Long date = readLongInput();

				System.out.print("Wiek: ");
				Short age = readShortInput();

				System.out.print("Numer krajowy: ");
				int nationalID = readIntInput();

				System.out.print("Poziom sędziego (doświadczenie w latach): ");
				String level = scanner.next();

				Referee newReferee = new Referee(name, date, age, nationalID, level);
				objectsList.add(newReferee);
				System.out.println("Nowy sędzia został dodany!");
		}

		private static void addLeague() {
				System.out.println("Dodawanie nowej ligi:");

				int id = IdGenerator.generateId();

				System.out.print("Nazwa kraju pochodzenia ligii: ");
				String name = scanner.next();

				System.out.print("Data założenia ligi: ");
				Long date = readLongInput();

				scanner.nextLine();
				System.out.print("Nazwa ligi: ");
				String leagueName = scanner.nextLine();

				League newLeague = new League(id, name, date, leagueName);
				objectsList.add(newLeague);
				System.out.println("Nowa liga została dodana!");
		}

		private static void addGoal() {
				System.out.println("Dodawanie nowego gola:");

				int id = IdGenerator.generateId();

				System.out.print("Data strzelenia gola: ");
				Long date = readLongInput();

				System.out.print("ID Strzelca: ");
				int scorerId = readIntInput();
				Player whoScored = findPlayerById(scorerId);

				Goal newGoal = new Goal(id, "", date, whoScored);
				objectsList.add(newGoal);

				System.out.println("Nowy gol został dodany!");
		}

		private static void addTeam() {
				System.out.println("Dodawanie nowej drużyny:");

				int id = IdGenerator.generateId();

				System.out.print("Nazwa kraju pochodzenia drużyny: ");
				String name = scanner.next();

				System.out.print("Data założenia drużyny: ");
				Long date = readLongInput();

				scanner.nextLine();
				System.out.print("Nazwa drużyny: ");
				String teamName = scanner.nextLine();

				System.out.print("Punkty w lidze: ");
				int pointsLeague = readIntInput();

				System.out.print("ID Trenera: ");
				int coachId = readIntInput();
				Coach coach = findCoachById(coachId);

				Team newTeam = new Team(id, name, date, teamName, pointsLeague, coach);
				objectsList.add(newTeam);
				System.out.println("Nowa drużyna została dodana!");
		}

		private static void addMatch() {
				System.out.println("Dodawanie nowego meczu:");

				System.out.print("ID: ");
				int id = IdGenerator.generateId();

				scanner.nextLine();
				System.out.print("Nazwa meczu: ");
				String name = scanner.nextLine();

				System.out.print("Data meczu: ");
				Long date = readLongInput();

				System.out.print("Stadion: ");
				String stadium = scanner.next();

				System.out.print("ID Drużyny gospodarzy: ");
				int homeTeamId = readIntInput();
				Team homeTeam = findTeamById(homeTeamId);

				System.out.print("ID Drużyny gości: ");
				int awayTeamId = readIntInput();
				Team awayTeam = findTeamById(awayTeamId);

				System.out.print("ID Sędziego: ");
				int refereeId = readIntInput();
				Referee referee = findRefereeById(refereeId);

				List<Goal> goals = new ArrayList<>();
				System.out.print("Czy chcesz dodać gole do meczu? (T/N): ");
				char addGoalsChoice = scanner.next().charAt(0);

				if (addGoalsChoice == 'T' || addGoalsChoice == 't') {
						while (true) {
								System.out.print("ID Gola do dodania: ");
								int goalId = readIntInput();
								Goal goal = findGoalById(goalId);

								if (goal != null) {
										goals.add(goal);
										System.out.print("Czy chcesz dodać kolejnego gola? (T/N): ");
										char addAnotherGoal = scanner.next().charAt(0);
										if (addAnotherGoal != 'T' && addAnotherGoal != 't') {
												break;
										}
								} else {
										System.out.println("Nie znaleziono gola o podanym ID.");
								}
						}
				}

				Match newMatch = new Match(id, name, date, stadium, homeTeam, awayTeam, goals, referee);
				objectsList.add(newMatch);

				System.out.println("Nowy mecz został dodany!");

		}

		private static void deleteObject() {
				System.out.println("Wybierz typ obiektu do usunięcia:");
				System.out.println("1. Piłkarz");
				System.out.println("2. Trener");
				System.out.println("3. Sędzia");
				System.out.println("4. Mecz");
				System.out.println("5. Drużyna");
				System.out.println("6. Liga");
				System.out.println("7. Gol");
				System.out.println("10. Cofnij się do menu głównego");

				int objectType = readIntInput();
				switch (objectType) {
						case 1:
								removeObject(1);
								break;
						case 2:
								removeObject(2);
								break;
						case 3:
								removeObject(3);
								break;
						case 4:
								removeObject(4);
								break;
						case 5:
								removeObject(5);
								break;
						case 6:
								removeObject(6);
								break;
						case 7:
								removeObject(7);
								break;
						case 10:
								break;
						default:
								System.out.println("Nieprawidłowy typ obiektu. Powrót do menu głównego.");
				}
		}


		private static void removeObjectById(int objectId, Class<?> objectType) {
				for (Iterator<DataBaseObject> iterator = objectsList.iterator(); iterator.hasNext(); ) {
						DataBaseObject obj = iterator.next();
						if (obj.getId() == objectId && obj.getClass().equals(objectType)) {
								iterator.remove();
								System.out.println("Obiekt został usunięty.");
								return;
						}
				}
				System.out.println("Obiekt o podanym ID i typie nie został znaleziony.");
		}

		private static void removeObject(int objectType) {
				System.out.print("Podaj ID obiektu do usunięcia: ");
				int objectId = readIntInput();

				switch (objectType) {
						case 1:
								removeObjectById(objectId, Player.class);
								break;
						case 2:
								removeObjectById(objectId, Coach.class);
								break;
						case 3:
								removeObjectById(objectId, Referee.class);
								break;
						case 4:
								removeObjectById(objectId, Match.class);
								break;
						case 5:
								removeObjectById(objectId, Team.class);
								break;
						case 6:
								removeObjectById(objectId, League.class);
								break;
						case 7:
								removeObjectById(objectId, Goal.class);
								break;
						case 10:
								break;
						default:
								System.out.println("Nieprawidłowy typ obiektu. Powrót do menu głównego.");
				}
		}


		private static void displayAllObjects() {
				System.out.println("Wyświetlanie wszystkich obiektów: ");


				System.out.println("Piłkarze: ");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Player) {
								System.out.println(obj);
						}
				}

				System.out.println("Trenerzy: ");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Coach) {
								System.out.println(obj);
						}
				}
				System.out.println("Sędzia: ");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Referee) {
								System.out.println(obj);
						}
				}
				System.out.println("Ligii: ");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof League) {
								System.out.println(obj);
						}
				}
				System.out.println("Gole: ");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Goal) {
								System.out.println(obj);
						}
				}
				System.out.println("Drużyna: ");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Team) {
								System.out.println(obj);
						}
				}

				System.out.println("Mecz: ");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Match) {
								System.out.println(obj);
						}
				}

		}

		private static void displayObjectsByType() {
				System.out.println("Wybierz typ obiektu do wyświetlenia:");
				System.out.println("1. Piłkarze");
				System.out.println("2. Trenerzy");
				System.out.println("3. Sędziowie");
				System.out.println("4. Mecze");
				System.out.println("5. Drużyny");
				System.out.println("6. Ligi");
				System.out.println("7. Gole");
				System.out.println("10. Cofnij się do menu głównego");

				int objectType = readIntInput();
				switch (objectType) {
						case 1:
								displayPlayers();
								break;
						case 2:
								displayCoaches();
								break;
						case 3:
								displayReferees();
								break;
						case 4:
								displayMatches();
								break;
						case 5:
								displayTeams();
								break;
						case 6:
								displayLeagues();
								break;
						case 7:
								displayGoals();
								break;
						case 10:
								break;
						default:
								System.out.println("Nieprawidłowy typ obiektu. Powrót do menu głównego.");
				}
		}

		private static void displayPlayers() {
				System.out.println("Lista piłkarzy:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Player) {
								System.out.println(obj);
						}
				}
		}

		private static void displayCoaches() {
				System.out.println("Lista trenerów:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Coach) {
								System.out.println(obj);
						}
				}
		}

		private static void displayReferees() {
				System.out.println("Lista sędziów:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Referee) {
								System.out.println(obj);
						}
				}
		}

		private static void displayMatches() {
				System.out.println("Lista meczy:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Match) {
								System.out.println(obj);
						}
				}
		}

		private static void displayTeams() {
				System.out.println("Lista drużyn:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Team) {
								System.out.println(obj);
						}
				}
		}

		private static void displayLeagues() {
				System.out.println("Lista lig:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof League) {
								System.out.println(obj);
						}
				}
		}

		private static void displayGoals() {
				System.out.println("Lista goli:");
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Goal) {
								System.out.println(obj);
						}
				}
		}

		private static void displayObjectsByName() {
				System.out.println("Podaj ciąg znaków do wyszukania:");
				String searchString = scanner.next();

				System.out.println("Wyniki wyszukiwania:");

				for (DataBaseObject obj : objectsList) {
						if (obj.getName().contains(searchString)) {
								System.out.println(obj);
						}
				}
		}


		private static Player findPlayerById(int playerId) {
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Player && obj.getId() == playerId) {
								return (Player) obj;
						}
				}
				System.out.println("Gracz o podanym ID nie został znaleziony.");
				return null;
		}

		private static Team findTeamById(int teamId) {
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Team && obj.getId() == teamId) {
								return (Team) obj;
						}
				}
				System.out.println("Drużyna o podanym ID nie została znaleziona.");
				return null;
		}

		private static Coach findCoachById(int coachId) {
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Coach && obj.getId() == coachId) {
								return (Coach) obj;
						}
				}
				System.out.println("Trener o podanym ID nie został znaleziony.");
				return null;
		}

		private static Referee findRefereeById(int id) {
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Referee && obj.getId() == id) {
								return (Referee) obj;
						}
				}
				System.out.println("Sędzia o podanym ID nie został znaleziony.");
				return null;
		}

		private static Goal findGoalById(int goalId) {
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof Goal && obj.getId() == goalId) {
								return (Goal) obj;
						}
				}
				System.out.println("Nie znaleziono gola o podanym ID.");
				return null;
		}

		private static int readIntInput() {
				while (true) {
						try {
								return scanner.nextInt();
						} catch (InputMismatchException e) {
								System.out.println("Błąd! Wprowadź poprawną liczbę całkowitą (typu int).");
								scanner.next();
						}
				}
		}

		private static long readLongInput() {
				while (true) {
						try {
								return scanner.nextLong();
						} catch (InputMismatchException e) {
								System.out.println("Błąd! Wprowadź poprawną liczbę całkowitą (typu long).");
								scanner.next();
						}
				}
		}

		private static short readShortInput() {
				while (true) {
						try {
								return scanner.nextShort();
						} catch (InputMismatchException e) {
								System.out.println("Błąd! Wprowadź poprawną liczbę całkowitą (typu short).");
								scanner.next();
						}
				}
		}

		private static float readShortFloat() {
				while (true) {
						try {
								return scanner.nextFloat();
						} catch (InputMismatchException e) {
								System.out.println("Błąd! Wprowadź poprawną liczbę zmiennoprzecinkową (typu float).");
								scanner.next();
						}
				}
		}

		private static Foot selectPreferredFoot() {
				System.out.println(" ");
				System.out.println("1. LEFT");
				System.out.println("2. RIGHT");
				System.out.println("3. BOTH");

				int choice = readIntInput();
				switch (choice) {
						case 1:
								return Foot.LEFT;
						case 2:
								return Foot.RIGHT;
						case 3:
								return Foot.BOTH;
						default:
								System.out.println("Nieprawidłowy wybór, domyślnie ustawiono LEFT.");
								return Foot.LEFT;
				}
		}

		private static Position selectPlayerPosition() {
				System.out.println(" ");
				System.out.println("1. GOALKEEPER");
				System.out.println("2. DEFENDER");
				System.out.println("3. MIDFIELDER");
				System.out.println("4. STRIKER");

				int choice = readIntInput();
				switch (choice) {
						case 1:
								return Position.GOALKEEPER;
						case 2:
								return Position.DEFENDER;
						case 3:
								return Position.MIDFIELDER;
						case 4:
								return Position.STRIKER;
						default:
								System.out.println("Nieprawidłowy wybór, domyślnie ustawiono GOALKEEPER.");
								return Position.GOALKEEPER;
				}
		}

		public static void main(String[] args) {
				int choice;

				do {
						System.out.println("1. Dodaj nowy obiekt");
						System.out.println("2. Usuń obiekt");
						System.out.println("3. Wyświetlanie wszystkich zapamiętanych obiektów");
						System.out.println("4. Wyświetlanie obiektów według typu");
						System.out.println("5. Wyświetlanie obiektów, których nazwa zawiera podany ciąg znaków");
						System.out.println("6. Wykonanie operacji zawartej w interfejsie na wszystkich obiektach klas implementujących ten interfejs.");
						System.out.println("10. Wyjdź");
						System.out.print("Wybierz opcję: ");
						choice = readIntInput();

						switch (choice) {
								case 1:
										addNewObject();
										break;
								case 2:
										deleteObject();
										break;
								case 3:
										displayAllObjects();
										break;
								case 4:
										displayObjectsByType();
										break;
								case 5:
										displayObjectsByName();
										break;
								case 6:
										break;
								case 10:
										System.out.println("Koniec programu.");
										break;
								default:
										System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
						}
				} while (choice != 10);
		}


}
