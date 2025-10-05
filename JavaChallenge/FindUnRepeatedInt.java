package JavaChallenge;
//*******Java Challenge (4/20)**********

public class FindUnRepeatedInt {
		public static void unique(int[] array) {
			int length = array.length;
			for (int i = 0; i < length; i++) {
				boolean isunique = true;
				for (int j = 0; j < length; j++) {
					if (i != j && array[i] == array[j]) {
						isunique = false;
						break;
					}
				}
				if (isunique) {
					System.out.println("Unrepeated int in array = " + array[i]);
				}
			}
		}

		public static void main(String[] args) {
			int[] array1 = { 2, 2, 1 };
			System.out.println("@ Input 1 :");
			unique(array1);

			int[] array2 = { 4, 1, 2, 1, 2 };
			System.out.println("@ Input 2 :");
			unique(array2);

			int[] array3 = { 1 };
			System.out.println("@ Input 3 :");
			unique(array3);

			int[] array4 = { 1, 6, 1, 6, 0 };
			System.out.println("@ Input 4 :");
			unique(array4);
		}
			
	}
