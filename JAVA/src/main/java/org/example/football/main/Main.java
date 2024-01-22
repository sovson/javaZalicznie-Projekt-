package org.example.football.main;

import org.example.football.model.*;
import org.example.football.utils.Foot;
import org.example.football.utils.PerformOperation;
import org.example.football.utils.Position;

import java.util.*;


public class Main {
		private static final Scanner scanner = new Scanner(System.in);

		private static final List<DataBaseObject> objectsList = new ArrayList<>();

		private static void testData() {
				objectsList.add(new Player("Robert Lewandowski", "15.01.2024", (short) 33, 10, 9, 5000000F, Foot.RIGHT, Position.STRIKER));
				objectsList.add(new Player("Lionel Messi", "15.01.2024", (short) 35, 10, 10, 7000000F, Foot.LEFT, Position.STRIKER));
				objectsList.add(new Player("Cristiano Ronaldo", "15.01.2024", (short) 36, 11, 7, 8000000F, Foot.RIGHT, Position.STRIKER));
				objectsList.add(new Player("Neymar Jr.", "15.01.2024", (short) 29, 12, 11, 6000000F, Foot.LEFT, Position.STRIKER));
				objectsList.add(new Player("Mohamed Salah", "15.01.2024", (short) 29, 13, 10, 5500000F, Foot.LEFT, Position.STRIKER));
				objectsList.add(new Player("Kevin De Bruyne", "15.01.2024", (short) 30, 14, 17, 7000000F, Foot.RIGHT, Position.MIDFIELDER));
				objectsList.add(new Player("Sadio Mané", "15.01.2024", (short) 30, 15, 10, 5500000F, Foot.LEFT, Position.STRIKER));
				objectsList.add(new Player("Kylian Mbappé", "15.01.2024", (short) 23, 16, 7, 7500000F, Foot.RIGHT, Position.STRIKER));
				objectsList.add(new Player("Joshua Kimmich", "15.01.2024", (short) 27, 17, 6, 6000000F, Foot.RIGHT, Position.MIDFIELDER));
				objectsList.add(new Player("Virgil van Dijk", "15.01.2024", (short) 30, 18, 4, 7000000F, Foot.RIGHT, Position.DEFENDER));

				objectsList.add(new Coach("Jurgen Klopp", "15.01.2024", (short) 55, 101, 20F));
				objectsList.add(new Coach("Pep Guardiola", "15.01.2024", (short) 51, 102, 22F));
				objectsList.add(new Coach("Zinedine Zidane", "15.01.2024", (short) 49, 103, 18F));
				objectsList.add(new Coach("Carlo Ancelotti", "15.01.2024", (short) 62, 104, 25F));
				objectsList.add(new Coach("Diego Simeone", "15.01.2024", (short) 51, 105, 19F));

				objectsList.add(new Referee("Howard Webb", "15.01.2024", (short) 51, 201, "WorldClass"));
				objectsList.add(new Referee("Pierluigi Collina", "15.01.2024", (short) 62, 202, "Legendary"));
				objectsList.add(new Referee("Felix Brych", "15.01.2024", (short) 46, 203, "Experienced"));
				objectsList.add(new Referee("Björn Kuipers", "15.01.2024", (short) 48, 204, "Veteran"));
				objectsList.add(new Referee("Cüneyt Çakır", "15.01.2024", (short) 45, 205, "Respected"));

				Player scorer1 = findPlayerById(1);
				Player scorer2 = findPlayerById(2);
				Player scorer3 = findPlayerById(3);
				Player scorer4 = findPlayerById(4);
				Player scorer5 = findPlayerById(5);
				objectsList.add(new Goal(IdGenerator.generateId(), "", "75", scorer1));
				objectsList.add(new Goal(IdGenerator.generateId(), "", "34", scorer2));
				objectsList.add(new Goal(IdGenerator.generateId(), "", "55", scorer3));
				objectsList.add(new Goal(IdGenerator.generateId(), "", "20", scorer4));
				objectsList.add(new Goal(IdGenerator.generateId(), "", "87", scorer5));
		}


		private static void addNewObject() {
				System.out.println("Wybierz typ obiektu do dodania:");
				listObj();

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
								addGoal();
								break;
						case 5:
								addTeam();
								break;
						case 6:
								addLeague();
								break;
						case 7:
								addMatch();
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

				System.out.print("Data urodzenia (DD.MM.YYYY): ");
				String date = scanner.next();

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

				System.out.print("Data urodzenia (DD.MM.YYYY): ");
				String date = scanner.next();

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

				System.out.print("Data urodzenia (DD.MM.YYYY): ");
				String date = scanner.next();

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

				System.out.print("Data założenia ligi (DD.MM.YYYY): ");
				String date = scanner.next();

				scanner.nextLine();
				System.out.print("Nazwa ligi: ");
				String leagueName = scanner.nextLine();

				League newLeague = new League(id, name, date, leagueName);
				objectsList.add(newLeague);

				System.out.println("Dodawanie drużyn do ligi:");
				boolean addTeam = true;

				while (addTeam) {
						System.out.print("ID drużyny do dodania do ligi: ");
						int teamId = readIntInput();
						Team team = findTeamById(teamId);

						if (team != null) {
								newLeague.addTeam(team);
								System.out.println("Drużyna dodana do ligi!");
						} else {
								System.out.println("Drużyna o podanym ID nie została znaleziona.");
						}

						System.out.print("Czy chcesz dodać kolejną drużynę do ligi? (Tak/Nie): ");
						String addAnotherTeam = scanner.next().toLowerCase();

						addTeam = addAnotherTeam.equals("tak");
				}

				System.out.println("Nowa liga została dodana!");
		}


