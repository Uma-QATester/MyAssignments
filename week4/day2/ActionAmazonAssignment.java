package week4.day2;

//*********Home Assignment : Automation using Actions Class in Selenium****
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class ActionAmazonAssignment {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver amDriver = new ChromeDriver(options);
		
//1.load the url with get method
		amDriver.get("https://www.amazon.in/");
		
// Manage the window remotely with manage method
		amDriver.manage().window().maximize();
		amDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
// 2. Search for "oneplus 9 pro".		
		Actions act = new Actions(amDriver);
		act.moveToElement(amDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click()
				.sendKeys("oneplus 9 pro").pause(Duration.ofSeconds(3)).perform();
		act.moveToElement(amDriver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"))).click()
				.perform();
		
// 3. Get the price of the first product.
		act.moveToElement(amDriver.findElement(By.xpath("(//span[@class='rush-component'])[4]"))).perform();
		String FirstProductPrice = amDriver.findElement(By.xpath("(//span[@class='a-price-whole'])[4]")).getText();
		String productPriceNumber = FirstProductPrice.replaceAll("[₹,]", ""); 
		System.out.println("Price of First Product -> " + productPriceNumber);
		
//4. Print the number of customer ratings for the first displayed product.
		String Ratings = amDriver.findElement(By.xpath("(//a[@target='_blank'])[3]")).getText();
		System.out.println("Customer Ratings of First Product -> " + Ratings);
		
//5. Click the first text link of the first image. 		
		act.moveToElement(amDriver.findElement(By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]"))).click()
				.perform();
		Thread.sleep(2000);
		Set<String> windowHandles = amDriver.getWindowHandles();
		System.out.println("Window handler id of currently opened- Parent  window =  " + windowHandles);
		
//convert set to list
		List<String> listOfWindowId = new ArrayList<String>(windowHandles);
		String childWindow = listOfWindowId.get(1);
		
// retrieve the particular window id pass it as argument within window(_)
		amDriver.switchTo().window(childWindow);
		System.out.println("Child Window Title = " + amDriver.getTitle());
		
//6. Take a screenshot of the product displayed. 
//7.Click the 'Add to Cart' button. 		
		act.moveToElement(amDriver.findElement(By.xpath("//input[@id='add-to-cart-button']"))).click().perform();
		Thread.sleep(2000);

//Go to the cart,Get the cart subtotal and verify if it is correct. 		
		act.moveToElement(amDriver.findElement(By.id("sw-gtc"))).click().perform();
		String subTotal = amDriver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")).getText();
		String cartSubtotalNumber = subTotal.replaceAll("[₹,]", "").split("\\.")[0];
		//removes ₹ and commas, splits on the decimal point. [0] takes only the integer part.
		
		System.out.println(" The Price on Cart = "+ cartSubtotalNumber);

		if (cartSubtotalNumber.equals(productPriceNumber)) {
			System.out.println("Price Match Verified in Cart");
		} else {
			System.out.println("Price is not matching, Product MisMatch as Product refreshed");
		}
		amDriver.quit();
	}

}
