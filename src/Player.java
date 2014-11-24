
public class Player {
	
	private String name;
	private int age;
	private int[] cards = new int[24];
	
	Player(String name, int age){
		this.name = name;
		this.age = age;
		//Make all "card-spots" empty
		for(int i = 0;i<cards.length;i++){
			cards[i] = -2;
		}
	}

	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void addCard(int card){
		for(int i = 0;i<cards.length;i++){
			if(cards[i] == -2){
				cards[i] = card;
				break;
			}
		}
	}
	
	public String getCards(){
		String theCards = new String("");
		for(int card:cards){
			if(card != -2){
				theCards = theCards.concat(card + ", ");
			}
		}
		theCards = theCards.concat("\n");
		return theCards;
	}
	
	public int getPoints(){
		int point = 0;
		for(int card:cards){
			if(card != -2){
				point+= card;
			}
		}
		return point;
	}
}
