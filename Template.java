import java.io.*;

public class Template
{
	public static void main(String args[])
	{

		File name = new File("Prob1Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));

			String text =  "";
			while( (text=input.readLine())!= null)
			{
				System.out.println(text);
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}