package JavaChallenge;
//*******Java Challenge (1/20)******
import java.util.Scanner;

/*Java Challenge (1/20)
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.*/

public class LengthOfTheLastWord {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);//Get input from the user
		System.out.print("Enter a Input: ");
		String inputTxt = sc.nextLine() ;//stores the whole line the user types in a string.
		String lastword;
		int space = inputTxt.lastIndexOf(" ");//find the last space in the line
		if(space == -1) {//there is no space in line, 
			lastword = inputTxt;//then the whole line is one word
		}else {
			lastword = inputTxt.substring(space + 1);//get the last word			
		}
		int count=lastword.length();
		System.out.println("The Entered input =" + inputTxt);
		System.out.println("The count of last word = " + count);
		System.out.println("The last word is " + "'" + lastword + "'" + " with length " + count);
		sc.close();
	}

}
