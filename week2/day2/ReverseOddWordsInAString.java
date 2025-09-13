package week2.day2;

public class ReverseOddWordsInAString {

	public static void main(String[] args) {
		String test = "I am a software tester";
// Split the words and have it in an array
		String[] words = test.split(" ");
// Traverse through each word using loop
		for(int i=1;i<words.length;i++) {
//Find the odd index within the loop -
			if(i %2 != 0) {	
//Convert the String array into a character array
				System.out.println("Odd Word at index " + words[i]);
                System.out.println("Characters: " + java.util.Arrays.toString(words[i].toCharArray()));
			} else {  
//Print the even position words using another loop
			    System.out.println("Even index word: " + words[i]);
			}
		}
	}
}
