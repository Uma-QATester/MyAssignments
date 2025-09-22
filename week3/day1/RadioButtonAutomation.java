package week3.day1;
//*******Classroom Assignment <5>: Demonstrating Radio Button in Selenium**********	
/*Select 'Your most favourite browser' from the radio buttons 
 * - Click on a radio button, then click on the same radio button again to verify that it becomes ‘unselected’. 
 * - Identify the radio button that is initially selected by default. 
 * - Check and select the age group (21-40 Years) if not already selected.
*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButtonAutomation {
	
	public static void main(String[] args) {
	/*
	 * Launch the Browser and Load the URL https://www.leafground.com/radio.xhtml. -
	 * Add the ImplicityWait - Maximize the browser window.
	 */
	ChromeOptions options = new ChromeOptions();
	options.addArguments("guest");
	ChromeDriver lgrDriver = new ChromeDriver(options);	
//load the url with get method
	lgrDriver.get("https://www.leafground.com/radio.xhtml");
//Manage the window remotely with manage method
	lgrDriver.manage().window().maximize();
//Add an implicit wait to ensure the web page elements are fully loaded 
	lgrDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	/*
	 * Select 'Your most favourite browser' from the radio buttons - Click on a radio button,
	 * then click on the same radio button again to verify that it becomes ‘unselected’. 
	 * - Identify the radio button that is initially selected by default. 
	 * - Check and select the age group (21-40 Years) if not already selected.
	 */	
	WebElement favBrowser = lgrDriver.findElement(By.xpath("//label[text()='Chrome'][1]"));
	favBrowser.click();
	 System.out.println("Selected favourite browser: Chrome");
	favBrowser.click();
	if(favBrowser.isSelected())  {
		System.out.println("the radio button is already selected");
	}
	else {
		  System.out.println("Radio button became unselected.");
	}
	WebElement selectedBrowserLabel = lgrDriver.findElement(By.xpath("//label[@for='j_idt87:console2:2']"));
		
	System.out.println("Default selected browser is: " + selectedBrowserLabel.getText());
	
	WebElement defAge = lgrDriver.findElement(By.xpath("//label[text()='21-40 Years']"));
	
	if(defAge.isSelected()) {
		defAge.click();
		System.out.println("Age group 21-40 selected.");}
	else{
		System.out.println("Age group 21-40 was already selected.");	
	}
}
}
