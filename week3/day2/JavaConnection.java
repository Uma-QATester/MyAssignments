package week3.day2;
//*********Home Assignment <3A>: Demonstrating Interface in Java*******

public class JavaConnection implements DatabaseConnection {

	@Override
	public void connect() {
		System.out.println("Database connection is established using JavaConnection");
	}
	@Override
	public void disconnect() {
		System.out.println("Database connection is disconnected. Try Again");
	}
	@Override
	public void executeUpdate() {
		System.out.println("Database Execution is Updated");
	}
	public static void main(String[] args) {
		JavaConnection JCDB = new JavaConnection();
		JCDB.connect();
		JCDB.executeUpdate();
		JCDB.disconnect();
	}
}
