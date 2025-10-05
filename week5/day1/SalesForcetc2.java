package week5.day1;
//Home Assignment <3>: Optimizing Test Case Structure with Annotations in TestNG- Test case2

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class SalesForcetc2 extends SalesForceLoginAutomation {

	@Test
	public void tc1() throws InterruptedException {
		openLegalEntities();
		//Click on New Legal Entity
		WebElement newEle = driver.findElement(By.xpath("//a[@title='New']"));
		driver.executeScript("arguments[0].click();", newEle);
		
		// Enter the Company name as 'TestLeaf'.
		String company = "TestLeaf";
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(company);

		// Enter Description as 'Salesforces'.
		String description = "Salesforces";
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(description);

		// Select Status as 'Active'
		WebElement statusCheck= driver.findElement(By.xpath("(//button[@aria-label='Status'])"));
		driver.executeScript("arguments[0].click();", statusCheck);
		
		WebElement statusActive =driver.findElement(By.xpath("//span[text()='Active']"));
		driver.executeScript("arguments[0].click();", statusActive);

		// Click save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		// Verify the Alert message (Complete this field) displayed for Name
		String errorMsg = driver.findElement(By.xpath("//div[text()='Complete this field.']")).getText();

		if (errorMsg.equals("Complete this field.")) {
			System.out.println("Review the Legal Entity Name Field as error msg is =" + errorMsg);
		}

	}

}
