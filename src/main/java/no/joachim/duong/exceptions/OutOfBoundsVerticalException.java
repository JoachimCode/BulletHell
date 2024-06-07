package no.joachim.duong.exceptions;

public class OutOfBoundsVerticalException extends Exception{
    private int entityId;
    public OutOfBoundsVerticalException() {
        super();
    }
    public OutOfBoundsVerticalException(int i) {
        super();
        entityId = i;
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

    public int getCollidedIt(){
        return entityId;
    }
}