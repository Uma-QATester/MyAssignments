package week4.day3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class LearnTestNG{
	@Test
	public void runTest() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("guest");
	ChromeDriver leafDriver = new ChromeDriver(options);		
	//load the url with get method
	leafDriver.get("http://leaftaps.com/opentaps/");
	//Manage the window remotely with manage method
	leafDriver.manage().window().maximize();
	

}
}