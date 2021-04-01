package solution.parser;

import java.util.ArrayList;
import java.util.List;

/*
 *  StrictDataValidator combines both SimpleDataValidator and SimpleDataValidator
 *  Basically trying to match attributes of Data
 *  composite pattern has been used
 */

public class StrictDataValidator implements DataValidator {

	private static StrictDataValidator instance = new StrictDataValidator();
	private List<DataValidator> validators;

	private StrictDataValidator() {

		validators = new ArrayList<>();
		validators.add(SimpleDataValidator.getInstance());
		validators.add(BuildDurationAttributeValidator.getInstance());

	}

	public static StrictDataValidator getInstance() {
		return instance;
	}

	public void addValidator(DataValidator validator) {
		validators.add(validator);
	}

	@Override
	public boolean valid(String str) {
		for (DataValidator validator : validators) {
			if (!validator.valid(str)) {
				return false;
			}

		}
		return true;
	}

}
