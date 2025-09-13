package week2.day2;

public class FindArrayIntersection {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Array Declaration and Length Check :
		int ArrayOne[] = {3,2,11,4,6,7};
		int ArrayTwo[] = {1,2,8,4,9,7};
		System.out.println("The length of ArrayOne = " + ArrayOne.length);
		System.out.println("The length of ArrayTwo = " + ArrayTwo.length);
		
		//NestedForLoopp to compare and print
		for(int i=0 ; i<ArrayOne.length ; i++) {
			for(int j=0 ; j<ArrayTwo.length ; j++) {
				if(ArrayOne[i] == ArrayTwo[j]) {
					System.out.println("The Matched Value from 1st Array = " + ArrayOne[i]);
				}
				}
				
			}
		}
		
}
