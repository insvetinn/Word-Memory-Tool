package msg;

import org.junit.Test;

public class StatusTest {
	@Test
	public void test() {
		Status.saySuccess();
		Status.alertError();
		Status.say("Hello! This is module msg. ");
	}
}
