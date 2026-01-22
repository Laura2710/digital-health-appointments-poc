package ch.demo.healthappointments.exception;

public class BLLException extends RuntimeException {

    public BLLException() {
        super();
    }

    public BLLException(String message) {
        super(message);
    }

    public BLLException(String message, Throwable cause) {
        super(message, cause);
    }

    public BLLException(Throwable cause) {
        super(cause);
    }
}
