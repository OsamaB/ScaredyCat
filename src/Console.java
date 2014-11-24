public class Console
{

	private String name;
	private int player = 1;

	public void print(String str)
	{
		System.out.print(str);
	}

	public void welcome()
	{
		print("Welcome to Scaredy Cat game!😺\n");
	}

	public String getName() throws java.io.IOException
	{
		System.out.print("Player" + player + ", what is your name?: ");
		name = getInput();

		if (name.equals("") || name.equals("Next"))
		{
			return getName();
		}
		else
		{
			player++;
			return name;
		}
	}

	public int getAge() throws java.io.IOException
	{
		int age;
		System.out.print(name + ", how old are you? (0 - 100): ");
		try
		{
			age = Integer.parseInt(getInput());
		}
		catch (NumberFormatException e)
		{
			return getAge();
		}

		if (age >= 0 && age <= 100)
		{
			return age;
		}
		else
		{
			return getAge();
		}
	}

	public String getInput()
			throws java.io.IOException
	{
		char ch[] = new char[20];
		int i = 0;

		while (i == 0 || ch[i - 1] != '\n' && i < ch.length)
		{
			ch[i] = (char) System.in.read();
			i++;
		}

		String input = String.valueOf(ch).trim();
		if (ch[0] == '\n')
		{
			return "Next";
		}
		else if (input.equalsIgnoreCase("x") || input.equalsIgnoreCase("exit"))
		{
			return "Exit";
		}
		else if (input.equalsIgnoreCase("r") || input.equalsIgnoreCase("restart"))
		{
			return "Restart";
		}
		else
		{
			return input;
		}

	}
}
