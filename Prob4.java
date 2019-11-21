import java.io.*;
import java.util.Scanner;

public class Prob4
{
	public static void main(String args[])
	{

		File name = new File("Prob4Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));

			String text = "";
			while( (text=input.readLine())!= null)
			{
                Scanner reader = new Scanner(System.in);

                System.out.print("Guess the secret code (4 Digits): ");
                String guess = reader.nextLine();

                System.out.println("Secret Code: " + text);
                System.out.println("Your Guess: " + guess);
                
                int cp = 0;
                int ip = 0;

                for(int i = 0; i < 4; i++)
                {
                    if(text.indexOf("" + guess.charAt(0)) != -1)
                    {
                        if(text.charAt(i) == guess.charAt(i))
                        {
                            cp++;
                        }
                        else
                            ip++;
                    }

                }

                System.out.println("Color Correct - Correctly Placed: " + cp);
                System.out.println("Color Correct - Incorrectly Placed: " + ip);
                System.out.println();

			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}