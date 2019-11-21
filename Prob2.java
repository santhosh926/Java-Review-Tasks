import java.io.*;
import java.math.BigInteger;

public class Prob2
{
    public static void main(String args[])
    {
        File name = new File("Prob2Input.txt");
    
        try
        {
            BufferedReader input = new BufferedReader(
                                     new FileReader(name));
    
            String text, output = "";
            while( (text=input.readLine())!= null)
            {
                System.out.println(genNum(Integer.parseInt(text)));
            }
        }
        catch (IOException io)
        {
            System.err.println("File does not exist");
        }

    }

    public static BigInteger genNum(int x)
    {
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;

        for(int i = 1; i < x; i++)
        {
            zero = one;
            one = two.add(one);
            two = zero;
        }

        return one;
    }
}
