package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectOptionsDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize the web driver
				ChromeOptions options = new ChromeOptions();
				options.addArguments("guest");
				ChromeDriver leafleadDriver = new ChromeDriver(options);		
				//load the url with get method
				leafleadDriver.get("http://leaftaps.com/opentaps/");
				//Manage the window remotely with manage method
				leafleadDriver.manage().window().maximize();
				//Enter a username and password. 
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
				/*
				 * Enter a FirstName. - Enter a LastName. 
				 * - Enter a CompanyName. - Enter a Title
				 */
				WebElement firstName = leafleadDriver.findElement(By.id("createLeadForm_firstName"));
				firstName.sendKeys("First Name Testing");
				WebElement lastName = leafleadDriver.findElement(By.id("createLeadForm_lastName"));
				lastName.sendKeys("Last Name Testing");
				WebElement compName = leafleadDriver.findElement(By.id("createLeadForm_companyName"));
				compName.sendKeys("Company Name ABC");
				WebElement title = leafleadDriver.findElement(By.id("createLeadForm_generalProfTitle"));
				title.sendKeys("ABC Selenium Testing");
			
				//Enter the mandatory fields
				//step 9 : identify the element & instantiate the select class WebElement
				 WebElement selectDropdown = leafleadDriver.findElement(By.id("createLeadForm_dataSourceId"));
				 Select option = new Select(selectDropdown);			
				 option.selectByIndex(4);
				 WebElement makettingCampaign = leafleadDriver.findElement(By.id("createLeadForm_marketingCampaignId"));
				 Select option2 = new Select(makettingCampaign);
				 option2.selectByVisibleText("Automobile");
				 WebElement selectOwnershipDropdown = leafleadDriver.findElement(By.id("createLeadForm_ownershipEnumId"));
				 Select option1 = new Select(selectOwnershipDropdown);
				 option1.selectByValue("OWN_CCORP");
				//Click the "Create Lead" button
				 leafleadDriver.findElement(By.className("smallSubmit")).click();
				 //Verify that the Title is displayed correctly.
				 String actualTitle = leafleadDriver.getTitle();
				 //System.out.println(actualTitle);
				 String expectedTitle = ("View Lead | opentaps CRM");
				 if(actualTitle.equals(expectedTitle)) {
					 System.out.println("Title displays correctly as : " + actualTitle); 
					 }
					 
					//step 10:close the browser
					leafleadDriver.close();
					
				 
				 
				 
				
	}

}
