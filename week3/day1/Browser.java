package week3.day1;

public class Browser {
	protected String browserName; 	//protected → to use the variable inside the same package + subclasses
	protected String browserVersion;
	public void openURL() {
		System.out.println("The Requested URL" + browserName + "with" + browserVersion + " is opened");	}
	public void closeBrowser() {
		System.out.println("The browser " + browserName + "with" + browserVersion + "is closed");	}
	public void navigateBack() {
		System.out.println("The browser " + browserName + "with" + browserVersion + "is naviged back");	}
	
	public static void main(String[] args){
		Chrome driver=new Chrome();
		  driver.browserName = " Google Chrome ";
	      driver.browserVersion = " 140.0.7339.81 ";
	      driver.openURL();
	      driver.openIncognito();
	      driver.clearCache();
	      driver.navigateBack();
	      driver.closeBrowser();
	      System.out.println("**************************");
	      
	     Edge driver1=new Edge();
			driver1.browserName = " Microsoft Edge ";
			driver1.browserVersion = "  140.0.3485.54 ";
			driver1.openURL();
			driver1.takeSnap();
			driver.clearCache();
			driver1.navigateBack();
			driver1.closeBrowser();
		    System.out.println("**************************");
	    	      
		Safari driver2=new Safari();
			driver2.browserName = " Apple Safari ";
			driver2.browserVersion = " macOS ";
			driver2.openURL();
			driver2.readerMode();;
			driver2.fullScreenMode();
			driver2.navigateBack();
			driver2.closeBrowser();
		    System.out.println("**************************");	
	}
	}
