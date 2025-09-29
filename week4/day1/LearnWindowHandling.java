package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");	
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Search for phones and click	
		driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("phones");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window handler id is "+ parentWindow);
//clicking the first result image to get the child window
		driver.findElement(By.xpath("(//span[@class='rush-component'])[4]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window handler id of currently opened window: " + windowHandles);
//convert set to list
		List<String> listOfWindowId = new ArrayList<String>(windowHandles);
		String childWindow = listOfWindowId.get(1);
// retrieve the particular window id pass it as argument within window(_)
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.close();
}

}
