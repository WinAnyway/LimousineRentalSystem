package kuba.chmielowiec.infrastructure.aspects;

import kuba.chmielowiec.domain.commands.InvalidCommandException;
import kuba.chmielowiec.domain.commands.Validatable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    @Before("execution(* kuba.chmielowiec.application..*.*(..)) && args(validatable)")
    public void validate(Validatable validatable) {
        Validatable.ValidationErrors errors = new Validatable.ValidationErrors();
        validatable.validate(errors);
        if (!errors.isValid())
            throw new InvalidCommandException(errors);
    }

}
