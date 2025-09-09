package week2.day1;

public class EdgeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browserOp;
		browserOp = new Browser();
		
		String browser = browserOp.launchBrowser("Chrome");
		System.out.println("Currrent Browser: " + browser);
		browserOp.loadUrl();
		
		}

}
