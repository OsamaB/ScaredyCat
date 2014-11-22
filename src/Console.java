
public class Console {
	private String name = null;
	
	public void print(String str){
		System.out.println("Welcome to Scaredy Cat game!");
	}
	
	public String getName()
	throws java.io.IOException{
		if(name == null){
			System.out.print("What is your name?: ");
			name = getInput();
			return name;
		}else{
			return name;
		}
	}
	
	public int getAge()
	throws java.io.IOException{
		int age;
		System.out.print("How old are you? (0 - 100): ");
		age = System.in.read();
		if(age >= 0 && age <= 100){
			return age;
		}else{
			return getAge();
		}
	}
	
	public String getInput()
	throws java.io.IOException{
		char ch[] = new char[20];
		int i = 0;
		while(ch[i] != '\n'){
			ch[i] = (char) System.in.read();
			i ++;
		}
		String input = new String(ch);
		if(ch[0] == '\n'){
			return "Next";
		}else if(ch[0] == 'x'){
			return "Exit";
		}else{
			return input;
		}
	}
}
