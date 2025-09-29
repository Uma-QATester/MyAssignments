package week4.day2;
//********Classroom Assignment <1>: WebTable Interaction and Data Verification***********

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableAutomation {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("guest");

		ChromeDriver driver = new ChromeDriver(options);

// Manage the window remotely with manage method
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//load the url with get method
		driver.get("https://erail.in/");
		Thread.sleep(3000);

//Consent to cookies		
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		Thread.sleep(3000);

//Enter "MAS" as the "From" station. 		
		WebElement fromStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromStation.clear();
		fromStation.sendKeys("MAS");
		fromStation.sendKeys("\n"); // press Enter to accept suggestion
		Thread.sleep(1000);

//Enter "MDU" as the "To" station.			
		WebElement toStation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toStation.clear();
		toStation.sendKeys("MDU");
		toStation.sendKeys("\n"); // press Enter to accept suggestion
		Thread.sleep(1000);

//Uncheck the "Sort on Date"		
		WebElement sortDateChkBox = driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']"));
		sortDateChkBox.click();
		Thread.sleep(2000);

//Retrieve the train names from the web table.

		WebElement table = driver.findElement(By.xpath("//div[@id='divTrainsList']"));
		List<WebElement> trainNames = table.findElements(By.xpath("//div[@id='divTrainsList']//tr/td[2]"));
		System.out.println("Train Names : ");
		Set<String> uniqueNames = new HashSet<>();//A HashSet is a collection of elements where every element is unique
		boolean hasduplicate = false;
		for (WebElement names : trainNames) {
			String trainName = names.getText().trim();
			System.out.println(trainName);

			if (!uniqueNames.add(trainName)) {// uniqueNames.add(trainName) tries to add the name to the Set.
				// ie if adding failed, then it’s a duplicate.
				System.out.println("Duplicate found: " + trainName);
				hasduplicate = true;
			}
		}
			if (hasduplicate) {
				System.out.println("There are duplicate train names");
			} else {
				System.out.println("There aren't duplicate train names");

			}
			driver.quit();
		}
	}


