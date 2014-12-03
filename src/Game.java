public class Game {
	public void start() throws java.io.IOException {
		// Send how many of each bird-card that should be used
		// Should be totally 40 cards here i.e 
		// (1 bird, 2 birds, 3 birds, 4 birds, 5 birds, 6 birds)
		CardHandler ch = new CardHandler(12, 10, 8, 4, 4, 2); 
		Console console = new Console();

		// "scarecrow" is to see how many scarecrows picked up
		// "turn" is to handle which player's turn it is
		int scarecrow = 0, turn = 0;
		Card card;
		String input;

		console.print("Welcome to Scaredy Cat game!😺\n");

		Player p1 = new Player(console.getName(), console.getAge());
		Player p2 = new Player(console.getName(), console.getAge());
		// Check if player2 is younger than player1, if true,
		// let player2 start the game
		if (p2.getAge() < p1.getAge()) {
			turn = 1;
		}

		ch.shuffleCards();
		while (scarecrow < 6) {
			do {
				if (turn % 2 == 0) {
					console.print("\n" + p1.getName()
							+ ", press enter to pick a card: ");
				} else {
					console.print("\n" + p2.getName()
							+ ", press enter to pick a card: ");
				}

				input = console.getInput();
				if (input == "Exit") {
					System.exit(0);
				} else if (input == "Restart") {
					console.print("\n\n\n\n\n\n\n\n\n");
					start();
				}
			} while (input != "Next");

			card = ch.pickCard();
			// Scarecrow-card
			if (card == Card.SCARECROW)
			{
				scarecrow++;
				console.print("         _\n       _/_\\_\n      __\\\"/__\n     \"--(_)--\"\n        "
						+ "/_\\\n       //|\\\\\n      \"` | `\"\n       __|__");
				console.print("\nScarecrow was picked up! Scarecrows at the table: "
						+ scarecrow + "\n");
			} else if (card == Card.CAT)
			// Cat-cards
			{
				if (turn % 2 == 0) {
					console.print("\n      /\\_/\\\n /\\  / o o \\\n//\\\\ \\~(*)~/\n`  \\/   ^ /\n   "
							+ "| \\|| ||\n   \\ '|| ||\n    \\)()-())\n"
							+ p1.getName()
							+ ", return all your cards to the deck!\n");
					ch.resetCards(p1.resetCards());
				} else {
					console.print("\n      /\\_/\\\n /\\  / o o \\\n//\\\\ \\~(*)~/\n`  \\/   ^ /\n   "
							+ "| \\|| ||\n   \\ '|| ||\n    \\)()-())\n"
							+ p2.getName()
							+ ", return all your cards to the deck!\n");
					ch.resetCards(p2.resetCards());
				}
			} else
			// Bird card(1-6)
			{
				console.print("\n         .-.\n        (. .)__,')\n        / V  "
						+ card.getValue()
						+ "   )\n        "
						+ "\\  (   \\/\n         `._`._ \\\n      =====<<==`'====\n\n");
				if (turn % 2 == 0) {
					p1.addCard(card);
					console.print(p1.getName() + "'s cards: " + p1.getCards());
				} else {
					p2.addCard(card);
					console.print(p2.getName() + "'s cards: " + p2.getCards());
				}
			}
			turn++;
		}

		// Who won?
		if (p1.getPoints() > p2.getPoints()) {
			console.print("\n♛" + p1.getName() + " won the game!♛");
			console.print("\nWith " + p1.getPoints() + " points, "
					+ p2.getName() + " had " + p2.getPoints() + " points");
		} else if (p1.getPoints() < p2.getPoints()) {
			console.print("\n♛" + p2.getName() + " won the game!♛");
			console.print("\nWith " + p2.getPoints() + " points, "
					+ p1.getName() + " had " + p1.getPoints() + " points");
		} else {
			console.print("Draw!");
		}
	}
}
