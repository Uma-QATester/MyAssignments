package week3.marathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonAutomationMarathon {
	public static void main(String[] args) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("guest");
	ChromeDriver amDriver = new ChromeDriver(options);		
	//load the url with get method
	amDriver.get("https://www.amazon.in/");
	//Manage the window remotely with manage method
	amDriver.manage().window().maximize();
	amDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	amDriver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("Bags for boys");
	amDriver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();	
	String totalResult = amDriver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']")).getText();
	System.out.println("The total no.of results=" + totalResult);	
	//Select the first 2 brands in the left menu  (like American Tourister, Generic)
	amDriver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
	amDriver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
	//Choose New Arrivals (Sort)
	amDriver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
	amDriver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
	//	Print the first resulting bag info (name, discounted price)
	String firstResult=amDriver.findElement(By.xpath("//h2[contains(@class, 'a-size-base-plus a-spacing-none a-color-base a-text-normal')]")).getText();
	System.out.println("First Result = " + firstResult);	
	String firstResultPrice=amDriver.findElement(By.xpath("//span[contains(@class, 'a-price-whole')][1]")).getText();
	System.out.println("First Result Price= " + firstResultPrice);	
	//Get the page title and close the browser(driver.close())
	String Title = 	amDriver.getTitle();
	System.out.println("Page Title = " + Title);	
	amDriver.quit();
	}
	}

