package week3.day4;
import java.time.Duration;
//*********Classroom Assignment : Automating Alert Interactions**********
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AlertAutomation {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver lgDriver = new ChromeDriver(options);		
		//load the url with get method
		lgDriver.get("https://www.leafground.com/alert.xhtml");
		//Manage the window remotely with manage method and add implicit wait
		lgDriver.manage().window().maximize();
		lgDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on the "Prompt Box" button to trigger the alert.
		lgDriver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
		
		// Switch to the alert and type a message in the alert box. 
        Alert alert = lgDriver.switchTo().alert();
        alert.sendKeys("Hello");
        Thread.sleep(4000);
        //Dismiss the alert.
        alert.dismiss();
        //Retrieve the typed text from the alert and verify it.
	        
        System.out.println(lgDriver.findElement(By.id("confirm_result")).getText());
        
        lgDriver.quit();       
	}

}
