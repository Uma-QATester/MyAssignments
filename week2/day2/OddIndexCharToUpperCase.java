package week2.day2;

public class OddIndexCharToUpperCase {

	public static void main(String[] args) {
	// * Change the odd index of a given String to uppercase with the input : String test = “changeme”; 
		String test = "changeme";
// convert String to character array
		char[] chars = test.toCharArray();  
//Implement a loop to iterate through each character of the String (from end to start).Find the odd index within the loop */
		for(int i=0; i<chars.length ; i++ ) {
//use the remainder or modulo operator to get the odd index-ie if (remainder != 0)-->then its an odd number			
			if(i %2 != 0) {			
//change the character to uppercase only if the index is odd 				
				chars[i]= Character.toUpperCase(chars[i]); 										
			}
		}
//convert array back to string and display
        System.out.println(new String(chars));		
	}
}
