package week3.day1;
//*******Classroom Assignment <1>: Demonstrating Inheritance in Java******
public class TestBrowserWithTestData extends TestData{

	public static void main(String[] args) {
		TestData testData = new TestData();
		testData.enterCredentials();
		
		LoginTestData login = new LoginTestData();
		login.enterUsername("Jingle Bell");
		
		PasswordTestData passwors = new PasswordTestData();
		passwors.enterPassword("XYX");
		
		testData.navigateToHomePage();
		System.out.println("Hi, Welcome to the Home Page");
	}

}
