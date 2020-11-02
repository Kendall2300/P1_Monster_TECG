package TEC.Exceptions;

public class UnknownHechizosException extends UnexpectedFormatException{
    String unknownHechizo;

    public String getUnknownHechizo() {
        return unknownHechizo;
    }

    public void setUnknownHechizo(String unknownHechizo) {
        this.unknownHechizo = unknownHechizo;
    }

    public UnknownHechizosException(String unknownHechizo) {
        this.unknownHechizo = unknownHechizo;
    }

    public UnknownHechizosException(String arg0, String unknownHechizo) {
        super(arg0);
        this.unknownHechizo = unknownHechizo;
    }

    public UnknownHechizosException(String sFile, int sLine, String unknownHechizo) {
        super(sFile, sLine);
        this.unknownHechizo = unknownHechizo;
    }

    public UnknownHechizosException(String message, String sFile, int sLine, String unknownHechizo) {
        super(message, sFile, sLine);
        this.unknownHechizo = unknownHechizo;
    }
}
