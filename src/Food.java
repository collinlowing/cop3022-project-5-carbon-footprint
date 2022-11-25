
public class Food implements CarbonFootprint 
{
	private String category;
	private int dollarsSpentPerMonth;
	private int emissionsFactor;
	
	public Food()
	{
		this("Trash", 0);
	}
	
	public Food(String category, int dollarsSpentPerMonth)
	{
		this.category = category;
		this.dollarsSpentPerMonth = dollarsSpentPerMonth;
	}
	
	//Changes emissions factor depending on the category of food
	public int getEmissionsFactor()
	{
		emissionsFactor = 0;
		if(category.equalsIgnoreCase("meat") || category.equalsIgnoreCase("fish") || category.equalsIgnoreCase("eggs"))
		{
			emissionsFactor = MEAT_EMISSIONS_FACTOR;
		}
		else if(category.equalsIgnoreCase("cereal") || category.equalsIgnoreCase("bread") || category.equalsIgnoreCase("wheat"))
		{
			emissionsFactor = BAKERY_PRODUCT_EMISSIONS_FACTOR;
		}
		else if(category.equalsIgnoreCase("dairy") || category.equalsIgnoreCase("milk") || category.equalsIgnoreCase("cheese") || category.equalsIgnoreCase("butter"))
		{
			emissionsFactor = DAIRY_EMISSIONS_FACTOR;
		}
		else if(category.equalsIgnoreCase("fruit") || category.equalsIgnoreCase("vegetables"))
		{
			emissionsFactor = FRUITS_AND_VEGATABLE_EMISSIONS_FACTOR;
		}
		else if(category.equalsIgnoreCase("eating out") || category.equalsIgnoreCase("take-out") || category.equalsIgnoreCase("restaurant"))
		{
			emissionsFactor = EATING_OUT_EMISSIONS_FACTOR;
		}
		else
		{
			emissionsFactor = OTHER_FOOD_EMISSIONS_FACTOR;
		}
		
		return emissionsFactor;
	}
	
	@Override
	public double getCarbonFootprint() 
	{	
		return (dollarsSpentPerMonth * emissionsFactor * MONTHS_IN_YEAR) * GRAM_TO_POUND_RATE;
	}
	
	@Override
	public String toString()
	{
		return "Spending $" + dollarsSpentPerMonth + " per month on " + category + " creates " + (int)getCarbonFootprint() + " pounds of CO2 per year\n";
	}

}
