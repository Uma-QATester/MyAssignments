package week3.day4;
//******Home Assignment <5>: Implementing List Interface*************

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AjioListInterface {

	public static void main(String[] args) throws InterruptedException {
		
//Launch the URL https://www.ajio.com/	- Access denied outside India so used Asos.com	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver asosdriver = new ChromeDriver(options);
		asosdriver.get("https://www.asos.com/");	
		Thread.sleep(2000);
		asosdriver.manage().window().maximize();
		asosdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Accept 'Only Required' cookies		
		asosdriver.findElement(By.xpath("//button[text()='Only required']")).click();
//In the search box, type as "bags" and press enter 		
		asosdriver.findElement(By.xpath("//input[@id='chrome-search']")).sendKeys("Bags");
		asosdriver.findElement(By.xpath("//button[@data-testid='search-button-inline']")).click();
		Thread.sleep(2000);
//	Select the Gender as Male
		// Click "Gender" filter
		asosdriver.findElement(By.xpath("//div[contains(text(),'Gender')]")).click();
		Thread.sleep(1000);
		// Select "Men" from the dropdown
		asosdriver.findElement(By.xpath("//div[contains(text(),'Men')]")).click();
		Thread.sleep(2000);
		// Click "Product Type" filter
		asosdriver.findElement(By.xpath("//div[contains(text(),'Product Type')]")).click();
		Thread.sleep(1000);
		// Select "Backpacks"
		asosdriver.findElement(By.xpath("//div[contains(text(),'Backpacks')]")).click();
		Thread.sleep(2000);
		String countOfBackPacks = asosdriver.findElement(By.xpath("(//div[@class='value_hLBn8'])[2]")).getText();
		System.out.println("The total count of the items found= " + countOfBackPacks);
		// Get list of brands
        //List<WebElement> brands = asosdriver.findElements(By.xpath("//ul[contains(@data-testid,'results-1')]//li[contains(@class,'productTile_')]//h2"));
		List<WebElement> brands = asosdriver.findElements(By.xpath("//div[@class='productInfo_rwyH5']/h2"));
		System.out.println("\nBrands:");
		System.out.println("Brands on this page: " );
		 for (WebElement b : brands) {
			    System.out.println(b.getText());
			}
		}
}
