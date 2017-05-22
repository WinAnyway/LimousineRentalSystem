package kuba.chmielowiec.infrastructure;

public class NoResourceException extends RuntimeException {
    public NoResourceException(String message) {
        super(message);
    }
}
