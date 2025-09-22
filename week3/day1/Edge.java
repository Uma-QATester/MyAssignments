package week3.day1;

public class Edge extends Browser {
//Define takeSnap() and clearCookies() methods in Edge class
	public void takeSnap() {
		System.out.println("Built-in web-capture is enabled");
	}
	public void clearCache() {
		System.out.println("Microsoft Edge Cache is cleared");
	}
	public static void main(String[] args) {
		Edge driver = new Edge();
		driver.takeSnap();
		driver.clearCache();
}

}
