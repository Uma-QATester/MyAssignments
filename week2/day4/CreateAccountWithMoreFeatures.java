package week2.day4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountWithMoreFeatures {

	public static void main(String[] args) {
//Initialize the web driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver leafDriver = new ChromeDriver(options);
// load the url with get method
		leafDriver.get("http://leaftaps.com/opentaps/");
// Manage the window remotely with manage method
		leafDriver.manage().window().maximize();
// Enter a username and password.
		WebElement userName = leafDriver.findElement(By.name("USERNAME"));
		userName.sendKeys("demosalesmanager");
		WebElement pwdEnter = leafDriver.findElement(By.name("PASSWORD"));
		pwdEnter.sendKeys("crmsfa");
// Click the "Login" button.
		leafDriver.findElement(By.className("decorativeSubmit")).click();
// Click on the "CRM/SFA" link.
		leafDriver.findElement(By.partialLinkText("CRM")).click();
// Click on the "Accounts" tab.
		leafDriver.findElement(By.linkText("Accounts")).click();
// Click on the "Create Account" button.
		leafDriver.findElement(By.linkText("Create Account")).click();
		WebElement accName = leafDriver.findElement(By.id("accountName"));
		accName.sendKeys("ABCM");
		WebElement userDescription = leafDriver.findElement(By.name("description"));
		userDescription.sendKeys("Selenium Automation Tester");
//Select "ComputerSoftware" as the industry.
		WebElement selectDropdown = leafDriver.findElement(By.name("industryEnumId"));
		Select option = new Select(selectDropdown);
		option.selectByIndex(3);
// Select "S-Corporation" as ownership using SelectByVisibleText.
		WebElement selectOwnershipDropdown = leafDriver.findElement(By.name("ownershipEnumId"));
		Select option1 = new Select(selectOwnershipDropdown);
		option1.selectByVisibleText("S-Corporation");
//Select "Employee" as the source using SelectByValue.
		WebElement selectSourceDropdown = leafDriver.findElement(By.name("dataSourceId"));
		Select option2 = new Select(selectSourceDropdown);
		option2.selectByValue("LEAD_EMPLOYEE");
//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.
		WebElement selectmktgDropdown = leafDriver.findElement(By.id("marketingCampaignId"));
		Select option3 = new Select(selectmktgDropdown);
		option3.selectByIndex(6);
// Select "Texas" as the state/province using SelectByValue. 
		WebElement selectStateDropdown = leafDriver.findElement(By.name("generalStateProvinceGeoId"));
		Select option4 = new Select(selectStateDropdown);
		option4.selectByValue("TX");
// Click the "Create Account" button
		leafDriver.findElement(By.className("smallSubmit")).click();
// Verify that the Title is displayed correctly.
		String actualTitle = leafDriver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = ("Create Account | opentaps CRM");
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title displays correctly as : " + actualTitle);
		}
// step 10:close the browser
		leafDriver.close();

	}

}
