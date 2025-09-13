package week2.day3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AutomaticFacebookLogin {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// step 1: Set up driver
		ChromeDriver browser = new ChromeDriver();
		// step 2: load the url with get method
		browser.get("https://www.facebook.com/");
		// step 3: Manage the window remotely with manage method
		browser.manage().window().maximize();
		// step 4: locate the email field
		WebElement eMail = browser.findElement(By.id("email"));
		//step 5: Enter the email id as testleaf.2023@gmail.com
		eMail.sendKeys("testleaf.2023@gmail.com");
		//step 6:Enter the password as Tuna@321: locate the password field and enter as Tuna@321
		WebElement pwdEnter = browser.findElement(By.name("pass"));
		pwdEnter.sendKeys("Tuna@321");
		// step 7 : Click on the Login button:Locate the login button then click it
		browser.findElement(By.name("login")).click();
		//step 8:- Click on the ‘Find your account and log in.’ link
		browser.findElement(By.partialLinkText("Find your account")).click();
		//step 9:Print and verify the title of the current web page.
		String actualfbwindowtitle = browser.getTitle();
		//System.out.println(actualfbwindowtitle);
		String expectedfbwindowtitle = ("Forgotten Password | Can't Log In | Facebook");
		if(actualfbwindowtitle.equals(expectedfbwindowtitle)) {
			System.out.println("Verified the title of the current web page: " + actualfbwindowtitle);			
		}
		//step 10:close the browser
		browser.close();
	}

}
