package week3.day2;
//***********Home Assignment <3B>: Demonstrating Abstraction in Java***********

public abstract class MySqlConnection implements DbConnection {
	
	  public void executeQuery() { 
		  System.out.println("The Select MySql Statement SELECT * FROM table_name is exceuted"); 
		  }
	 }
