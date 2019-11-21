import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Prob8
{
	public static void main(String args[])
	{
		DateFormat dateFormat = new SimpleDateFormat("hh:mmaa 'on' MM/dd/yyyy ");
		int count = 0;
		File name = new File("Prob8Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));

			String text =  "";
			while( (text=input.readLine())!= null)
			{
				count++;
				Date date = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				String[] arr = text.split(" ");
				
				int day = Integer.parseInt(arr[0]);
				int hour = Integer.parseInt(arr[1]);
				int min = Integer.parseInt(arr[2]);

				calendar.add(Calendar.DATE, day);
				calendar.add(Calendar.HOUR, hour);
				calendar.add(Calendar.MINUTE, min);

				//Print out date and time
				System.out.println("Trip " + count + ": ");
				System.out.println("\tDeparture Date and Time " + (dateFormat.format(date)));
				System.out.println("\tArrival Date and Time " + (dateFormat.format(calendar.getTime())));
            }
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}