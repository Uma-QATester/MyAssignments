package week3.day2;
//***********Home Assignment <3B>: Demonstrating Abstraction in Java***********

/*Design an abstract class that implements an interface with abstract methods for creating 
 * and managing database and further implement those methods in a concrete class.
*/
public interface DbConnection {
	void connect();
	void disconnect();
	void executeUpdate();
}
