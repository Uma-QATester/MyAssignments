package JavaChallenge;
//******Java Challenge (2/20)*************
public class SquareAndSquareRoot {
//Square Method
	public static int Square(int num) {
		int ans = 0 ;
		for(int i=0; i<num ; i++) {
			ans += num;
		}
		return ans;
	}
//SquareRoot Method	
	public static int SquareRoot(int sqNum) {
		int r = 1;
		while(r * r <= sqNum) {
			r++;
		}
		return r-1;
	}
	public static void main(String[] args) {
//Call Square Method
		int n=2;
		int sqResult = Square(n);
//Call SquareRoot Method
		int a = 8;
		int sqRootRes = SquareRoot(a);
//Result
		System.out.println("The Square of " + n + " is " + sqResult);
		System.out.println("The SquareRoot of " + a + " is " + sqRootRes );
	}

}
