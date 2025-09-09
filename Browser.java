package week2.day1;

public class Browser {
	
	public String launchBrowser(String browserName) {
		System.out.println("Browser launched successfully :"+ browserName);
		return browserName;
	
	}
	public void loadUrl() {
	System.out.println("Application url loaded successfully")	;
		
	}
	
	public static void main(String[] args) {
		//Browser output =new Browser();
		Browser outputBrowser;
		outputBrowser = new Browser();
		
		String browser = outputBrowser.launchBrowser("Chrome");
		System.out.println("Currrent Browser: " + browser);
		outputBrowser.loadUrl();
		
		
	}
}

