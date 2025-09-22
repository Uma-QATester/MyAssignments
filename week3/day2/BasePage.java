package week3.day2;
//*********Home Assignment <2B>: Demonstrating Method Overriding in Java

/*Create a superclass with common methods for interacting with web elements. 
Implement a method from the superclass to provide a specific implementation in the subclass 
that overrides the superclass method.*/

/*Create a Java class named BasePage 
 * - Create methods like findElement(), clickElement(), enterText() and performCommonTasks().*/

public class BasePage {
	 void findElement() {
		System.out.println("Find the Element with 'name - TextBox' in BasePage");
	}
	 void clickElement() {
		System.out.println("Click the Element with 'name - TextBox' in BasePage");
	}
	 void enterText() {
		System.out.println("Enter Text at the TextBox in BasePage");
	}
	 void performCommonTasks() {
		System.out.println("Perform Common tasks at TextBox button in BasePage");
	}
}
