
public class Building implements CarbonFootprint 
{
	private final double BUILDING_KILLOWATT_RATE = 0.25;
	private final int KILLOWATT_PER_SQUARE_FEET = 123;
	private int squareFeet;
	private String ownerName;
	
	public Building()
	{
		this("Squidward", 0);
	}
	
	public Building(String ownerName, int squareFeet)
	{
		this.ownerName = ownerName;
		this.squareFeet = squareFeet;
	}
	
	// Calculates monthly electric bill based on the square foot dimensions of the building using a constant rate.
	private int getMonthlyElectricBill()
	{
		int killoWattHours = KILLOWATT_PER_SQUARE_FEET * squareFeet;
		return (int) (killoWattHours * BUILDING_KILLOWATT_RATE);
	}
	
	@Override
	public double getCarbonFootprint()
	{
		return (getMonthlyElectricBill() / BUILDING_KILLOWATT_RATE) * ELECTRICITY_EMISSIONS_FACTOR * MONTHS_IN_YEAR; 
	}
	
	@Override
	public String toString()
	{
		return "Leasing the " + squareFeet + " sqft. building owned by " + ownerName + " will create " + (int)getCarbonFootprint() + " pounds of CO2 per year based on a factor of " + KILLOWATT_PER_SQUARE_FEET + " kW per sqft. The monthly electric bill would be approximately $" + getMonthlyElectricBill() + "\n";
	}
}
