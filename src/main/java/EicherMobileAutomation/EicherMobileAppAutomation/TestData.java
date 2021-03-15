package EicherMobileAutomation.EicherMobileAppAutomation;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		Object[][] obj=new Object[][]
				{
			
			{"7648732490","123456"}
				};
				
				return obj;
				
				//{"9176072899","123456"}
				
	}

}
