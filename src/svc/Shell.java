package svc;

import appinfo.Manual;
import appinfo.Version;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static svc.Operation.*;

public class Shell {
	private static ArrayList<String> option = new ArrayList<>();
	private static int OPTION = 0;
//	private static String option = 0;
	
	private Shell() {
	}
	
	public static void script() throws SQLException {
		welcome();
		// TODO: (solved)4/24/22 there is a problem...
		// 	 $ using Arraylist<String> as option rather than unchangeable String class
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			System.out.println("[OUTPUT]");
			option.add(input.nextLine());
			selectOption();
			if (!option.isEmpty()) {
				option.clear();
			}
//			System.out.println("[/OUTPUT]");
		}
		input.close();
	}
	
	private static void welcome() {
		System.out.println(	"Welcome to Word Memory Tool. \n" +
//					"Please press the Enter key once to start your memo trip. \n" +
					"Please input a command to start or \"wmt --help\" to get the manual. ");
	}
	
	private static void selectOption() throws SQLException {
		switch (option.get(OPTION)) {
			case "add":
				addByDefault();
				break;
			case "remove":
				removeByDefault();
				break;
			case "modify":
				modifyByDefault();
				break;
			case "query":
				queryByDefault();
				break;
			case "wmt --help":
			case "help":
			case "?":
				Manual.info();
				break;
			case "wmt --version":
				Version.info();
				break;
			case "exit":
			case "quit":
				exit();
				break;
			default:
				defaultScript();
				break;
		}
	}
	
	private static void defaultScript() {
		System.out.println("Sorry, @-@, there's no command like this. Please input correct command. Input \"wmt --help\" to see all commands. ");
	}
	
	private static void exit() {
		int farewell = ThreadLocalRandom.current().nextInt(0, 10);
		if (farewell < 7) {
			System.out.println("祝您今天心情愉快！ (*^▽^*) ");
		} else if (farewell >= 7 && farewell < 9){
			System.out.println("bye ");
		} else {
			System.out.println("万水千山总是情, 再留一会行不行? T-T ");
		}
		System.exit(0);
	}
}
