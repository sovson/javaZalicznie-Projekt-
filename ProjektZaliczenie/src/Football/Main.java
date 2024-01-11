package Football;

import java.util.List;
import java.util.ArrayList;

public class Main {
		public static void main(String[] args) {
				List<DataBaseObject> objectsList = new ArrayList<>();
				// Dodajemy obiekty różnych klas do listy
				Coach coach = new Coach(1, "Coach X", System.currentTimeMillis(), "Full Name", (short) 40, 123456, 10.5f);
				Team team = new Team(2, "Team A", System.currentTimeMillis(), "Team Name", 20, coach);
				Player player = new Player(3, "John Doe", System.currentTimeMillis(), "Full Name", (short) 25, 789012, 7, 50000f, Foot.RIGHT, Position.STRIKER);
				Referee referee = new Referee(4, "Referee Y", System.currentTimeMillis(), "Full Name", (short) 35, 345678, "Level A");
				League league = new League(5, "League X", System.currentTimeMillis(), "Premier League");
				Goal goal = new Goal(6, "Goal 1", System.currentTimeMillis(), player);
				Match match = new Match(7, "Match 1", System.currentTimeMillis(), "Stadium A", team, team, List.of(goal), referee);

				// Dodajemy obiekty do wspólnej listy
				objectsList.add(coach);
				objectsList.add(team);
				objectsList.add(player);
				objectsList.add(referee);
				objectsList.add(league);
				objectsList.add(goal);
				objectsList.add(match);

				// Przechodzimy przez listę i wywołujemy operację na każdym obiekcie
				for (DataBaseObject object : objectsList) {
						object.performOperation();
				}
				for (DataBaseObject object : objectsList) {
						object.performOperation();
						System.out.println(object.toString()); // Wyświetlamy informacje o obiekcie
						System.out.println("--------------------------------------");
				}
		}
}