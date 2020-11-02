package TEC.Exceptions;

@SuppressWarnings("serial")
public class EsbirrosMultipleAttackException extends UnexpectedFormatException{
    public EsbirrosMultipleAttackException() {
    }
    public EsbirrosMultipleAttackException(String message){
        super(message);
    }
}
