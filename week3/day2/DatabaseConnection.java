package week3.day2;
//*********Home Assignment <3A>: Demonstrating Interface in Java*******

/*Design an interface DatabaseConnection with abstract methods representing various database methods  
 * and implement those methods in a Concrete class JavaConnection.*/

public interface DatabaseConnection {
	void connect();
	void disconnect();
	void executeUpdate();
}
