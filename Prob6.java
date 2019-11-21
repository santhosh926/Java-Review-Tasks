import java.io.*;
import java.util.ArrayList;

public class Prob6
{
	public static void main(String args[])
	{

		File name = new File("Prob6Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));

			String text = "";
			while( (text=input.readLine())!= null)
			{	
				//create a Die class
				Die die = new Die();
				ArrayList<String> list = new ArrayList<>();

				for(int i = 0; i < text.length(); i++)
				{
					String letter = text.substring(i, i+1);
					list.add(letter);
				}

				for(int i = 0; i< list.size(); i++)
				{
					if(list.get(i).equals("N"))
						die.north();
					else if(list.get(i).equals("S"))
						die.south();
					else if(list.get(i).equals("E"))
						die.east();
					else if(list.get(i).equals("W"))
						die.west();
				}
				System.out.println(die.topVal());
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public static class Die{

		private int top;
		private int bottom;
		private int north;
		private int east;
		private int south;
		private int west;
		private int temp;
		
		public Die(){
			top = 1;
			bottom = 6;
			north = 2;
			south = 5;
			east = 4;
			west = 3;
			temp = top;
		}
		
		public void north(){
		temp = top;
		top = south;
		south = bottom;
		bottom = north;
		north = temp;
		}
		
		public void south(){
		temp = top;
		top = north;
		north = bottom;
		bottom = south;
		south = temp;
		}
		
		public void east(){
		temp = top;
		top = west;
		west = bottom;
		bottom = east;
		east = temp;
		}
		
		public void west(){
		temp = top;
		top = east;
		east = bottom;
		bottom = west;
		west = temp;
		}
		
		public int topVal(){
		return top;
		}
	}
}