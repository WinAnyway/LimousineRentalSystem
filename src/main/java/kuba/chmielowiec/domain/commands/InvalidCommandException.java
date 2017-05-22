package kuba.chmielowiec.domain.commands;

public class InvalidCommandException extends RuntimeException{

    Validatable.ValidationErrors errors;

    public InvalidCommandException(Validatable.ValidationErrors errors) {
        this.errors = errors;
    }

    public Validatable.ValidationErrors getErrors() {
        return errors;
    }
}
