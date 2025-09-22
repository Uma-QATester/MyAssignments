package week3.day1;
//*Home Assignment <1>: Demonstrating Inheritance in Java****
/*Execution Class: Elements - Create execution class named , also inheriting from the Button subclass.
 * Finally, in a separate class Elements create objects for sub classes and call their respective methods..
*/
public class Elements extends ButtonSubClass{

	public static void main(String[] args) {
		//Base Class-WebElements
		WebElement elements = new WebElement();
		System.out.println("Base Class methods execution");
		System.out.println("***");
		elements.click();
		elements.setText("Hi");
		System.out.println("***");
		
		//Button SubClass extends WebElements Base Class
		ButtonSubClass bc=new ButtonSubClass();
		System.out.println("***");
		System.out.println("Button SubClass  extends WebElements Base Class methods execution");
		bc.click();
		bc.submit();
		System.out.println("***");

		//TextField SubClass extends WebElements Base Class
		TextFieldSubClass tf = new TextFieldSubClass();
		System.out.println("***");
		System.out.println("TextField SubClass extends WebElements Base Class methods execution");
		tf.click();
		tf.getText();
		System.out.println("***");

		
		//CheckBox Button SubClass extends Button Sub Class
		CheckBoxButtonAdditionalSubClass cbb = new CheckBoxButtonAdditionalSubClass();
		System.out.println("***");
		System.out.println("CheckBox Button SubClass extends Button Sub Class methods execution");
		cbb.clickCheckButton();
		cbb.click();
		cbb.submit();
		
		//Radio Button SubClass extends Button Sub Class
		RadioButtonAdditionalSubClass rb = new RadioButtonAdditionalSubClass();
		System.out.println("***");
		System.out.println("Radio Button SubClass extends Button Sub Class methods execution");
		rb.selectRadioButton();
		rb.click();
		rb.submit();
		System.out.println("***");

	}

}
