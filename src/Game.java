
public class Game {
	Player p1 = new Player("Stefan", 20);
	Player p2 = new Player("Osama", 27);
	CardHandler ch = new CardHandler(12,10,8,4,4,2);
	//Card to get up a card from the deck, scarecrow to see how many scarecrows picked up,
	//player to handle which player's turn it is
	int card,scarecrow = 0,turn = 0;
	public void start(){
		System.out.println("Game Started");
		ch.shuffleCards();
		card = ch.pickCard();
		if(card == 0){
			scarecrow++;
		}else if(card == -1){
			System.out.println("Return your cards");
		}else{
			if(turn%2 == 0){
				p1.addCard(card);
			}else{
				p2.addCard(card);
			}
		}
		
		System.out.println("Player 1 cards:");
		p1.printCards();
		System.out.println("Player 2 cards:");
		p2.printCards();
		
	}
}
