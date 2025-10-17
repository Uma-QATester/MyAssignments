package week6.day1;
import java.io.IOException;

//Demonstrating Dynamic Parameterization in TestNg with DDT- Data Driven Testing from Excel doc
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethods  {
	

	@DataProvider(name = "editData")
	public String[][] sendData() throws IOException {
		String[][]  read= ReadXLData.readData();
		return read;

	}
	
	@Test(dataProvider = "editData")
	public void NgEditLead(String companyName, String firstName, String lastName, 
			String localName, String department, String description) {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
// Enter the CompanyName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(companyName);	
//Enter the FirstName Field Using Xpath. and  Enter the LastName Field Using Xpath. 
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys(lastName);
//Enter the FirstName (Local) Field Using Xpath.		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys(localName);
//Enter the Department Field Using any Locator of Your Choice. 
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys(department);
		//Thread.sleep(2000);	
// Enter the Description Field Using any Locator of your choice. 		
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys(description);
//Enter your email in the E-mail address Field using the locator of your choice. 	
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("SWDept1@testleaf.com");	
//Select State/Province as NewYork Using Visible Text. 	
		WebElement selectDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select option = new Select(selectDropdown);
		// selectByVisibleText()
		option.selectByVisibleText("New York");
// Click on the Create Button. * Click on the edit button.
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
// Clear the Description Field.
		driver.findElement(By.name("description")).clear();
//Fill the Important Note Field with Any text.
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("SWDept1-Important Note field");
// Click on the update button. 
		driver.findElement(By.xpath("//input[@value='Update']")).click();
//Get the Title of the Resulting Page. 		
		String actualTitle = driver.getTitle();
		System.out.println("Resulting Page Title :" + actualTitle);

}
}
