package week3.day3;
//******Classroom Assignment <1>: Demonstrating List Interface in Java********

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListInterface {
	
	public static void main(String[] args) {
		ChromeDriver browser = new ChromeDriver();
		browser.get("https://www.amazon.in/");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
/* * Write common locator / xpath matching all the phone price in the page and get into List<Element> - Get the values in a list and sort the values in ascending order - Get the first item from the sorted list which is the least price */	
		browser.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("phones",Keys.ENTER);
		List<WebElement> phoneCosts = browser.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));
		List<Integer> prices = new ArrayList<>();
		for (WebElement phonePrices : phoneCosts) {
/* * //getText() → fetches the text.replace(",", "") → cleans commas so Java can understand it as a number.trim() → removes leading/trailing spaces to prevent parsing errors. */		
     		String textValueOfThePhones = phonePrices.getText().replace(",","").trim();
			if(!textValueOfThePhones.isEmpty()) {
				prices.add(Integer.parseInt(textValueOfThePhones));
				//Converts the cleaned string (like "12999") into an integer and add to list prices
			}
		}
			Collections.sort(prices);//Sorting with Collections.sort() puts smallest first.
			System.out.println("The sorted cost of phones =" + prices);	
	//- Get the first item from the sorted list which is the least price
			if(!prices.isEmpty()) {
				int firstLeastValue = prices.get(0);
				System.out.println("Least Value = " + firstLeastValue);
			}else {
				System.out.println("No Least value in phones");
				}
		}
}
