package appinfo;

public class Manual {
	private Manual() {
	}
	
	public static void info() {
		System.out.println(	"Manual Page");
		System.out.println(	"NAME: ");
		System.out.println(	"	wmt - word memory tool");
		System.out.println(	"USAGE: ");
		System.out.println(	"	add - add new word and its meaning. ");
		System.out.println(	"	remove - delete a word. ");
		System.out.println(	"	modify - change the meaning of a word. ");
		System.out.println(	"	query - search all words. ");
		System.out.println(	"	wmt --help - the manual. ");
		System.out.println(	"	help - the manual. ");
		System.out.println(	"	? - the manual. ");
		System.out.println(	"	wmt --version - the version information. 1.0 for current. ");
		System.out.println(	"	exit / quit - close this app. ");
	}
}
