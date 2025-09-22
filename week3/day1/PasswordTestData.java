package week3.day1;
//******Classroom Assignment <1>: Demonstrating Inheritance in Java********
//Create subclasses LoginTestData  and create 2 methods in each - enterUsername() - enterPassword()
public class PasswordTestData extends TestData{
	void enterPassword(String password) {
		System.out.println("Enter the Password as :" + password);
	}
}
