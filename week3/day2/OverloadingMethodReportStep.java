package week3.day2;
//*******Classroom Assignment <2>: Demonstrating Polymorphism in Java******
public class OverloadingMethodReportStep {
	/*
	 * //One version should accept two input arguments: a String for the message
	 * (msg) and another String for the status (status).
	 */	public void reportStep(String msg,String status) {
		System.out.println("The String " + msg + " is displayed as " + status);
	}
	/*
	 * Another version of the reportStep method should accept three input arguments:
	 * a String for the message (msg), a String for the status (status), and a
	 * boolean parameter (snap to indicate whether to take a snapsho
	 */ 	 
	
	 public void reportStep(String msg,String status, boolean snap) {
			System.out.println("The String " + msg + " is displayed as " + status + "and it has the default value as " + snap);

	}
	public static void main(String[] args) {
	OverloadingMethodReportStep ompr = new OverloadingMethodReportStep();
	ompr.reportStep("Login", "Enabled");
	ompr.reportStep("Login", "Enabled", true);
	}

}
