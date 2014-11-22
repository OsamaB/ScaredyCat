
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

	public void getName(){
		System.out.println("Player name: " + name);
	}
	
	public void getAge(){
		System.out.println("Player age: " + age);
	}
	
	public void addCard(int card){
		for(int i = 0;i<cards.length;i++){
			if(cards[i] == -2){
				cards[i] = card;
				break;
			}
		}
	}
	
	public void printCards(){
		for(int card:cards){
			System.out.println(card);
		}
	}
}
