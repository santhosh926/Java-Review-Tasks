import java.io.*;
import java.util.ArrayList; 

public class Prob3
{
    public static void main(String args[])
    {
        File name = new File("Prob3Input.txt");
    
        try
        {
            BufferedReader input = new BufferedReader(
                                     new FileReader(name));
    
            String text = "";
            while( (text=input.readLine())!= null)
            {
                String init = text.substring(0, text.indexOf(" "));
                String second = text.substring(text.indexOf(" ")+1, text.length());
                int num1 = Integer.parseInt(init);
                int num2 = Integer.parseInt(second);

                int[] nums = {num1, num2};
                DoubleList obj = findFactors(nums);

                if(obj.getAmic())
                    System.out.println("The numbers " + num1 + " and " + num2 + " are amicable.");
                else
                    System.out.println("The numbers " + num1 + " and " + num2 + " are not amicable."); 
                    
                System.out.println("\tFactors of " + num1 + " are " + obj.getL1() + ". Sum is " + obj.getSum1() + ".");
                System.out.println("\tFactors of " + num2 + " are " + obj.getL2() + ". Sum is " + obj.getSum2() + ".");
                System.out.println();
            }
        }
        catch (IOException io)
        {
            System.err.println("File does not exist");
        }
    }

    public static DoubleList findFactors(int[] numbers)
    {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int total1 = 0;
        int total2 = 0;
        boolean amicable = false;

        for(int i = 0; i < 2; i++)
        {
            for(int j = 1; j < numbers[i]; j++)
            {
                if(numbers[i] % j == 0){
                    if(i==0)
                    {
                        list1.add(j);
                        total1 += j;
                    }
                    else
                    {
                        list2.add(j);
                        total2 += j;
                    }
                }

            }
        }

        if(total1 == numbers[1] && total2 == numbers[0])
            amicable = true;


        DoubleList dl = new DoubleList(list1, list2, amicable, total1, total2);
        return dl;
    }

    public static class DoubleList
    {   
    private ArrayList<Integer> l1,l2;
    private boolean amic;
    int sum1, sum2;

    public DoubleList(ArrayList<Integer> a, ArrayList<Integer> b, boolean bool, int s1, int s2)
    {
        l1 = a;
        l2 = b;
        amic = bool;
        sum1 = s1;
        sum2 = s2;
    }

    public ArrayList<Integer> getL1() { return l1; }
    public ArrayList<Integer> getL2() { return l2; }
    public boolean getAmic() { return amic; }
    public int getSum1() { return sum1; }
    public int getSum2() { return sum2; }

    }

}




