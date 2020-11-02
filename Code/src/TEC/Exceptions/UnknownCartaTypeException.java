package TEC.Exceptions;

public class UnknownCartaTypeException extends UnexpectedFormatException{
    String unknownType;

    public UnknownCartaTypeException(String unknownType) {
        this.unknownType = unknownType;
    }

    public UnknownCartaTypeException(String arg0, String unknownType) {
        super(arg0);
        this.unknownType = unknownType;
    }

    public UnknownCartaTypeException(String sFile, int sLine, String unknownType) {
        super(sFile, sLine);
        this.unknownType = unknownType;
    }

    public UnknownCartaTypeException(String message, String sFile, int sLine, String unknownType) {
        super(message, sFile, sLine);
        this.unknownType = unknownType;
    }

    public String getUnknownType() {
        return unknownType;
    }
}
