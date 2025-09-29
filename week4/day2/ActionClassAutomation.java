package week4.day2;
//**********Classroom Assignment : Automation using Actions Class in Selenium******

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class ActionClassAutomation {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver amDriver = new ChromeDriver(options);
		// load the url with get method
		amDriver.get("https://www.amazon.in/");
		// Manage the window remotely with manage method
		amDriver.manage().window().maximize();
		amDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions act = new Actions(amDriver);
		act.scrollToElement(amDriver.findElement(By.xpath("//a[text()='Conditions of Use & Sale']")))
				.pause(Duration.ofSeconds(3)).perform();
		String text = amDriver.findElement(By.xpath("//a[text()='Conditions of Use & Sale']")).getText();
		System.out.println("Resulting Text =" + text);
		amDriver.close();

		

	}

}
