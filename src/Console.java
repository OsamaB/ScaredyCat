
public class Console {
	
	public void print(String str){
		System.out.println(str);
	}
	
	public String getName()
	throws java.io.IOException{
		String name;
		System.out.print("What is your name?: ");
		name = getInput();
		
		if(name.trim() == null){
			return getName();
		}else{
			return name;
		}
	}
	
	public int getAge()
	throws java.io.IOException{
		int age;
		
		System.out.print("How old are you? (0 - 100): ");
		try { 
			age = Integer.parseInt(getInput());
	    } catch(NumberFormatException e) { 
	        return getAge();
	    }
		
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
		
		while(i == 0 || ch[i-1] != '\n' && i < ch.length){
			ch[i] = (char) System.in.read();
			i ++;
		}
		
		String input = String.valueOf(ch);
		if(ch[0] == '\n'){
			return "Next";
		}else if(input.trim().equalsIgnoreCase("x") || input.trim().equalsIgnoreCase("exit")){
			return "Exit";
		}else{
			return input.trim();
		}
		
	}
	
}
