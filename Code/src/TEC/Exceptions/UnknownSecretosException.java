package TEC.Exceptions;

public class UnknownSecretosException extends UnexpectedFormatException{
    String unknownSecreto;

    public String getUnknownSecreto() {
        return unknownSecreto;
    }

    public void setUnknownSecreto(String unknownSecreto) {
        this.unknownSecreto = unknownSecreto;
    }

    public UnknownSecretosException(String unknownSecreto) {
        this.unknownSecreto = unknownSecreto;
    }

    public UnknownSecretosException(String arg0, String unknownSecreto) {
        super(arg0);
        this.unknownSecreto = unknownSecreto;
    }

    public UnknownSecretosException(String sFile, int sLine, String unknownSecreto) {
        super(sFile, sLine);
        this.unknownSecreto = unknownSecreto;
    }

    public UnknownSecretosException(String message, String sFile, int sLine, String unknownSecreto) {
        super(message, sFile, sLine);
        this.unknownSecreto = unknownSecreto;
    }
}
