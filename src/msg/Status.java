package msg;

public class Status {
	private final static String SUCCESS = "SUCCESS! ";
	private final static String ERROR = "ERROR! ";
	
	public static void say(String content) {
		System.out.println(content);
	}
	
	public static void saySuccess() {
		say(SUCCESS);
	}
	
	public static void alertError() {
		say(ERROR);
	}
}
