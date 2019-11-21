import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Prob5
{
	public static void main(String args[])
	{

		File name = new File("Prob5Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
            
			String text = "";
			int count = 0;

			double mpg = 0;
			int cyl = 0;
			double dis = 0;
			int hp = 0;
			int weight = 0;
			int year = 0;

			double acc = 0.0;

			String model = "";
			String origin = "";
			
			ArrayList<Car> cars = new ArrayList<>();

			while ((text=input.readLine())!= null)
			{
				if(count > 0)
				{
					String[] arr = text.split("\t");

					for(int i = 0; i < arr.length; i++)
					{
						if(arr[i].equals("NA"))
							arr[i] = "0";

						switch(i)
						{
							case 0:	model = arr[i];
								break;
							case 1: mpg = Double.parseDouble(arr[i]);
								break;
							case 2: cyl = Integer.parseInt(arr[i]);
								break;
							case 3: dis = Double.parseDouble(arr[i]);
								break;
							case 4: hp = Integer.parseInt(arr[i]);
								break;
							case 5: weight = Integer.parseInt(arr[i]);
								break;
							case 6: acc = Double.parseDouble(arr[i]);
								break;
							case 7: year = Integer.parseInt(arr[i]);
								break;
							case 8: origin = arr[i];
								break;
						}
					}

					Car car = new Car(mpg, cyl, dis, hp, weight, year, acc, model, origin);
					cars.add(car);
				}
				count++;
			}

			ArrayList<Double> hMpg = new ArrayList<>();
			ArrayList<Integer> hCyl = new ArrayList<>();
			ArrayList<Double> hDis = new ArrayList<>();
			ArrayList<Integer> hHp = new ArrayList<>();
			ArrayList<Integer> hW = new ArrayList<>();
			ArrayList<Double> hAcc = new ArrayList<>();
			ArrayList<Integer> hYear = new ArrayList<>();

			for(Car car : cars)
			{
				hMpg.add(car.mpg);
				hCyl.add(car.cyl);
				hDis.add(car.dis);
				hHp.add(car.hp);
				hW.add(car.weight);
				hAcc.add(car.acc);
				hYear.add(car.year);
			}
		
			Collections.sort(hMpg, Collections.reverseOrder());	
			Collections.sort(hCyl, Collections.reverseOrder());	
			Collections.sort(hDis, Collections.reverseOrder());	
			Collections.sort(hHp, Collections.reverseOrder());	
			Collections.sort(hW, Collections.reverseOrder());	
			Collections.sort(hAcc, Collections.reverseOrder());	
			Collections.sort(hYear, Collections.reverseOrder());

			ArrayList<String> shMpg = new ArrayList<>();
			ArrayList<String> shCyl = new ArrayList<>();
			ArrayList<String> shDis = new ArrayList<>();
			ArrayList<String> shHp = new ArrayList<>();
			ArrayList<String> shW = new ArrayList<>();
			ArrayList<String> shAcc = new ArrayList<>();
			ArrayList<String> shYear = new ArrayList<>();

			ArrayList<String> slMpg = new ArrayList<>();
			ArrayList<String> slCyl = new ArrayList<>();
			ArrayList<String> slDis = new ArrayList<>();
			ArrayList<String> slHp = new ArrayList<>();
			ArrayList<String> slW = new ArrayList<>();
			ArrayList<String> slAcc = new ArrayList<>();
			ArrayList<String> slYear = new ArrayList<>();

			for(int i = hMpg.size()-1; i > hMpg.size()-4; i--)
			{
				for(int j = 0; j < cars.size(); j++)
				{
					if(cars.get(j).getMPG() == hMpg.get(i))
						slMpg.add(cars.get(j).model);

					if(cars.get(j).getCyl() == hCyl.get(i))
						slCyl.add(cars.get(j).model);

					if(cars.get(j).getDis() == hDis.get(i))
						slDis.add(cars.get(j).model);
						
					if(cars.get(j).getHP() == hHp.get(i))
						slHp.add(cars.get(j).model);

					if(cars.get(j).getWeight() == hW.get(i))
						slW.add(cars.get(j).model);

					if(cars.get(j).getAcc() == hAcc.get(i))
						slAcc.add(cars.get(j).model);

					if(cars.get(j).getYear() == hYear.get(i))
						slYear.add(cars.get(j).model);
				}
			}

			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < cars.size(); j++)
				{
					if(cars.get(j).getMPG() == hMpg.get(i))
						shMpg.add(cars.get(j).model);

					if(cars.get(j).getCyl() == hCyl.get(i))
						shCyl.add(cars.get(j).model);

					if(cars.get(j).getDis() == hDis.get(i))
						shDis.add(cars.get(j).model);
						
					if(cars.get(j).getHP() == hHp.get(i))
						shHp.add(cars.get(j).model);

					if(cars.get(j).getWeight() == hW.get(i))
						shW.add(cars.get(j).model);

					if(cars.get(j).getAcc() == hAcc.get(i))
						shAcc.add(cars.get(j).model);

					if(cars.get(j).getYear() == hYear.get(i))
						shYear.add(cars.get(j).model);
				}
			}

			System.out.println("Highest MPG");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(shMpg.get(i) + "\t" + hMpg.get(i));
			}
			System.out.println();

			System.out.println("Lowest MPG");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(slMpg.get(i) + "\t" + hMpg.get(hMpg.size()-(1+i)));
			}
			System.out.println();

			System.out.println("Highest # Cylinders");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(shCyl.get(i) + "\t" + hCyl.get(i));
			}
			System.out.println();

			System.out.println("Lowest # Cylinders");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(slCyl.get(i) + "\t" + hCyl.get(hCyl.size()-(1+i)));
			}
			System.out.println();

			System.out.println("Highest Displacement");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(shDis.get(i) + "\t" + hDis.get(i));
			}
			System.out.println();

			System.out.println("Lowest Displacement");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(slDis.get(i) + "\t" + hDis.get(hDis.size()-(1+i)));
			}
			System.out.println();

			System.out.println("Highest Horsepower");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(shHp.get(i) + "\t" + hHp.get(i));
			}
			System.out.println();

			System.out.println("Lowest Horsepower");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(slHp.get(i) + "\t" + hHp.get(hHp.size()-(1+i)));
			}
			System.out.println();

			System.out.println("Highest Weight");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(shW.get(i) + "\t" + hW.get(i));
			}
			System.out.println();

			System.out.println("Lowest Weight");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(slW.get(i) + "\t" + hW.get(hW.size()-(1+i)));
			}
			System.out.println();

			System.out.println("Highest Acceleration");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(shAcc.get(i) + "\t" + hAcc.get(i));
			}
			System.out.println();

			System.out.println("Lowest Acceleration");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(slAcc.get(i) + "\t" + hAcc.get(hAcc.size()-(1+i)));
			}
			System.out.println();

			System.out.println("Highest Year");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(shYear.get(i) + "\t" + hYear.get(i));
			}
			System.out.println();

			System.out.println("Lowest Year");
			for(int i = 0; i < 3; i++)
			{
				System.out.println(slYear.get(i) + "\t" + hYear.get(hYear.size()-(1+i)));
			}
			System.out.println();
			
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public static class Car
	{
		private int cyl, hp, weight, year;
		private double acc, dis, mpg;
		private String model, origin;

		public Car(double mpg, int cyl, double dis, int hp, int weight, int year, double acc, String model, String origin)
		{
			this.mpg = mpg;
			this.cyl = cyl;
			this.dis = dis;
			this.hp = hp;
			this.weight = weight;
			this.year = year;
			this.acc = acc;
			this.model = model;
			this.origin = origin;
		}

		public double getMPG() { return mpg; }
		public int getCyl() { return cyl; }
		public int getHP() { return hp; }
		public double getDis() { return dis; }
		public int getWeight() { return weight; }
		public int getYear() { return year; }
		public double getAcc() { return acc; }
		public String getModel() { return model; }
		public String getOrigin() { return origin; }

	}
}