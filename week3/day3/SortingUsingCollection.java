package week3.day3;
//*************Home Assignment <4>: Sorting Using Collection**********
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//****Home Assignment <4>: Sorting Using Collection**********
public class SortingUsingCollection {

	public static void main(String[] args) {
			
		 String[] companies = {"HCL", "Wipro", "Infosys", "Aspire Systems","CTS"};
		 List<String> list1 = new ArrayList<>(Arrays.asList(companies));//convert array to list
		 Collections.sort(list1);
		 System.out.println("The Original order = " + list1);
		 //Collections.reverseOrder();
		 //System.out.println("The Reversed order = " + list1);
		 for(int i=(list1.size())-1 ; i>=0; i--) {//go in reverse order
			    System.out.print(list1.get(i));
			 if(i != 0) {
				    System.out.print(", ");//ensures the comma is only printed after elements that are not the first one 
				    						//(which is last in the reverse loop).

			 }
		 }
	}
}
