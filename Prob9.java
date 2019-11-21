import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Prob9 {
	
    public static void main(String[] args)
    {

        try
        {
            File name = new File("Prob9Input.txt");
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text = "";

            while((text = input.readLine()) != null) {

                int size = Integer.parseInt(text);
                String[][] pattern = new String[size][size]; 
                for(int i = 0; i < size; i++) {
                    for(int j = 0; j < size; j++) {
                        pattern[i][j] = " - ";
                    }
                }
    
                
                int r1 = 0;
                int r2 = size-1;
                int c1 = 0;
                int c2 = size-1;
                while(r1<=r2 && c1<=c2) {
                    	
                    for(int i = c1; i <= c2; i++) {
                        pattern[r1][i] = " * ";
                    }
                    r1++;

                    if(c1>0)
                        c1++;
                    
                    for(int i = r1; i <= r2; i++) {
                        pattern[i][c2] = " * ";
                    }

                    c2--;
                    r1++;
                    
                    for(int i = c2; i >= c1; i--) {
                        pattern[r2][i] = " * ";
                    }

                    r2--;
                    c2--;
                    
                    for(int i = r2; i >= r1; i--) {
                        pattern[i][c1] = " * ";
                    }

                    c1++;
                    r2--;
                }

                if(size % 4 == 2) 
                    pattern[(size)/2][(size-1)/2] = " - ";
                
                System.out.println(size);
                for(int i = 0; i < size; i++) {
                    for(int j = 0; j < size; j++) {
                        System.out.print(pattern[i][j]);
                    }
                    System.out.println();
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
