package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize the web driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver leafDriver = new ChromeDriver(options);		
		//load the url with get method
		leafDriver.get("http://leaftaps.com/opentaps/");
		//Manage the window remotely with manage method
		leafDriver.manage().window().maximize();
		//Enter a username and password. 
		WebElement userName = leafDriver.findElement(By.name("USERNAME"));
		userName.sendKeys("demosalesmanager");
		WebElement pwdEnter = leafDriver.findElement(By.name("PASSWORD"));
		pwdEnter.sendKeys("crmsfa");
		//Click the "Login" button.
		leafDriver.findElement(By.className("decorativeSubmit")).click();
		//Click on the "CRM/SFA" link.
		leafDriver.findElement(By.partialLinkText("CRM")).click();
		//Click on the "Accounts" tab.
		leafDriver.findElement(By.linkText("Accounts")).click();
		//Click on the "Create Account" button.
		leafDriver.findElement(By.linkText("Create Account")).click();
		/*
		 * Enter an account name. * Enter a description as "Selenium Automation Tester." 
		 * Enter a Number Of Employees. * Enter a Site Name as “LeafTaps”
		 */		
		WebElement accName = leafDriver.findElement(By.id("accountName"));
		accName.sendKeys("ABCM");
		WebElement userDescription = leafDriver.findElement(By.name("description"));
		userDescription.sendKeys("Selenium Automation Tester");
		WebElement numofEmployee = leafDriver.findElement(By.id("numberEmployees"));
		numofEmployee.sendKeys("666");
		WebElement siteName = leafDriver.findElement(By.id("officeSiteName"));
		siteName.sendKeys("LeafTaps");
		//Click the "Create Account" button
		leafDriver.findElement(By.className("smallSubmit")).click();
		//Verify that the Title is displayed correctly.
		String actualTitle = leafDriver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = ("Create Account | opentaps CRM");
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title displays correctly as : " + actualTitle);			
		}
		//step 10:close the browser
		//browser.close();
	}

}
