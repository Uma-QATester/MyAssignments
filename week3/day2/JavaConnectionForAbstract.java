package week3.day2;
//***********Home Assignment <3B>: Demonstrating Abstraction in Java***********

public class JavaConnectionForAbstract extends MySqlConnection{
	@Override
	public void connect() {
		System.out.println("MySql Database connection is established using JavaConnection");
	}
	@Override
	public void disconnect() {
		System.out.println("MySql Database connection is disconnected. Try Again");
	}
	@Override
	public void executeUpdate() {
		System.out.println("MySql Database Execution is Updated");
	}
	public static void main(String[] args) {
		JavaConnectionForAbstract JCFA = new JavaConnectionForAbstract();
		JCFA.connect();
		JCFA.executeQuery();
		JCFA.executeUpdate();
		JCFA.disconnect();		
	}
}
