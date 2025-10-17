package week6.day1;
import java.io.IOException;

// Demonstrating Dynamic Parameterization in TestNg with DDT- Data Driven Testing from Excel doc
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethods {

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		String[][]  read= ReadXLData.readData();
		return read;

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
