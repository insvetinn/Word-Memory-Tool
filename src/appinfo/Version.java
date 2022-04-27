package appinfo;

public class Version {
	private Version() {
	}
	
	public static void info() {
		System.out.println("Version: 1.1");
		System.out.println("- Fixed option interface issues. ");
		System.out.println("Version: 1.0");
		System.out.println("Author: linglan");
		System.out.println("Function: basic CRUD on words. ");
		System.out.println("For more information, please visit this website: https://github.com/insvetinn/Word-Memory-Tool");
	}
	
	@Deprecated
	public static void info1_0() {
		System.out.println("Version: 1.0");
		System.out.println("Author: linglan");
		System.out.println("Function: basic CRUD on words. ");
		System.out.println("For more information, please visit this website: https://github.com/insvetinn/Word-Memory-Tool");
	}
}
