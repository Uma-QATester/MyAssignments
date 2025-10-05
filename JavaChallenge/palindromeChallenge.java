package JavaChallenge;
//****Java Challenge (3/20)*********
import java.util.Scanner;
public class palindromeChallenge {
// Removes everything except alphabets (A–Z, a–z)
	public static String removeAllNonAlphaNumeric(String input){
		return input.replaceAll("[^a-zA-Z]", "");
		}
// Converts string to lowercase
	public static String toLowerCase(String input) {
		return input.toLowerCase();
		}
//Check for Palindrome	
	public static boolean palindrome(String input) {
		int left = 0;
		int right = input.length()-1;
		while(left<right) {
			if(input.charAt(left) != input.charAt(right)) {//if Chars at left and right is not same
				return false;
		}
		left ++;//increase the index from left
		right --;//decrease the index from right
		}
		return true;//if all chars from left to right are same
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Get input from the user
		System.out.print("Enter a Input: ");
		String input = sc.nextLine() ;//stores the whole line the user types in a string.
		String cleaned = removeAllNonAlphaNumeric(input);
		String Output = toLowerCase(cleaned);
		boolean result = palindrome(Output);
		System.out.println("Palindrome Output = " + Output);
		System.out.println("Is the text input a palindrome ? " + result);
		sc.close();
	}
}
