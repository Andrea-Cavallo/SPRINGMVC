package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeCorsoConstraintValidator implements ConstraintValidator<NomeCorso, String> {

	private String coursePrefix;

	@Override
	public void initialize(NomeCorso nomeCorso) {
		coursePrefix = nomeCorso.value();
	}

	@Override
	public boolean isValid(String nomeCorso, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result;

		if (nomeCorso != null) {
			result = nomeCorso.startsWith(coursePrefix);
		} else {
			result = true;
		}

		return result;
	}
}
