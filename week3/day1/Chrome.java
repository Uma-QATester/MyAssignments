package week3.day1;

public class Chrome extends Browser{
//Define openIncognito() and clearCache() methods in Chrome class
	public void openIncognito() {
		System.out.println("The Incognito Chrome window is launched");
	}
	public void clearCache() {
		System.out.println("Chrome Cache memory is cleared");
	}
	public static void main(String[] args) {
		Chrome driver = new Chrome();
		driver.openIncognito();
		driver.clearCache();
}
	

}
