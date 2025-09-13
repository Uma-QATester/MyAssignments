package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
//Initialize the web driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver leafleadDriver = new ChromeDriver(options);		
//load the url with get method
		leafleadDriver.get("http://leaftaps.com/opentaps/");
//Manage the window remotely with manage method
		leafleadDriver.manage().window().maximize();
//Enter the Username as "DemoSalesManager" and the Password as "crmsfa". 
		WebElement userName = leafleadDriver.findElement(By.name("USERNAME"));		
		userName.sendKeys("demosalesmanager");
		WebElement pwdEnter = leafleadDriver.findElement(By.name("PASSWORD"));
		pwdEnter.sendKeys("crmsfa");
//Click the "Login" button.
		leafleadDriver.findElement(By.className("decorativeSubmit")).click();
//Click on the "CRM/SFA" link.
		leafleadDriver.findElement(By.partialLinkText("CRM")).click();				
//Click on the "Leads" tab and Click on the "Create Lead" button.
		leafleadDriver.findElement(By.linkText("Leads")).click();
		leafleadDriver.findElement(By.linkText("Create Lead")).click();
// Enter the CompanyName Field Using Xpath.
		leafleadDriver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("XAAXX");	
//Enter the FirstName Field Using Xpath. and  Enter the LastName Field Using Xpath. 
		leafleadDriver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("A11");
		leafleadDriver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Z11");
//Enter the FirstName (Local) Field Using Xpath.		
		leafleadDriver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("ALocalFirstName1");
//Enter the Department Field Using any Locator of Your Choice. 
		leafleadDriver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("SWDept1");
		Thread.sleep(2000);	
// Enter the Description Field Using any Locator of your choice. 		
		leafleadDriver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("SWDept1-Software Testing Department-1");
//Enter your email in the E-mail address Field using the locator of your choice. 	
		leafleadDriver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("SWDept1@testleaf.com");	
//Select State/Province as NewYork Using Visible Text. 	
		WebElement selectDropdown = leafleadDriver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select option = new Select(selectDropdown);
		// selectByVisibleText()
		option.selectByVisibleText("New York");
// Click on the Create Button. * Click on the edit button.
		leafleadDriver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		leafleadDriver.findElement(By.xpath("//a[text()='Edit']")).click();
// Clear the Description Field.
		leafleadDriver.findElement(By.name("description")).clear();
//Fill the Important Note Field with Any text.
		leafleadDriver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("SWDept1-Important Note field");
// Click on the update button. 
		leafleadDriver.findElement(By.xpath("//input[@value='Update']")).click();
//Get the Title of the Resulting Page. 		
		String actualTitle = leafleadDriver.getTitle();
		System.out.println("Resulting Page Title :" + actualTitle);
// Close the browser window.
		leafleadDriver.close();		
}
}
