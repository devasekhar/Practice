package solution.parser;

/*
 * Checks whether input string provided ends with character s after splitting based ','
 * Basically trying to match buildduration of Data attribute
 */
public class BuildDurationAttributeValidator implements DataValidator {

	private static BuildDurationAttributeValidator instance = new BuildDurationAttributeValidator();

	private BuildDurationAttributeValidator() {

	}

	public static DataValidator getInstance() {
		return instance;
	}

	public boolean valid(String str) {
		String[] attributes = str.split(",");
		if (attributes.length != 6)
			return false;

		if (!(attributes[5].lastIndexOf('s') == attributes[5].length() - 1))
			return false;

		return true;
	}

}
