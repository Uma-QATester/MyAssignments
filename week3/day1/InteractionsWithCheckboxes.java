package week3.day1;
//*********Home Assignment <4>: Interactions with Checkboxes*****
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class InteractionsWithCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
//Initialize ChromeDriver
	ChromeOptions options = new ChromeOptions();
	options.addArguments("guest");
	ChromeDriver chromelg = new ChromeDriver(options);	
//Load the URL https://leafground.com/checkbox.xhtml
	chromelg.get("https://leafground.com/checkbox.xhtml");
//Maximize the browser window - Add an implicit wait to ensure the web page elements are fully loaded
	chromelg.manage().window().maximize();
	chromelg.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	
//Click on the Basic Checkbox.
	  chromelg.findElement(By.xpath("//span[text()='Basic']")).click();
	  
//Click on the "Notification Checkbox.and Verify that the expected message is displayed.
      WebElement notificationCheckBox = chromelg.findElement(By.xpath("//span[text()='Ajax']"));
//notificationCheckBox.click();
//syntax for Younger sibling-Elder sibling://[(xpath of Y.S/preceding-sibling::label=for label , if E.S has a child access the E.S with the name of the child 
      boolean notificationStatus = chromelg.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div/input")).isSelected();
	  Thread.sleep(100);
	  System.out.println("Is notification is selected? " + notificationStatus);//should be false	  
	  if(!notificationStatus) {//if not false
		  notificationCheckBox.click();
		  Thread.sleep(1000);
		  boolean newNotificaitionStatus= chromelg.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div/input")).isSelected();
		  System.out.println("Is notification is displayed? =" +newNotificaitionStatus);
		  Thread.sleep(500);
	  }
	  
// Click on your favorite language (assuming it's related to checkboxes).
	  chromelg.findElement(By.xpath("//label[text()='Javascript']")).click();
	  
//Click on the "Tri-State Checkbox." Verify which tri-state option has been chosen. */	  
	  WebElement triColorCheckBox = chromelg.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']//div[contains(@class,'ui-chkbox-box')]"));
      boolean checkColorBefore = chromelg.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']//input")).isSelected();
      System.out.println("Tri-State selected before click? " + checkColorBefore);

      if (!checkColorBefore) {
          triColorCheckBox.click();
          Thread.sleep(1000);
          boolean checkColorAfter = chromelg.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']//input")).isSelected();//grand parent-child
          System.out.println("Tri-State selected after click? " + checkColorAfter);
      }
//Click on the "Toggle Switch." - Verify that the expected message is displayed.
      chromelg.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
      boolean toggle = chromelg.findElement(By.xpath("//input[@id='j_idt87:j_idt100_input']")).isSelected();
      System.out.println("Toggle switch selected? " + toggle);
	chromelg.quit();	
}
}
