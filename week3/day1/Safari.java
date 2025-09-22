package week3.day1;

public class Safari extends Browser {
//Define readerMode() and fullScreenMode() methods in Safari class
	public void readerMode() {
		System.out.println("Apple Safari browser is currently on reader mode");
	}
	public void fullScreenMode() {
		System.out.println("Apple Safari broswer is on full screen mode");
	}
	public static void main(String[] args) {
		Safari driver = new Safari();
		driver.readerMode();
		driver.fullScreenMode();
	}
}

