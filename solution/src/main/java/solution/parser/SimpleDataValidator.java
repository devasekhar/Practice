package solution.parser;

public class SimpleDataValidator implements DataValidator {

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
