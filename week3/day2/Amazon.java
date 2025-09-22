package week3.day2;
//********Classroom Assignment <3A>: Demonstrating Abstraction in Java*****

public class Amazon extends CanaraBank{
	public static void main(String[] args) {
		Amazon order=new Amazon();
		order.cardPayments();
		order.cashOnDelivery();
		order.internetBanking();
		order.upiPayments();
		order.recordPaymentDetails();
	}
	@Override
	public void cashOnDelivery() {
		System.out.println("Canara Bank Cash on delivery");
}
	@Override
	public void upiPayments() {
		System.out.println("Canara Bank UPI payments");		
	}
	@Override
	public void cardPayments() {
		System.out.println("Canara Bank Card payment");		
	}
	@Override
	public void internetBanking() {
		System.out.println("Canara Bank IB");		
	}
	@Override
	void recordPaymentDetails() {
		System.out.println("All the payment details are secured ");		
	}
}