		private static void addGoal() {
				System.out.println("Dodawanie nowego gola:");

				int id = IdGenerator.generateId();

				System.out.print("Minuta strzelenia gola w meczu: ");
				String date = scanner.next();

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

				System.out.print("Data założenia drużyny (DD.MM.YYYY): ");
				String date = scanner.next();

				scanner.nextLine();
				System.out.print("Nazwa drużyny: ");
				String teamName = scanner.nextLine();

				System.out.print("Punkty w lidze: ");
				int pointsLeague = readIntInput();

				boolean validCoach = false;
				Coach coach = null;

				int attempts = 0;
				int maxAttempts = 3;

				while (!validCoach && attempts < maxAttempts) {
						System.out.print("ID Trenera: ");
						int coachId = readIntInput();
						coach = findCoachById(coachId);

						if (coach != null && coach.getTeam() == null) {
								validCoach = true;
						} else if (coach == null) {
								System.out.println("Trener o podanym ID nie został znaleziony.");
						} else {
								System.out.println("Trener już prowadzi inną drużynę. Podaj innego trenera.");
						}

						attempts++;

						if (attempts == maxAttempts) {
								System.out.println("Osiągnięto maksymalną liczbę prób. Dodawanie drużyny przerwane.");
								return;
						}
				}

				Team newTeam = new Team(id, name, date, teamName, pointsLeague, coach);
				objectsList.add(newTeam);

				boolean addAnotherPlayer = true;

				while (addAnotherPlayer) {
						System.out.print("ID Piłkarza do dodania do drużyny: ");
						int playerId = readIntInput();
						Player player = findPlayerById(playerId);

						if (player != null) {
								newTeam.addPlayer(player);
						} else {
						}

						System.out.print("Czy chcesz dodać kolejnego zawodnika? (tak/nie): ");
						String userInput = scanner.next().toLowerCase();

						if (!userInput.equals("tak")) {
								addAnotherPlayer = false;
						}
				}

				coach.setTeam(newTeam);

				System.out.println("Nowa drużyna została dodana!");
		}

		private static void addMatch() {
				System.out.println("Dodawanie nowego meczu:");
				int id = IdGenerator.generateId();

				scanner.nextLine();
				System.out.print("Nazwa meczu: ");
				String name = scanner.nextLine();

				System.out.print("Data meczu (DD.MM.YYYY): ");
				String date = scanner.next();

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
								if (obj instanceof Coach) {
										((Coach) obj).removeTeam();
								} else if (obj instanceof Team) {
										((Team) obj).removeCoach();
								}

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
								removeObjectById(objectId, Goal.class);
								break;
						case 5:
								removeObjectById(objectId, Team.class);
								break;
						case 6:
								removeObjectById(objectId, League.class);
								break;
						case 7:
								removeObjectById(objectId, Match.class);
								break;
						case 10:
								break;
						default:
								System.out.println("Nieprawidłowy typ obiektu. Powrót do menu głównego.");
				}
		}

		private static void displayAllObjects() {
				System.out.println("Wyświetlanie wszystkich obiektów: ");

				Class<?>[] objectTypes = {Player.class, Coach.class, Referee.class, League.class, Goal.class, Team.class, Match.class};

				for (Class<?> objectType : objectTypes) {
						String typeName = objectType.getSimpleName();

						System.out.println(typeName + ": ");
						for (DataBaseObject obj : objectsList) {
								if (objectType.isInstance(obj)) {
										System.out.println(obj);
								}
						}
				}
		}

		private static void displayObjectsByType() {
				System.out.println("Wybierz typ obiektu do wyświetlenia:");
				listObj();
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

		private static void interfaceMenu() {
				System.out.println("Wybierz interfejs do wykonania operacji:");
				System.out.println("1. Zwieksz wiek");
				System.out.println("2. Zmniejsz wiek");

				int option = readIntInput();
				switch (option) {
						case 1:
								increaseAgeForAll();
								break;
						case 2:
								decreaseAgeForAll();
								break;
						default:
								System.out.println("Nieprawidłowy wybór. Powrót do menu głównego.");
				}
		}

		private static void increaseAgeForAll() {
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof PerformOperation) {
								((PerformOperation) obj).ageup();
						}
				}
				System.out.println("Zwiekszono wiek dla wszystkich obiektów obsługujących ten interfejs.");
		}

		private static void decreaseAgeForAll() {
				for (DataBaseObject obj : objectsList) {
						if (obj instanceof PerformOperation) {
								((PerformOperation) obj).agedown();
						}
				}
				System.out.println("Zmniejszono wiek dla wszystkich obiektów obsługujących ten interfejs.");
		}

		private static void listObj() {
				System.out.println("1. Piłkarze");
				System.out.println("2. Trenerzy");
				System.out.println("3. Sędziowie");
				System.out.println("4. Gole");
				System.out.println("5. Drużyny");
				System.out.println("6. Ligi");
				System.out.println("7. Mecze");
				System.out.println("10. Cofnij się do menu głównego");
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
						System.out.println("7. Dodaj przykładowe dane");
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
										interfaceMenu();
										break;
								case 7:
										testData();
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
