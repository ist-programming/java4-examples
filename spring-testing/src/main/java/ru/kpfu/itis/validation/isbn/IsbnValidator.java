package ru.kpfu.itis.validation.isbn;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IsbnValidator implements ConstraintValidator<ISBN, String> {

    private static Pattern PATTERN = Pattern.compile("^\\d{10,14}$");

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        return PATTERN.matcher(str).matches();
    }
}
