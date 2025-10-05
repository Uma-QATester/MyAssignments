package week5.day1;

//*********Home Assignment <3>: Optimizing Test Case Structure with Annotations in TestNG********

//Preconditions and Post Conditions

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SalesForceLoginAutomation {

	public ChromeDriver driver;

	@Parameters({ "url", "uname", "pword" })
	@BeforeMethod
	public void preconditions(String url, String userName, String password) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// load the url with get method
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		WebDriverWait phoneRemind = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			WebElement remindMeLatterButton = phoneRemind.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Remind Me Later']")));
			remindMeLatterButton.click();
		    System.out.println("Clicked on Remind Me Later.");

		}
		catch (Exception e) {
		    System.out.println("No Remind Me Later pop-up this time.");
			}
		//driver.findElement(By.xpath("//a[text()='Remind Me Later']")).click();

	}

	public void openLegalEntities() throws InterruptedException {
		//Thread.sleep(2000);
		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(2000);
		// Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();

				
		By legalEntityLocator = By.xpath("//a[@data-label='Legal Entities']");

		WebDriverWait waitForLegalEntity = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement legalEntity = waitForLegalEntity.until(ExpectedConditions.elementToBeClickable(legalEntityLocator));

		Actions actions = new Actions(driver);
		actions.scrollToElement(legalEntity).perform();
		actions.click(legalEntity).perform();

		Thread.sleep(5000);

		// Click on New Legal Entity
		By NewButtonLocator = By.xpath("//a[@title='New']//div");
		
		WebDriverWait waitForNewButton = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement newEntity = waitForNewButton.until(ExpectedConditions.elementToBeClickable(NewButtonLocator));

		Actions actionsNew = new Actions(driver);
		actionsNew.moveToElement(newEntity).perform();
		actionsNew.click(newEntity).perform();


	}

	@AfterMethod
	public void postconditions() {
		driver.quit();
	}

}
