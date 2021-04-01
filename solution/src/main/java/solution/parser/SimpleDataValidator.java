package solution.parser;

/*
 * Checks if string is emptys after splitting the input string with ',' and also checks if it has 6 attribute after splitting
 * Basically trying to match attributes of Data
 */

public class SimpleDataValidator implements DataValidator {

	private static SimpleDataValidator instance = new SimpleDataValidator();

	private SimpleDataValidator() {

	}

	public static DataValidator getInstance() {
		return instance;
	}

	public boolean valid(String str) {

		String[] attributes = str.split(",");
		if (attributes.length != 6)
			return false;

		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].isEmpty()) {
				return false;
			}
		}
		return true;
	}

}
