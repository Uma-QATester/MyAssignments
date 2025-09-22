package week3.day3;

import java.util.ArrayList;
import java.util.List;

//**************Home Assignment <1> Find Intersection using List****************
public interface ListIntersectionInterface {

	public static void main(String[] args) {
		
//SYNTAX FOR ARRAY LIST - interface<wrapperClass> listName=new implementationClass<wrapperClass>()
//Method 1 for 	Add elements to list	
		List<Integer> numList1 = new ArrayList<Integer>();		
		numList1.add(3); numList1.add(2); numList1.add(11);
		numList1.add(4);
		numList1.add(6);
		numList1.add(7);
		
//Method 2 for 	Add elements to list			
		int[] numbers2 = {1, 2, 8, 4, 9, 7};
		
	 // Add elements to a List
        List<Integer> numList2 = new ArrayList<>();
        for (int num : numbers2) {//
            numList2.add(num);   // Autoboxing int (to)-> Integer- Java automatically converts int->Integer WrapperClass
        }
//Method 3 for Add elements to list == List<Integer> ListName = new implementationClass<wrapperClass>(Arrays.asList(1, 2, 3, 4));
        
 // Iterate the values through the length of the list - Use an appropriate conditional statement to compare the values       
		for(int i:numList1) {//getting values in numlist1 to i)
			for(int j :numbers2) {
				if(i==j) {
					System.out.println("Matching Value : " + i);
				}
			}
		}
	}
}
