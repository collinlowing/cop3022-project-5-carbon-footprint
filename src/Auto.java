
public class Auto implements CarbonFootprint 
{
	private String make;
	private String model;
	private int year;
	private int milesPerWeek;
	private double FUEL_EFFICIENCY;
	
	public Auto()
	{
		this("Big", "Chungus", 1969, 0);
	}
	
	public Auto(String make, String model, int year, int milesPerWeek)
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.milesPerWeek = milesPerWeek;
	}
	
	//changes Fuel Efficiency depending on model year
	public double getFuelEfficiency()
	{
		if(year >= 2017)
		{
			FUEL_EFFICIENCY = 24.9;
		}
		else if(year >= 2005)
		{
			FUEL_EFFICIENCY = 20;
		}
		else if(year >= 1995)
		{
			FUEL_EFFICIENCY = 20.5;
		}
		else if(year >= 1985)
		{
			FUEL_EFFICIENCY = 21.2; 
		}
		else if(year >= 1975)
		{
			FUEL_EFFICIENCY = 12.6;
		}
		else
			FUEL_EFFICIENCY = 24.6;
		
		return FUEL_EFFICIENCY;
	}

	@Override
	public double getCarbonFootprint() 
	{
		
		return ((milesPerWeek * WEEKS_IN_YEAR) / getFuelEfficiency()) * POUNDS_OF_CO2_PER_GALLON * EMISSIONS_OTHER_THAN_CO2;
	}
	
	@Override
	public String toString()
	{
		return "Driving a " + year + " " + make + " " + model + " " + milesPerWeek + " miles per week creates " + (int)getCarbonFootprint() + " pounds of CO2 per year\n";
	}

}
