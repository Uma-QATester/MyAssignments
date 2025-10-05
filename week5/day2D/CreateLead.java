package week5.day2D;
//Classroom Assignment <Day2.2>: Demonstrating Dynamic Parameterization in TestNg
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethods {

	// step 1: create a normal method
	@DataProvider(name = "fetchData") // Step:3 Add @DataProvider annotation on top of the method
	public String[][] sendData() {
		// step 2: declare and assign the value to 2D Array
		// syntax : datatype identifierName[][] = new datatype[setNumber][testData];
		String[][] dynamicData = new String[3][4];// setName-3 --> 0,1,2 : testData--> 0,1,2,3

		// test data from the set no.0
		dynamicData[0][0] = "Testleaf";
		dynamicData[0][1] = "Bhuvanesh";
		dynamicData[0][2] = "Moorthy";
		dynamicData[0][3] = "999";

		// test data from the set no.1
		dynamicData[1][0] = "Qeagle";
		dynamicData[1][1] = "Seenivasan";
		dynamicData[1][2] = "Shanmugam";
		dynamicData[1][3] = "888";

		// test data from the set no.2
		dynamicData[2][0] = "TCS";
		dynamicData[2][1] = "Harrish";
		dynamicData[2][2] = "A";
		dynamicData[2][3] = "777";

		return dynamicData;

	}
	// Step:4 Add dataProvider attribute the @Test Method

	@Test(dataProvider = "fetchData")
		public void NgCreatelead(String companyName, String firstName, String lastName, String phoneNumber) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		} else {
			System.out.println("Lead is not created");

		}

	}

}
