import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest 
{

	@Test
	void test() 
	{
		Food f1 = new Food();
		assertEquals(f1.getEmissionsFactor(), 467);
		assertEquals(f1.toString(), "Spending $0 per month on Trash creates 0 pounds of CO2 per year\n");
		
		Food meat = new Food("Meat", 200);
		assertEquals(meat.getEmissionsFactor(), 1452);
		assertEquals(meat.toString(), "Spending $200 per month on Meat creates 7666 pounds of CO2 per year\n");
		
		Food bread = new Food("bread", 100);
		assertEquals(bread.getEmissionsFactor(), 741);
		
		Food milk = new Food("mIlK", 666);
		assertEquals(milk.getEmissionsFactor(), 1911);
		
		Food plant = new Food("fruit", 9709745);
		assertEquals(plant.getEmissionsFactor(), 1176);
		
		Food pizza = new Food("take-out", 20);
		assertEquals(pizza.getEmissionsFactor(), 368);
	}

}
