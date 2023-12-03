package this_demo;

public class Main {

	public static void main(String[] args) {
		
		
		//version1();
		
		version2();
	}

	static void version1() {
		
		Mobile joysMobile = new Mobile("Joy's Mobile", "Samsung", 12345.55);
		
		joysMobile.display();
		
	}
	
	static void version2() {
		
		
		Mobile2 joysMobile = new Mobile2("Joy's MMobile", "Samsung", 12345.55);
		
		joysMobile.display();
		
	}
}
