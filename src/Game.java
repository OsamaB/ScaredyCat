
public class Game {
	CardHandler ch = new CardHandler(12,10,8,4,4,2);
	Console console = new Console();
	//Card to get up a card from the deck, scarecrow to see how many scarecrows picked up,
	//player to handle which player's turn it is
	int card,scarecrow = 0,turn = 0;
	String input = null;
	public void start() throws java.io.IOException{
		console.print("Welcome to Scaredy Cat game!");
		
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
					console.print(p1.getName() + ", press enter to pick a card");
				}else{
					console.print(p2.getName() + ", press enter to pick a card");
				}
				input = console.getInput();
				if(input == "Exit"){
					System.exit(0);
				}
			}while(input != "Next");
			card = ch.pickCard();
			
			if(card == 0){
				scarecrow++;
				System.out.println("ScareCrow was picked up! ScareCrows at the table: " + scarecrow + "\n");
			}else if(card == -1){
				System.out.println("Return your cards" + "\n");
			}else{
				if(turn%2 == 0){
					p1.addCard(card);
					console.print(p1.getName() + "'s cards:");
					p1.printCards();
				}else{
					p2.addCard(card);
					console.print(p2.getName() + "'s cards:");
					p2.printCards();
				}
			}
			
			turn++;
		}
		
		//Who won?
		if(p1.getPoints() > p2.getPoints()){
			console.print(p1.getName() + " won the game!");
		}else if(p1.getPoints() < p2.getPoints()){
			console.print(p2.getName() + " won the game!");
		}else{
			console.print("Draw!");
		}
		
	}//start()
	
}//Game
