package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CapConstraintValidator implements ConstraintValidator<Cap, String> {

	private String capPrefix;

	@Override
	public void initialize(Cap cap) {
		capPrefix = cap.value();
	}

	@Override
	public boolean isValid(String CapInserito, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result;

		if (CapInserito != null) {
			result = CapInserito.startsWith(capPrefix);
		} else {
			result = true;
		}

		return result;
	}
}