package week3.day2;
//******Assignment-Demonstrating Overriding in Java******
public class OverrideMethodSub extends OverridingMethodSuper {
//Create a SubClass and Override that takeSnap method in the sub class.
	@Override
	public void takeSnap() {
		System.out.println("Snapshot from Sub Class Overriding the Super Class");
	}
	public static void main(String[] args) {
		OverrideMethodSub overRideSub = new OverrideMethodSub();
		overRideSub.takeSnap();		
		overRideSub.reportStep();
	}
}
