
public class Game {
	public void start(){
		System.out.println("Game Started");
		Player p1 = new Player("Stefan", 20);
		Player p2 = new Player("Osama", 27);
		CardHandler ch = new CardHandler(12,10,8,4,4,2);
		ch.getCards();
		p1.getName();
		p1.getAge();
		p2.getName();
		p2.getAge();
	}
}
