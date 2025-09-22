package week3.day1;
//*********Home Assignment <3>: Leafground Button Interaction**************
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafgroundButtonInteraction {

	public static void main(String[] args) {
//Initialize ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver chromelg = new ChromeDriver(options);	
//Load the URL https://leafground.com/checkbox.xhtml
		chromelg.get("https://leafground.com/button.xhtml");
//Maximize the browser window - Add an implicit wait to ensure the web page elements are fully loaded
		chromelg.manage().window().maximize();
		chromelg.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
//Click on the button with the text ‘Click and Confirm title.’
		chromelg.findElement(By.xpath("//span[text()='Click']")).click();
//- Verify that the title of the page is ‘dashboard.’
	    String title = chromelg.getTitle();
	    System.out.println("The Actual Title after getTitle()-" + title);
	    String expectedTitle = "Dashboard";	
	    if(title.equals(expectedTitle)) {
	    	System.out.println("The Title of the webpage is-" + title );
	    	System.out.println("Title Matched");
	    }
	    else {
	    	System.out.println("Title Mismatch");
	    }
//Navigate back to previous page from Dashboard	    
	    chromelg.navigate().back();
//Check if the button with the text ‘Confirm if the button is disabled’ is disabled.
	    WebElement disabledButtonCheck = chromelg.findElement(By.xpath("//span[text()='Disabled']/parent::button"));
	    boolean disButtonCheck = disabledButtonCheck.isEnabled();
	    if(!disButtonCheck) {
	    	System.out.println("The Button is confirmed as disabled");
	    }else {
	        System.out.println("The Button is enabled");}
//Find and print the position of the button with the text ‘Submit.’	    
	    WebElement submitButtonPosition = chromelg.findElement(By.xpath("//span[text()='Submit']/parent::button"));
	    Point p = submitButtonPosition.getLocation();
	    System.out.println("The position in X , Y of text 'Submit' is :" + "X:" + p.getX() + "," + "Y:" + p.getY());
//Find and print the background color of the button with the text ‘Find the Save button color.’	    
	    WebElement saveButtonColor = chromelg.findElement(By.xpath("//span[text()='Save']/parent::button"));
	    String bgColor = saveButtonColor.getCssValue("background-color");//getCssValue() fetches the actual style the browser is using, the browser calculates it from CSS rules and Selenium can read it.
	    System.out.println("The Save button background color is : " + bgColor);//This color comes from the CSS class applied to the button (ui-button, etc.), not from the HTML itself
//Find and print the height and width of the button with the text ‘Find the height and width of this button.’	    
	    WebElement submitButtonHW = chromelg.findElement(By.xpath("//span[text()='Submit']/parent::button"));
	    Dimension size = submitButtonHW.getSize();
	    System.out.println("The height and weight of Submit button is :" + " Height= " + size.getHeight() + "," + " Width= " +  size.getWidth());	
//Close the browser window.
	    chromelg.close();  
		
	}
}


