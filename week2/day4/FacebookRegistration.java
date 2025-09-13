package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FacebookRegistration {

	public static void main(String[] args) throws InterruptedException {
//Initialize the web driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver fbDriver = new ChromeDriver(options);	
//load the url with get method
		fbDriver.get("https://en-gb.facebook.com//");
//Manage the window remotely with manage method
		fbDriver.manage().window().maximize();
//Add an implicit wait to ensure the web page elements are fully loaded 
		fbDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		 Thread.sleep(5000);
//Click on the Create new account button. 
		fbDriver.findElement(By.xpath("//a[text()='Create new account']")).click();
//Enter the First name. * Enter the Surname.
		fbDriver.findElement(By.name("firstname")).sendKeys("FirstName.xy");
		fbDriver.findElement(By.name("lastname")).sendKeys("SurName.xy");
// Enter the New password. 
		fbDriver.findElement(By.id("password_step_input")).sendKeys("12XY34xy");
//Handle all three dropdowns in Date of birth 
//Day
		WebElement selectDropdownDay = fbDriver.findElement(By.name("birthday_day"));
		Select day = new Select(selectDropdownDay);		
		day.selectByVisibleText("1");
		Thread.sleep(500); // tiny pause to ensure selection is applied
//Month
		WebElement selectDropdownMonth = fbDriver.findElement(By.name("birthday_month"));
		Select month = new Select(selectDropdownMonth);
		month.selectByIndex(0);
		Thread.sleep(500); // tiny pause to ensure selection is applied
//Year
		WebElement selectDropdownYear = fbDriver.findElement(By.name("birthday_year"));
		Select year = new Select(selectDropdownYear);
		year.selectByValue("1905");
		Thread.sleep(500); // tiny pause to ensure selection is applied			
//Print the Date of Birth by using String get.Text()		
		String  selectedday =day.getFirstSelectedOption().getText();
		String  selectedmonth =month.getFirstSelectedOption().getText();
		String  selectedyear =year.getFirstSelectedOption().getText();
		System.out.println("The Date of Birth :" + selectedday +"/" + selectedmonth + "/" + selectedyear);
//Select the radio button in Gender.
		fbDriver.findElement(By.xpath("//input[@value='1']")).click();
		Thread.sleep(500); // tiny pause to ensure selection is applied
	}
		
	}


