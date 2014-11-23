
public class Game {
	CardHandler ch = new CardHandler(12,10,8,4,4,2);
	Console console = new Console();
	//Card to get up a card from the deck, scarecrow to see how many scarecrows picked up,
	//player to handle which player's turn it is
	int card,scarecrow = 0,turn = 0;
	public void start() throws java.io.IOException{
		System.out.println("--Game Started");
		console.print("Welcome to Scaredy Cat game!");
		Player p1 = new Player(console.getName(), console.getAge());
		Player p2 = new Player(console.getName(), console.getAge());
		/*p1.getName();
		p1.getAge();
		p2.getName();
		p2.getAge();*/
		ch.shuffleCards();
		while(scarecrow < 6){
			console.print("Press enter to pick a card");
			if(console.getInput() == "Next"){
				card = ch.pickCard();
			}
			if(card == 0){
				scarecrow++;
				System.out.println("ScareCrow was picked up! ScareCrows at the table: " + scarecrow);
			}else if(card == -1){
				System.out.println("Return your cards");
			}else{
				if(turn%2 == 0){
					p1.addCard(card);
					console.print("Player 1's cards");
					p1.printCards();
				}else{
					p2.addCard(card);
					console.print("Player 2's cards");
					p2.printCards();
				}
			}
			turn++;
		}
		
		//System.out.println("Player 1 cards:");
		//p1.printCards();
		//System.out.println("Player 2 cards:");
		//p2.printCards();
		
	}
}
