package week5.day1;
//Home Assignment <3>: Optimizing Test Case Structure with Annotations in TestNG- Test case1

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class SalesForcetc1 extends SalesForceLoginAutomation {
	
	@Test
	public void tc1() throws InterruptedException {
		openLegalEntities();
		
		//Click on New Legal Entity
		WebElement newEle = driver.findElement(By.xpath("//a[@title='New']"));
		driver.executeScript("arguments[0].click();", newEle);
		
		// Enter Name as 'Salesforce Automation by *Your Name*'
		String name="Salesforce Automation";
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(name);
		
		//Click save 
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//Verify Legal Entity Name
		String op= driver.findElement(By.xpath("//slot[@name='outputField']")).getText();
		
		if(op.equals(name)) {
			System.out.println("Legal Entity Name Verified");
		}

	}
}
