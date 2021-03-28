package solution.parser;

import java.util.ArrayList;
import java.util.List;

//composite pattern
public class StrictDataValidator implements DataValidator {
	private List<DataValidator> validators;

	public StrictDataValidator() {
		validators = new ArrayList<>();
		validators.add(new SimpleDataValidator());
		validators.add(new BuildDurationAttributeValidator());
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
