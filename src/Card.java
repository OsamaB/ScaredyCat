
public enum Card
{
	EMPTYCARD(0), CAT(0), SCARECROW(0), BIRD1(1), BIRD2(2), BIRD3(3), BIRD4(4), BIRD5(5), BIRD6(6);
	private int value;
	
	Card(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
