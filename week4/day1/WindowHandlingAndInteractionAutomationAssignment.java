package week4.day1;
//********Home Assignment : Window Handling and Interaction Automation***********

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingAndInteractionAutomationAssignment {

	public static void main(String[] args) throws InterruptedException {
		
//Initialize ChromeDriver - Load the URL - Maximize the browser window -Add an implicit wait to ensure the webpage elements are fully loaded
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Enter the username and password.
		WebElement userName = driver.findElement(By.name("USERNAME"));
		userName.sendKeys("demosalesmanager");
		WebElement pwdEnter = driver.findElement(By.name("PASSWORD"));
		pwdEnter.sendKeys("crmsfa");
//Click the "Login" button.
		driver.findElement(By.className("decorativeSubmit")).click();
// Click on the "CRM/SFA" link.
		driver.findElement(By.partialLinkText("CRM")).click();
// Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
// Click on Merge Contacts.		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
//Click on the widget of the "From Contact".- This opens a new window, here we have to use the window handle option		
		driver.findElement(By.xpath(" (//img[@alt='Lookup'])[1]")).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window handler id is = " + parentWindow);
		System.out.println("Title of Parent Window is = " + driver.getTitle());
// Switch to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listOfWindowId = new ArrayList<String>(windowHandles);
		String childWindow = listOfWindowId.get(1);
		// retrieve the particular window id pass it as argument within window(_)
		driver.switchTo().window(childWindow);
		System.out.println("From Contact-Child Window handler id is = " + childWindow);
		System.out.println("Title of From Contact- Child Window is = " + driver.getTitle());
		
//Click on the first resulting contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
//Click on the widget of the "To Contact".- This opens a new window, here we have to use the window handle option		
		driver.switchTo().window(parentWindow);//switch to parent window to perform the click on To Contacts widget
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
//switch to new child window
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listOfWindowId1 = new ArrayList<String>(windowHandles1);
        Thread.sleep(2000);
		String childWindow1 = listOfWindowId1.get(1);
// retrieve the particular window id pass it as argument within window(_)
		driver.switchTo().window(childWindow1);
		System.out.println("To contact - Child Window handler id is = " + childWindow1);
		System.out.println("Title of To contact - Child Window is = " + driver.getTitle());
		Thread.sleep(2000);
//Click on the second resulting contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
//Click on the Merge button.
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
// Switch to the alert and type a message in the alert box. 
        Alert alert = driver.switchTo().alert();
        Thread.sleep(4000);
        alert.accept();
//Verify the title of the page.
        String ExpectedTitleAfterMerge = "View Contact | opentaps CRM";
        String ActualTitleAfterMerge = driver.getTitle();
        if(ExpectedTitleAfterMerge.equals(ActualTitleAfterMerge)) {
        	 System.out.println("***Verified the Title of Page***");
        }
        Thread.sleep(2000);
        
//Close all windows        
		driver.quit();
		  
		  }

}
