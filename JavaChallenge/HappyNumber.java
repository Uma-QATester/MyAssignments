package JavaChallenge;

import java.util.Scanner;

//******Java Challenge (5/20)*************

/*Java Challenge (5/20)

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 2 + 81 = 82
8^2 + 2^2 = 64 + 4 = 68
6^2 + 8^2 = 36 + 64 = 100
1^2 + 0^2 + 0^2 = 1 + 0 + 0 = 1

Example 2:

Input: n = 2
Output: false*/

public class HappyNumber {
	// Function to calculate sum of squares of digits
	public static int sumOfSquares(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10; // get last digit
			sum += digit * digit; // square it and add
			n /= 10; // get first digit
		}
		return sum;
	}
	/*
	 * Start: n = 19, sum = 0 ,
	 * Loop 1: digit = 19 % 10 = 9 ,sum = 0 + (9*9) = 81, n = 19 / 10 = 1 
	 * Loop 2: digit = 1 % 10 = 1 ,sum = 81 + (1*1) = 82 ,n = 1 / 10 = 0 →loop ends. Return → 82.
	 */

	// Function to check if a number is happy

	public static boolean isHappy(int n) {
		for (int i = 0; i < 100; i++) {
			// limit loop to avoid infinite cycling
			if (n == 1)
				return true;
			n = sumOfSquares(n);
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter an integer to find Happy Number: ");
		int number = scanner.nextInt(); // nextInt() method to read the integer
		if (isHappy(number)) {
			System.out.println(number + " is a Happy Number!");
		} else {
			System.out.println(number + " is NOT a Happy Number.");
		}
		scanner.close();
	}
}
