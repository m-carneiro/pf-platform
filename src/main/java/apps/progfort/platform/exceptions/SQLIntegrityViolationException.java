package apps.progfort.platform.exceptions;

public class SQLIntegrityViolationException extends RuntimeException {
    public SQLIntegrityViolationException(String message) {
        super(message);
    }

    public SQLIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
