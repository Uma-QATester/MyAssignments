package week3.day4;
//*****Classroom Assignment <5>: Automating Frame and Alert Interactions with Text Verification****
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomatingFrameAndAlertInteractions {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[text()='Accept all & visit the site']")).click();				
		driver.switchTo().frame("iframeResult");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));	
//Click the "Try It" button inside the frame 
		WebElement tryitButton =driver.findElement(By.xpath("//button[text()='Try it']"));
	    tryitButton.click();
// Click OK/Cancel in the alert that appears 	    
	    driver.switchTo().alert().accept();
	    String resultingText=driver.findElement(By.xpath("//p[@id='demo']")).getText();
	    String expectedAlert = "You pressed OK!";
	    // Confirm the action is performed correctly by verifying the text displayed		
		if(resultingText.equalsIgnoreCase(expectedAlert)) {
			System.out.println("Alert matched");}
		else {
			System.out.println("Alert Mis-matched");}
		driver.quit();
		}
	}
	