package week3.marathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CinemaAutomationMarathon {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();	
		options.addArguments("guest");
		ChromeDriver vueDriver = new ChromeDriver(options);	
//load the url with get method
		vueDriver.get("https://www.myvue.com/");
//Manage the window remotely with manage method
		vueDriver.manage().window().maximize();
//Add an implicit wait to ensure the web page elements are fully loaded 
		vueDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		vueDriver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
//Choose Your location 	
		vueDriver.findElement(By.xpath("(//span[@class='dropdown-opener__title-value'])[2]")).click();
		Thread.sleep(2000);
		vueDriver.findElement(By.xpath("(//li[@data-test='dropdown-item-Leeds The Light']//span[text()='Leeds The Light'])[2]")).click();
//Click on Cinema under Quick Book & Select Your Cinema		
		WebElement event = vueDriver.findElement(By.xpath("(//button[@data-test='dropdown-opener']//span[text()='Choose A Film or Event'])"));
		event.click();
		Thread.sleep(2000);
		vueDriver.findElement(By.xpath("//span[text()='The Roses']")).click();
// Select Your Date as Tomorrow
		WebElement date = vueDriver.findElement(By.xpath("(//button[@data-test='dropdown-opener']//span[text()='Choose A Date'])"));
		date.click();
		Thread.sleep(2000);
		vueDriver.findElement(By.xpath("//strong[text()='Tomorrow']")).click();
// Select Your Movie(its not there in VueCinema) so Select Show Time
		Thread.sleep(2000);
		WebElement time = vueDriver.findElement(By.xpath("//button[@data-test='dropdown-opener']//span[text()='Choose A Time']"));
		time.click();
		Thread.sleep(2000);
		vueDriver.findElement(By.xpath("//span[text()='13:10 - ']")).click();
//Click on Book Button 
		vueDriver.findElement(By.xpath("//div[@class='quick-book__button-box']")).click();
//Click Accept on Term and Condition-Not available in Vue // Click any one available seat
		Thread.sleep(5000);
		//WebElement seat= vueDriver.findElement(By.xpath("//button[@data-test='seat-10-5-9']"));
		WebElement seat= vueDriver.findElement(By.xpath("(//img[@src='https://www.myvue.com/-/media/global/img/seats/recliner_available.svg?rev=5df5aa6fb19647d38306f76c3eda746f'])[1]"));
		seat.click();
		Thread.sleep(2000);
//Click Proceed Button
		WebElement reviewAndPay = vueDriver.findElement(By.xpath("//button[@data-test='review-and-pay-button']"));
		reviewAndPay.click();
		Thread.sleep(2000);
		vueDriver.findElement(By.xpath("//input[@data-test='guest-email-input']")).sendKeys("uma.job969@gmail.com");
		reviewAndPay.click();
		WebElement guestLogin = vueDriver.findElement(By.xpath("(//button[text()='CONTINUE AS A GUEST'])[2]"));
		guestLogin.click();
		Thread.sleep(2000);
//Print the Seat info under book summary,Print the grand total under book summary 
		String seatInfo = vueDriver.findElement(By.xpath("//span[@class='ticket-info__name']")).getText();
		String seatInfoText = vueDriver.findElement(By.xpath("//dt[text()='Total:*']")).getText();
		String seatInfoPrice = vueDriver.findElement(By.xpath("//dd[text()='£7.99']")).getText();		
		System.out.println("Seat Info under book summary :" + seatInfo + " : " + seatInfoText + " - " + seatInfoPrice);
		String title = vueDriver.getTitle();
		System.out.println("Title :" + title);		
		vueDriver.quit();
	}
}
