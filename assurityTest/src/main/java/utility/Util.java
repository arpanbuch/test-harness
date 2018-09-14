package utility;

import java.util.Random;

public class Util {

	public static int getRandomId() {

		Random rand = new Random();
		int randomId = rand.nextInt(100);

		return randomId;

	}

}
