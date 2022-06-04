package ru.kpfu.itis.validation.isbn;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsbnValidator.class)
@Documented
public @interface ISBN {

    public String message() default "Bad ISBN format";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
