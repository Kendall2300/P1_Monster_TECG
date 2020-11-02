package TEC.Exceptions;

public class WrongPhaseException extends UnexpectedFormatException{
    public WrongPhaseException() {
    }
    public WrongPhaseException(String message) {
        super(message);
    }
}
