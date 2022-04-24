package svc;

import appinfo.Manual;
import appinfo.Version;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static svc.Operation.*;

public class Shell {
	private static String option = null;
	
	private Shell() {
	}
	
	public static void script() throws SQLException {
		welcome();
		// TODO: 4/24/22 there is a problem...
		// 	 #
		// 	 $
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			System.out.print("wmt> ");
			option = input.nextLine();
		}
		// TODO: 4/24/22 completely not working...
		// 	 #
		// 	 $
		selectOption();
	}
	
	private static void welcome() {
		System.out.println(	"Welcome to Word Memory Tool. \n" +
					"Please press the Enter key once to start your memo trip. \n" +
					"Please input a command to start or \"wmt --help\" to get the manual. ");
	}
	
	private static void selectOption() throws SQLException {
		switch (option) {
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
		System.out.println("Sorry, @-@, there's no command like this. Please input correct command. Input \"wordlist --help\" to see all commands. ");
	}
	
	private static void exit() {
		int farewell = ThreadLocalRandom.current().nextInt(0, 10);
		if (farewell < 7) {
			System.out.println("祝您今天心情愉快！ (*^▽^*) ");
		} else if (farewell > 7 && farewell < 8){
			System.out.println("bye ");
		} else {
			System.out.println("万水千山总是情, 再留一会行不行? T-T ");
		}
			System.exit(0);
	}
}
