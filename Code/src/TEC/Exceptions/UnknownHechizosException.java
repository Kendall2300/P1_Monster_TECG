package TEC.Exceptions;

/**
 * UnknownHechizosException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción uando se desconoce el tipo de hechizo.
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class UnknownHechizosException extends UnexpectedFormatException{
    String unknownHechizo;

    /**
     * getUnknownHechizo
     * El metodo retorna el objeto unknownHechizo.
     */
    public String getUnknownHechizo() {
        return unknownHechizo;
    }

    /**
     * setUnknownHechizo
     * El metodo coloca el parámetro unknown hechizo en un objeto de igual nombre .
     *
     * @param unknownHechizo String que contiene el tipo desconocido de la carta ingresada.
     */
    public void setUnknownHechizo(String unknownHechizo) {
        this.unknownHechizo = unknownHechizo;
    }


    /**
     * UnknownHechizosException
     * Coloca el parámetro unknown hechizo en un objeto de igual nombre
     *
     * @param unknownHechizo String que contiene el tipo desconocido de la carta ingresada.
     */
    public UnknownHechizosException(String unknownHechizo) {
        this.unknownHechizo = unknownHechizo;
    }


    /**
     * UnknownHechizosException
     * El metodo llama al constructor de la clase que hereda. Coloca el unknownHechizo en un objeto de igual nombre.
     *
     * @param arg0 Un string con el argumento del error
     */
    public UnknownHechizosException(String arg0, String unknownHechizo) {
        super(arg0);
        this.unknownHechizo = unknownHechizo;
    }


    /**
     * UnknownHechizosException
     * El metodo llama al constructor de la clase que hereda y le pasa como parámetro la línea y lugar del error.
     *
     * @param sFile String que tiene el lugar donde se encuentra el error
     * @param sLine Integer que contiene la línea del error
     * @param unknownHechizo String que contiene el tipo desconocido de carta ingresada
     *
     */
    public UnknownHechizosException(String sFile, int sLine, String unknownHechizo) {
        super(sFile, sLine);
        this.unknownHechizo = unknownHechizo;
    }


    /**
     * UnknownHechizosException
     * El metodo llama al constructor de la clase que hereda y le pasa como parámetro la linea, lugar y mensaje de error.
     *
     * @param message String que muestra el mensaje de error
     * @param sFile String que tiene el lugar donde se encuentra el error
     * @param sLine Integer que contiene la línea del error
     * @param unknownHechizo String que contiene el tipo desconocido de carta ingresada
     *
     */
    public UnknownHechizosException(String message, String sFile, int sLine, String unknownHechizo) {
        super(message, sFile, sLine);
        this.unknownHechizo = unknownHechizo;
    }
}
