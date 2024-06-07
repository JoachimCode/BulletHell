package no.joachim.duong.exceptions;

public class OutOfBoundsHorizontalException extends Exception{
    private int entityId;
    public OutOfBoundsHorizontalException() {
        super();
    }
    public OutOfBoundsHorizontalException(int i) {
        super();
        entityId = i;
    }
    public OutOfBoundsHorizontalException(String message) {
        super(message);
    }
    public OutOfBoundsHorizontalException(String message, Throwable cause) {
        super(message, cause);
    }
    public OutOfBoundsHorizontalException(Throwable cause) {
        super(cause);
    }
    public int getCollidedId() {
        return entityId;
    }
}
