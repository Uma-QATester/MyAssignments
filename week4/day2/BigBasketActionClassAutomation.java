package week4.day2;
//************Home Assignment <3>: Automation using Actions Class in Selenium********

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class BigBasketActionClassAutomation {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);		
//load the url with get method
		driver.get("https://desicart.co.uk/");//for UK
		
//Manage the window remotely with manage method
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
//Decline Cookies
		driver.findElement(By.xpath(("//button[text()='Decline']"))).click() ;
		Thread.sleep(2000);

//Mouse Over Food and Grains Category ".		
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//span[contains(text(),'Rice, Grains & Cereals')]")).click();
		Thread.sleep(2000);

//Filter the results by selecting the Category	
		act.moveToElement(driver.findElement(By.xpath("//*[text()='Category']"))).click().perform();//*-matches any element
		
//Click on "Tamil Ponni Boiled Rice".		
		driver.findElement(By.xpath("//label[text()='Ponni Boiled/ Raw Rice (8)']")).click();
		Thread.sleep(1000);

//Check and get the price of 5 Kg bag.
		String Price = driver.findElement(By.xpath("(//a[contains(.,'PONNI BOILED RICE')]/following::span[@class='price'])[3]")).getText();
		System.out.println("Price of Rice = " + Price);
		
//Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[4]")).click();
		
//Verify the success message that confirms the item was added to your cart.
		driver.findElement(By.xpath("//a[text()='View cart']")).click();
		
//Take a snapshot of the current page
		String TitleofCartPage = driver.getTitle();
		// Step 1 : stored the temporary file as a local variable
		File src = driver.getScreenshotAs(OutputType.FILE);
		// Step 2 : we have created the folder and file name along with the file format 
		File target = new File("./snap/cart.png");
		// step 3 : transfer the data from the temp to physical file
		FileUtils.copyFile(src, target);
		System.out.println("Title of Cart Page = " + TitleofCartPage);
		
//Close Windows
		driver.close(); // closes current window
		driver.quit();
		
	}

}
