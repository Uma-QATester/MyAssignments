package week3.day2;
//********Classroom Assignment <3A>: Demonstrating Abstraction in Java*****
public abstract class CanaraBank implements Payments{
//adds `recordPaymentDetails()` for payment specifics
	 abstract void recordPaymentDetails();
	 	public void cashOnDelivery(){
	 		System.out.println("Cash on delivery is available");
	}
	 	public void upiPayments(){
	 		System.out.println("UPI payments can be done");
	}
	}
	/*
	 * How to decide what to do first”
	 * 
	 * Understand the requirements fully – underline all keywords (interface,
	 * abstract, concrete, methods).
	 * 
	 * Identify what’s mandatory for everyone → start with interface.
	 * 
	 * Identify shared behavior or properties → move to abstract class.
	 * 
	 * Identify the real working class → implement concrete class.
	 * 
	 * Test to make sure everything is linked properly.
	 */
