
public class Game {
	CardHandler ch = new CardHandler(12,10,8,4,4,2);
	Console console = new Console();
	//Card to get up a card from the deck, scarecrow to see how many scarecrows picked up,
	//player to handle which player's turn it is
	int card,scarecrow = 0,turn = 0;
	String input = null;
	String output = null;
	public void start() throws java.io.IOException{
		console.print("Welcome to Scaredy Cat game!😺\n");
		
		Player p1 = new Player(console.getName(), console.getAge());
		Player p2 = new Player(console.getName(), console.getAge());
		
		//Check if player2 is younger than player1, if true, let player2 start the game
		if(p2.getAge() < p1.getAge()){
			turn = 1;
		}
		
		ch.shuffleCards();
		while(scarecrow < 6){
			
			do{
				if(turn%2 == 0){
					console.print("\n" + p1.getName() + ", press enter to pick a card: ");
				}else{
					console.print("\n" + p2.getName() + ", press enter to pick a card: ");
				}
				input = console.getInput();
				if(input == "Exit"){
					System.exit(0);
				}else if(input == "Restart"){
					start();
				}
			}while(input != "Next");
			card = ch.pickCard();
			
			if(card == 0){
				scarecrow++;
				output = "         _\n       _/_\\_\n      __\\\"/__\n     \"--(_)--\"\n        /_\\\n       //|\\\\\n      \"` | `\"\n       __|__";
				console.print(output);
				console.print("\nScarecrow was picked up! Scarecrows at the table: " + scarecrow + "\n");
			}else if(card == -1){
				if(turn%2 == 0){
					output = "\n      /\\_/\\\n /\\  / o o \\\n//\\\\ \\~(*)~/\n`  \\/   ^ /\n   | \\|| ||\n   \\ '|| ||\n    \\)()-())\n" + p1.getName() + ", return all your cards to the deck!\n";
				}else{
					output = "\n      /\\_/\\\n /\\  / o o \\\n//\\\\ \\~(*)~/\n`  \\/   ^ /\n   | \\|| ||\n   \\ '|| ||\n    \\)()-())\n" + p2.getName() + ", return all your cards to the deck!\n";
				}
				console.print(output);
			}else{
				output = "\n         .-.\n        (. .)__,')\n        / V  " + card + "   )\n        \\  (   \\/\n         `._`._ \\\n      =====<<==`'====\n\n";
				console.print(output);
				if(turn%2 == 0){
					p1.addCard(card);
					console.print(p1.getName() + "'s cards: " + p1.getCards());
				}else{
					p2.addCard(card);
					console.print(p2.getName() + "'s cards: " + p2.getCards());
				}
			}
			
			turn++;
		}
		
		//Who won?
		if(p1.getPoints() > p2.getPoints()){
			console.print("\n♛" + p1.getName() + " won the game!♛");
		}else if(p1.getPoints() < p2.getPoints()){
			console.print("\n♛" + p2.getName() + " won the game!♛");
		}else{
			console.print("Draw!");
		}
		
	}//start()
	
}//Game
