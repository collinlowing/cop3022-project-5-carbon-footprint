import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildingTest 
{

	@Test
	void test() 
	{
		Building b1 = new Building();
		assertEquals(b1.toString(), "Leasing the 0 sqft. building owned by Squidward will create 0 pounds of CO2 per year based on a factor of 123 kW per sqft. The monthly electric bill would be approximately $0\n");
		
		Building b2 = new Building("Collin", 100);
		assertEquals(b2.toString(), "Leasing the 100 sqft. building owned by Collin will create 202212 pounds of CO2 per year based on a factor of 123 kW per sqft. The monthly electric bill would be approximately $3075\n");
	}

}
