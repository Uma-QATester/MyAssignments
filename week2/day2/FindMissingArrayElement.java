package week2.day2;

import java.util.Arrays;

public class FindMissingArrayElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Find the missing element in the given array
		Input -> {1, 4,3,2,8, 6, 7};
		Output -> 5
		Requirements:
		- Create a Java class named FindMissingElement.
		- Add a main method in the FindMissingElement class, either by typing it or using a shortcut
		(Type main, ctrl+space & Enter).
		- Inside the main method, write java code to print Missing Number in the console.
		- Save the code and run the program (right-click -> Run as -> Java Application).*/
		
		int[] ArrayA = {1, 4, 3, 2, 8, 6, 7};
		Arrays.sort(ArrayA);
		for(int i=0 ; i<ArrayA.length ; i++) {
			//i + 1 means array indices start at 0 but numbers start at 1.
			if(ArrayA[i] != i+1){
				System.out.println("Missing Element in the Array :" + (i+1));
				break;
				
			}
			}
		}
	}

