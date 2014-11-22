
public class CardHandler {
	private int[] deck = new int[49];
	private int card = 0;
	
	//Construct how many of each bird card should be used in the deck
	CardHandler(int a, int b, int c, int d, int e, int f){

		//3 cat-cards (-1)
		for(int i = 0;i<3;i++){
			deck[card] = -1;
			card++;
		}
		//6 scarecrow cards(0)
		for(int i = 0;i<6;i++){
			deck[card] = 0;
			card++;
		}
		//a bird cards with 1 bird
		for(int i = 0;i<a;i++){
			deck[card] = 1;
			card++;
		}
		//b bird cards with 2 birds
		for(int i = 0;i<b;i++){
			deck[card] = 2;
			card++;
		}
		//c bird cards with 3 birds
		for(int i = 0;i<c;i++){
			deck[card] = 3;
			card++;
		}
		//d bird cards with 4 birds
		for(int i = 0;i<d;i++){
			deck[card] = 4;
			card++;
		}
		//e bird cards with 5 birds
		for(int i = 0;i<e;i++){
			deck[card] = 5;
			card++;
		}
		//f bird cards with 6 birds
		for(int i = 0;i<f;i++){
			deck[card] = 6;
			card++;
		}
	}
	
	public void shuffleCards(){
		for(int i = 0; i < deck.length; i++ ){
			int otherCard = (int) (Math.random() * deck.length);
	        int temporary = deck[i];
	        deck[i] = deck[otherCard];
	        deck[otherCard] = temporary;
		}
	}
	
	public void getCards(){
		for(int i = 0;i<deck.length;i++){
			System.out.println("index: " + i + ", Value: " + deck[i]);
		}
	}
	
	public int pickCard(){
		card = 0;
		for(int i = 0;i<deck.length;i++){
			if(deck[i] != -2){
				card = deck[i];
				deck[i] = -2;
				break;
			}
		}
		return card;
	}
}
