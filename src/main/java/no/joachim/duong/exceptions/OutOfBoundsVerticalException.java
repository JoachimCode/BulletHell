package no.joachim.duong.exceptions;

public class OutOfBoundsVerticalException extends Exception{
    public OutOfBoundsVerticalException() {
        super();
    }

    public OutOfBoundsVerticalException(String message) {
        super(message);
    }
    public OutOfBoundsVerticalException(String message, Throwable cause) {
        super(message, cause);
    }
    public OutOfBoundsVerticalException(Throwable cause) {
        super(cause);
    }
}