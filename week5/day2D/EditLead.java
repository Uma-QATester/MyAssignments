package week5.day2D;
//Classroom Assignment <Day2.2>: Demonstrating Dynamic Parameterization in TestNg
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethods  {
	

	// step 1: create a normal method
	@DataProvider(name = "editData") // Step:3 Add @DataProvider annotation on top of the method
	public String[][] sendData() {
		// step 2: declare and assign the value to 2D Array
		// syntax : datatype identifierName[][] = new datatype[setNumber][testData];
		String[][] dynamicData = new String[3][6];// setName-3 --> 0,1,2 : testData--> 0,1,2,3

		// test data from the set no.0
		dynamicData[0][0] = "Testleaf";
		dynamicData[0][1] = "Bhuvanesh";
		dynamicData[0][2] = "Moorthy";
		dynamicData[0][3] = "AlocalName1";//FirstName (Local)
		dynamicData[0][4] = "dept1";//Department Field
		dynamicData[0][5] = "desc1";// Description Field

		// test data from the set no.1
		dynamicData[1][0] = "Qeagle";
		dynamicData[1][1] = "Seenivasan";
		dynamicData[1][2] = "Shanmugam";
		dynamicData[1][3] = "AlocalName2";//FirstName (Local)
		dynamicData[1][4] = "dept2";//Department Field
		dynamicData[1][5] = "desc2";// Description Field

		// test data from the set no.2
		dynamicData[2][0] = "TCS";
		dynamicData[2][1] = "Harrish";
		dynamicData[2][2] = "A";
		dynamicData[2][3] = "AlocalName3";//FirstName (Local)
		dynamicData[2][4] = "dept3";//Department Field
		dynamicData[2][5] = "desc3";// Description Field

		return dynamicData;
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
