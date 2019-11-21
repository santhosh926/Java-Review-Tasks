import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Prob7
{
	public static void main(String args[])
	{

		File name = new File("Prob7Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));

            String text =  "";
            int count = 0;

            double dollars = 0.0;
            double fee1 = 0.0;
            double fee2 = 0.0;
            double cr1 = 0.0;
            double cr2 = 0.0;
            ArrayList<Booth> booths = new ArrayList<>();

			while( (text=input.readLine())!= null)
			{
                text = text.substring(text.indexOf(" ")+1, text.length());

                if(count < 5)
                {
                    switch(count)
                    {
                        case 0: dollars = Integer.parseInt(text);
                        break;

                        case 1: cr1 = Double.parseDouble(text);
                        break;

                        case 2: fee1 = Integer.parseInt(text);
                        break;

                        case 3: cr2 = Double.parseDouble(text);
                        break;

                        case 4: fee2 = Integer.parseInt(text);
                        break;
                    }
                    count++;
                }
                
                if(count == 5)
                {
                    count = 0;
                    Booth b = new Booth(dollars, fee1, fee2, cr1, cr2);
                    booths.add(b);
                }
            }
            
            for(int i = 0; i < booths.size(); i++)
            {
            double b1 = (booths.get(i).dollars - ((booths.get(i).fee1 / 100) * booths.get(i).dollars)) * booths.get(i).cr1;
            double b2 = (booths.get(i).dollars - ((booths.get(i).fee2 / 100) * booths.get(i).dollars)) * booths.get(i).cr2;

            DecimalFormat df = new DecimalFormat("#.00");
            
            String b1s = df.format(b1);
            String b2s = df.format(b2);
            
            String d1 = df.format(b1-b2);
            String d2 = df.format(b2-b1);

            System.out.println("Booth 1: " + b1s);
            System.out.println("Booth 2: " + b2s);

            if(b1 > b2)
                System.out.println("Booth 1 is best; difference is " + d1);
            else
                System.out.println("Booth 2 is best; difference is " + d2);

            System.out.println();
            }

		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }
    
    public static class Booth
    {

        private double cr1, cr2, dollars, fee1, fee2;

        public Booth(double dollars, double fee1, double fee2, double cr1, double cr2)
        {
            this.dollars = dollars;
            this.fee1 = fee1;
            this.fee2 = fee2;
            this.cr1 = cr1;
            this.cr2 = cr2;
        }

        /**
         * @return the cr1
         */
        public double getCr1() {
            return cr1;
        }

        /**
         * @return the cr2
         */
        public double getCr2() {
            return cr2;
        }

        /**
         * @return the fee1
         */
        public double getFee1() {
            return fee1;
        }

        /**
         * @return the fee2
         */
        public double getFee2() {
            return fee2;
        }

        /**
         * @return the dollars
         */
        public double getDollars() {
            return dollars;
        }
        
    }

}