import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutoTest 
{

	@Test
	void test() 
	{
		Auto c1 = new Auto();
		assertEquals(c1.toString(), "Driving a 1969 Big Chungus 0 miles per week creates 0 pounds of CO2 per year\n");
		
		Auto c2 = new Auto("Honda", "Accord", 1995, 100);
		assertEquals(c2.getFuelEfficiency(), 20.5);
		assertEquals(c2.toString(), "Driving a 1995 Honda Accord 100 miles per week creates 4920 pounds of CO2 per year\n");
	}

}
