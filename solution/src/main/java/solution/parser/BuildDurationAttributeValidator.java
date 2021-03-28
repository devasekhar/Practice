package solution.parser;

public class BuildDurationAttributeValidator implements DataValidator {

	public boolean valid(String str) {
		String[] attributes = str.split(",");
		if (attributes.length != 6)
			return false;

		if (!(attributes[5].lastIndexOf('s') == attributes[5].length() - 1))
			return false;

		return true;
	}

}
