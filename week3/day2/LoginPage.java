package week3.day2;
//*********Home Assignment <2B>: Demonstrating Method Overriding in Java

/*Create a subclass named LoginPage. - Override the performCommonTasks() method in the LoginPage class. 
 * - Demonstrate the concept by creating objects for both classes and calling their methods.
*/
public class LoginPage extends BasePage {
	@Override
	public void performCommonTasks() {
		System.out.println("Perform Common tasks at TextBox button in LoginPage which extends BasePage");
	}
	public static void main(String[] args) {
		LoginPage LGPG = new LoginPage();
		LGPG.findElement();
		LGPG.clickElement();
		LGPG.enterText();
		LGPG.performCommonTasks();
	}
}
