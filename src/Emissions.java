import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Emissions
{
	private static ArrayList<CarbonFootprint> carbon = new ArrayList<CarbonFootprint>();
	private static String fileName = "emissions.csv";
	
	public static void main(String[] args) 
	{
		try
		{
			readFile();
		}
		catch (IOException e)
		{
			System.out.println("emissions.txt is not present or could not be opened, please try again");
			return;
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
		
		//iterates over arraylist to print out results
		for(int i = 0; i < carbon.size(); i++)
		{
			System.out.print(carbon.get(i).toString());
		}
	}
	
	public static void readFile() throws Exception
	{
		FileInputStream infs = new FileInputStream(fileName);
		Scanner in = new Scanner(infs);
		
		while(in.hasNext()) //reads in each line
		{
			String line = in.nextLine();
			parseLine(line); //feeds into parseLine
		}
		infs.close();
	}
	
	public static void parseLine(String line)
	{
		Scanner str = new Scanner(line);
		str.useDelimiter(",");
		String type;
		
		//Check if string is empty
		if(str.hasNext())
		{
			type = str.next();
		}
		else
			return;
		
		//Check for type of emission tags
		//Adds to Building class
		if(type.equalsIgnoreCase("building"))
		{
			if(str.hasNext()) //checks for string after type
			{
				String owner = str.next();
				if(str.hasNextInt()) //checks for int after owner name 
				{
					int sqft = str.nextInt();
					carbon.add(new Building(owner, sqft));
				}
				else
					return;
			}
			else
				return;
			
		}
		//Adds to Food objects
		else if(type.equalsIgnoreCase("food"))
		{
			if(str.hasNext())
			{
				String category = str.next();
				if(str.hasNextInt())
				{
					int dollarsSpent = str.nextInt();
					carbon.add(new Food(category, dollarsSpent));
				}
				else
					return;
			}
			else
				return;
		}
		//Adds to Auto objects
		else if(type.equalsIgnoreCase("auto")) //checks for each value to make sure the proper value exists in the file line and skips over incomplete or mismatch values
		{
			if(str.hasNext())
			{
				String make = str.next();
				if(str.hasNext())
				{
					String model = str.next();
					if(str.hasNextInt())
					{
						int year = str.nextInt();
						if(str.hasNextInt())
						{
							int miles = str.nextInt();
							carbon.add(new Auto(make, model, year, miles));
						}
						else
							return;
					}
					else
						return;
				}
				else
					return;
			}
			else
				return;
		}
		else
			return;
	}
}
