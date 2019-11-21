import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob10
{
	public static void main(String args[])
	{

		File name = new File("Prob10Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
				new FileReader(name));

			String text, output = "";

			String[] notes = { "G#", "G", "F#", "F", "E",
							   "D#", "D", "C#", "C", "B",
							   "A#", "A", "G#", "G", "F#",
							   "F", "E", "D#", "D", "C#",
							   "C", "B", "A#", "A", "G#",
							   "G", "F#", "F", "E" };

			int[][] positions = { { 28, 23, 18, 13, 9, 4 }, 
								  { 27, 22, 17, 12, 8, 3 }, 
								  { 26, 21, 16, 11, 7, 2 },
								  { 25, 20, 15, 10, 6, 1 },
								  { 24, 19, 14, 9, 5, 0 }, };

            int init = 0;
            String[][] pos = new String[0][0];
			int row = 0;
			
            while ((text = input.readLine()) != null) {

                String[] allMeasures = text.split(",");
				int measures = allMeasures.length;
				
                if (init == 0) {
                    pos = new String[30][measures];
                    System.out.print("Measure\t");
                    for (int i = 1; i <= measures; i++) {
                        System.out.print("\t" + i);
                    }
                    System.out.println();
				}
				
                init = 1;
                for (int i = 0; i < measures; i++) {
                    for (int j = 0; j < 6; j++) {
                        int current = positions[row][j];

                        if (allMeasures[i].charAt(j) == '*' || allMeasures[i].charAt(j) == 'o') {
                            pos[current][i] = "O";
                        } else {
                            pos[current][i] = " ";
                        }
                    }
                }
                row++;
            }

            for (int i = 0; i < pos.length; i++) {
                if (i == 29)
                    break;
                else
                    System.out.print(notes[i] + "\t\t");
                for (int j = 0; j < pos[0].length; j++) {
                    System.out.print("\t" + pos[i][j]);
                }
                System.out.println();

			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}