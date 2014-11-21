
public class Player {
	
	private String name;
	private int age;
	
	Player(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void getName(){
		System.out.println(name);
	}
	
	public void getAge(){
		System.out.println(age);
	}
}
