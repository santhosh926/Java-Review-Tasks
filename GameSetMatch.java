import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameSetMatch {
    
    public static void main(String[] args) {

        File name = new File("Prob1Input.txt");
        ArrayList<String> list = new ArrayList<>();

		try {
			BufferedReader input = new BufferedReader(
									 new FileReader(name));

			String text, output = "";
			while( (text=input.readLine())!= null) {
				//System.out.println(text);
                output+=text;
                list.add(output);
                output = "";
            }
        
            //System.out.println(list);
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}
        
        ArrayList<String> set = new ArrayList<>();
        int index = 0;
        while(index < list.size()) {
            int z = 0;
            while(z < 3) {
                set.add(list.remove(0));
                z++;
            }
            index++;
        }

        while(set.size() >= 3)
        {
            String[] a1 = set.remove(0).split(" ");
            String[] a2 = set.remove(0).split(" ");
            String[] a3 = set.remove(0).split(" ");

            ArrayList<Integer> al1 = new ArrayList<>();
            ArrayList<Integer> al2 = new ArrayList<>();
            ArrayList<Integer> al3 = new ArrayList<>();

            for(String s: a1)
            {
                al1.add(Integer.parseInt(s));
            }
    
            for(String s: a2)
            {
                al2.add(Integer.parseInt(s));
            }
    
            for(String s: a3)
            {
                al3.add(Integer.parseInt(s));
            }
            
            System.out.print("Set 1: ");
            for(int i = 0; i < al1.size(); i++)
            {
                if(i == 0)
                    System.out.print("{");

                if(i != al1.size()-1)
                    System.out.print(al1.get(i) + ", ");
                else
                    System.out.print(al1.get(i) + "}");
            }
            System.out.println();

            System.out.print("Set 2: ");
            for(int i = 0; i < al2.size(); i++)
            {
                if(i == 0)
                    System.out.print("{");

                if(i != al2.size()-1)
                    System.out.print(al2.get(i) + ", ");
                else
                    System.out.print(al2.get(i) + "}");
            }
            System.out.println();

            System.out.print("Set 3: ");
            for(int i = 0; i < al3.size(); i++)
            {
                if(i == 0)
                    System.out.print("{");

                if(i != al3.size()-1)
                    System.out.print(al3.get(i) + ", ");
                else
                    System.out.print(al3.get(i) + "}");
            }
            System.out.println();

            ArrayList<Integer> ints = getIntersections(al1, al2, al3);
            Collections.sort(ints);

            System.out.print("\tIntersection of sets: ");
            for(int i = 0; i < ints.size(); i++)
            {
                if(i == 0)
                    System.out.print("{");

                if(i != ints.size()-1)
                    System.out.print(ints.get(i) + ", ");
                else
                    System.out.print(ints.get(i) + "}");
            }
            System.out.println();
        }

    }

    public static ArrayList<Integer> getIntersections(ArrayList<Integer> al1, ArrayList<Integer> al2, ArrayList<Integer> al3)
    {
        ArrayList<Integer> ints = new ArrayList<>();

        int size1 = al1.size();
        int size2 = al2.size();
        int size3 = al3.size();
        int yeo = 0;

        if(size1 > size2 && size2 > size3)
            yeo = size1;
        else if(size2 > size1 && size1 > size3)
            yeo = size2;
        else
            yeo = size3;

        for(int i = 0; i < yeo; i++)
        {
            if(yeo == size1)
            {
                if( al2.contains(al1.get(i)) && al3.contains(al1.get(i)) )
                    ints.add(al1.get(i));
            }

            else if(yeo == size2)
            {
                if( al1.contains(al2.get(i)) && al3.contains(al2.get(i)) )
                    ints.add(al2.get(i));
            }
            
            else
            {
                if( al1.contains(al3.get(i)) && al2.contains(al3.get(i)) )
                    ints.add(al3.get(i));
            }
        }

        return ints;
    }

}