package week3.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//*********Home Assignment <2>: Find Second Largest Number using List****
public class SecondLargestInList {
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 2, 11, 4, 6, 7));
		Collections.sort(list1);
		System.out.println("Sorted list:" + list1);
		System.out.println("The SIZE OF the list :" + list1.size());
		
		int listSize =list1.size();
		
		System.out.println("The  Largest number in the list :" + list1.get(listSize -1));
		System.out.println("The  Second Largest number in the list :" + list1.get(listSize -2));
	}

}
