package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
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
		leafleadDriver.findElement(By.linkText("Find Leads")).click();
//Click on the "Phone" tab. - Enter the phone number.
        leafleadDriver.findElement(By.xpath("//span[text()='Phone']")).click();
        //leafleadDriver.findElement(By.name("phoneAreaCode")).sendKeys("1");
        leafleadDriver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
//Click the "Find leads" button. 
		leafleadDriver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//Capture the lead ID of the first resulting lead.
		String idd = leafleadDriver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		System.out.println("Captured Lead ID: " + idd);
//Click the first resulting lead.
		leafleadDriver.findElement(By.xpath("//a[text()='" + idd + "']")).click();
		String retrievedid = String.valueOf(idd);
 // Click the "Delete" button.
		leafleadDriver.findElement(By.linkText("Delete")).click();
//Click "Find leads" again
		leafleadDriver.findElement(By.linkText("Find Leads")).click();
//Enter the captured lead ID
		leafleadDriver.findElement(By.xpath("//input[@name='id']")).sendKeys(retrievedid);
//Click the "Find leads" button.
	 	leafleadDriver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	 	Thread.sleep(2000);
// Verify the presence of the message "No records to display" in the Lead List. This message confirms the successful deletion.
	    String actualtitle=leafleadDriver.findElement(By.xpath(("//div[text()='No records to display']"))).getText();
	    System.out.println(actualtitle);
	 	String expectedTitle = ("No records to display");
		if (actualtitle.equals(expectedTitle)) {
			System.out.println("Successfully deleted the Captured Lead ID :" + idd );
		}
		else
		{
			System.out.println("Deletion failed, the Captured Lead ID still exists");	
		}
// Close the browser
		leafleadDriver.close();
	 }

}
