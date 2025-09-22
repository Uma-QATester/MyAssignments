package week3.day1;
//*Home Assignment <1>: Demonstrating Inheritance in Java****
/*//Subclasses: Button and TextField 
 * - Implement two subclasses, Button and TextField, both inheriting from the WebElement base class. 
 * - In the Button subclass, include a submit() method. 
 * - In the TextField subclass, include a getText() method.
*/
public class ButtonSubClass extends WebElement {
	void submit() {
		System.out.println("Submit method from Button Sub Class extending WebElement base class");
	}
	
}
