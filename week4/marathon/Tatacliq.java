package week4.marathon;
//***************Marathon - Tatacliq*********
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

 
public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
// load the url with get method
		driver.get("https://www.tatacliq.com/");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[text()='Brands']"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("//div[text()='Watches & Accessories']"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("//div[text()='Casio']"))).click().perform();

		WebElement dropOptions = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select select = new Select(dropOptions);
		select.selectByVisibleText("New Arrivals");
		Thread.sleep(3000);

// Choose Category Men
		driver.findElement(By.xpath("//div[text()='Men']")).click();
		Thread.sleep(3000);

// print all price of watches

		List<WebElement> phonecosts = driver
				.findElements(By.xpath("//div[contains(@class, 'ProductDescription__priceHolder')]//h3"));
		List<Integer> prices = new ArrayList<>();
		for (WebElement string : phonecosts) {
			String pricelist = string.getText();
			pricelist = pricelist.replaceAll("[^0-9]", "");
			int pricess = Integer.parseInt(pricelist);
			prices.add(pricess);
		}

		System.out.println("List of Phone Prices=" + prices);
		Thread.sleep(2000);

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window handler id is = " + parentWindow);
		System.out.println("Parent Window Title is = " + driver.getTitle());

// click on the first resulting watch.
		WebElement firstPdt = driver.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])[1]"));
		firstPdt.click();
		Thread.sleep(3000);

		// switch to child window
		Set<String> windowHandles = driver.getWindowHandles();
		// convert set to list
		List<String> listOfWindowId = new ArrayList<String>(windowHandles);
		String childWindow = listOfWindowId.get(1);

		// retrieve the particular window id pass it as argument within window(_)
		driver.switchTo().window(childWindow);
		System.out.println("Child Window Title is = " + driver.getTitle());
		Thread.sleep(2000);
		
// Handle Alert Pop Up - No Alert Appeared 
//compare two price are similar		
		
		String itemPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		String price1= itemPrice.replaceAll("[^0-9]", "");
		System.out.println("Price of First Pdt in Child Window = " +price1);
		driver.switchTo().window(parentWindow);
			
		String itemPrice1 = driver.findElement(By.xpath("(//div[contains(@class, 'ProductDescription__priceHolder')]//h3)[1]")).getText();
		String price2 = itemPrice1.replaceAll("[^0-9]", "");
		System.out.println("Price of First Pdt in Parent Window = " + price2);
		
		if(price1.equals(price2)) {
			System.out.println("Price is same");
		}else {
			System.out.println("Price is not-same");
		}
		driver.switchTo().window(childWindow);

//click Add to cart and get count from the cart icon.
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		String cartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
	
//Click on the cart
		driver.findElement(By.xpath("//div[@aria-label='Go to Cart} with 1 items']")).click();
//Verify the item presence on cart
		String itemVerifyAtCart = driver.findElement(By.xpath("(//span[@class='SizeQuantitySelectBox__text'])[2]")).getText();
		if(cartCount.equals(itemVerifyAtCart)) {
			System.out.println("Item added successfully in Cart");
		}else {
			System.out.println("Item not in Cart");
		}
			
//Take a snap of the resulting page.
		//Step 1 : stored the temporary file as a local variable
			File src = driver.getScreenshotAs(OutputType.FILE);
		// Step 2 : we have created the folder and file name along with the file format 
			File target = new File("./Casio/cart.png");
		// step 3 : transfer the data from the temp to physical file
			FileUtils.copyFile(src, target);
			
//Close All the opened windows one by one.
			driver.close(); // closes child window
			driver.switchTo().window(parentWindow);
			driver.close(); // closes parent
	}
}
