package week3.day3;
//**********Home Assignment <3>: Find Missing Element using List************

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingElementInList {
		public static void main(String[] args) {
		 List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 6, 8));
			Collections.sort(list1);
			System.out.println("Sorted list:" + list1);
			for(int i=0 ; i<list1.size()-1 ; i++) {
				int current = list1.get(i);
				int next = list1.get(i+1);
				
				while(next!=current+1){//1.i(0) comparing - list[0] with list[1] ==>so in list -1 and 2, 2 and 3, 4 and 6, ..
			
					System.out.println("The missing element in list is = " + (current+1) );
					 current++;//if you dont increment, while will perform endless loop
					
				}
			}
	}
}
