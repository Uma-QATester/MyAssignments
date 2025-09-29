package week4.day2;
//*****Hint for Assignment <1>: WebTable********

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YahooFinanceAutomation {
	

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);

// Manage the window remotely with manage method
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//load the url with get method
		driver.get("https://finance.yahoo.com/");
		Thread.sleep(3000);
		
//Reject Cookies
		driver.findElement(By.xpath("//button[@name='reject']")).click();
		
//CLick on Crypto		
		WebElement markets = driver.findElement(By.xpath("//span[text()='Markets']"));
		markets.click();
		Thread.sleep(2000);
		WebElement crptoc = driver.findElement(By.xpath("(//div[text()='Crypto'])[2]"));
		crptoc.click();
		Thread.sleep(2000);
		
// Locate the table in the dom page 
		WebElement table = driver.findElement(By.xpath("//div[contains(@class, 'table-container')]"));
		List<WebElement> cryptoName = table.findElements(By.xpath("//div[contains(@class, 'table-container')]//tr/td[2]"));
		System.out.println("CRYTOCURRENCY NAMES :->");
		for(WebElement names : cryptoName) {
			String crNames = names.getText().trim();
			System.out.println(crNames);
		}
		
		
driver.quit();
	}

}
